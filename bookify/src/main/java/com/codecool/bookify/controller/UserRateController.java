package com.codecool.bookify.controller;

import com.codecool.bookify.model.UserRate;
import com.codecool.bookify.service.UserRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users-rates")
public class UserRateController {
    private final UserRateService userRateService;

    @Autowired
    public UserRateController(UserRateService userRateService) {
        this.userRateService = userRateService;
    }

    @GetMapping()
    public List<UserRate> getUsersRates(){
        return userRateService.getAll();
    }

    @GetMapping(value = "/{id}")
    public UserRate getUserRate(@PathVariable Long id){
        return userRateService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeUserRate(@PathVariable Long id) {
        userRateService.delete(id);
    }

    @PostMapping()
    public void addUserRate(@RequestBody UserRate userRate){
        userRateService.insert(userRate);
    }

    @PutMapping(value = "/{id}")
    public void updateUserRate(@RequestBody UserRate userRate, @PathVariable Long id) {
    }
}
