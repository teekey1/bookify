package com.codecool.bookify.Controller;

import com.codecool.bookify.Model.Role;
import com.codecool.bookify.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> getRoles(){
        return roleService.getAll();
    }

    @GetMapping("roles/{id}")
    public Role getRole(@PathVariable Long id){
        return roleService.getById(id);
    }

    @DeleteMapping("roles/{id}")
    public void removeRole(@PathVariable Long id) {
        roleService.delete(id);
    }

    @PostMapping("/roles")
    public void addRole(@RequestBody Role role){
        roleService.insert(role);
    }

    @PutMapping("/roles/{id}")
    public void updateRole(@RequestBody Role user, @PathVariable Long id) {
    }
}
