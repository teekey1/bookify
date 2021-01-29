package com.codecool.bookify.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

    @GetMapping("/")
    public String home() {
        return ("<h1>welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>welcome user</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>welcome admin</h1>");
    }

    @GetMapping("/owner")
    public String owner() {
        return ("<h1>welcome owner</h1>");
    }
}
