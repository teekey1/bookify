package com.codecool.bookify.controller;

import com.codecool.bookify.model.User;
import com.codecool.bookify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping()
    public void addUser(@RequestBody User user){
        userService.insert(user);
    }

    @PutMapping(value = "/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
    }
}
