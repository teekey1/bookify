package com.codecool.bookify.Controller;

import com.codecool.bookify.Model.User;
import com.codecool.bookify.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getById(id);
    }

    @DeleteMapping("users/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        userService.insert(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
    }
}
