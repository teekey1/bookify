package com.codecool.bookify.service;

import com.codecool.bookify.exceptions.NotFoundException;
import com.codecool.bookify.model.Role;
import com.codecool.bookify.model.User;
import com.codecool.bookify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements HelperService<User> {

    protected UserRepository userRepository;

    @Autowired
    private RoleService roleService;

//    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.roleService = roleService;
    }

//    @Autowired
//    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void update(User user, Long id) {
    }

    @Override
    public void insert(User user) {
        user.setId(null);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setActive(true);
//        user.getRoles().addAll(
//                user.getRoles()
//                        .stream()
//                        .map(u -> {
//                            Role role = roleService.getById(u.getId());
//                            role.getUsers().add(user);
//                            return role;
//                        }).collect(Collectors.toSet()));
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
