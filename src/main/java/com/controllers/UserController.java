package com.controllers;

import com.Dtos.SelfAssessment;
import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        user.setAdmin(false);
        Integer userId = userService.createUser(user);
        return "{\"userId\": " + userId + "}";
    }

    @PostMapping("/users/{userId}")
    public String selfAsses(@RequestBody SelfAssessment selfAssessment, @PathVariable String userId) {

        Integer percentage = userService.selfAsses(selfAssessment);
        return "{\"riskPercentage\": " + percentage + "}";

    }
}
