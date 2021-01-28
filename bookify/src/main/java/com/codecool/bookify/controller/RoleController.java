package com.codecool.bookify.controller;

import com.codecool.bookify.model.Role;
import com.codecool.bookify.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public List<Role> getRoles(){
        return roleService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Role getRole(@PathVariable Long id){
        return roleService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeRole(@PathVariable Long id) {
        roleService.delete(id);
    }

    @PostMapping()
    public void addRole(@RequestBody Role role){
        roleService.insert(role);
    }

    @PutMapping(value = "/{id}")
    public void updateRole(@RequestBody Role user, @PathVariable Long id) {
    }
}
