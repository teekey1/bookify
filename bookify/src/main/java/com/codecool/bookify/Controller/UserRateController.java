package com.codecool.bookify.Controller;

import com.codecool.bookify.Model.UserRate;
import com.codecool.bookify.Service.UserRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRateController {
    private final UserRateService userRateService;

    @Autowired
    public UserRateController(UserRateService userRateService) {
        this.userRateService = userRateService;
    }

    @GetMapping("/users-rates")
    public List<UserRate> getUsersRates(){
        return userRateService.getAll();
    }

    @GetMapping("users-rates/{id}")
    public UserRate getUserRate(@PathVariable Long id){
        return userRateService.getById(id);
    }

    @DeleteMapping("users-rates/{id}")
    public void removeUserRate(@PathVariable Long id) {
        userRateService.delete(id);
    }

    @PostMapping("/users-rates")
    public void addUserRate(@RequestBody UserRate userRate){
        userRateService.insert(userRate);
    }

    @PutMapping("/users-rates/{id}")
    public void updateUserRate(@RequestBody UserRate userRate, @PathVariable Long id) {
    }
}
