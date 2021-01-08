package com.codecool.bookify.Service;

import com.codecool.bookify.Exceptions.NotFoundException;
import com.codecool.bookify.Model.Role;
import com.codecool.bookify.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements HelperService<Role>{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) return role.get();
        throw new NotFoundException();
    }

    @Override
    public void update(Role role, Long id) {
    }

    @Override
    public void insert(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
