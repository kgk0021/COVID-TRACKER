package com.controllers;

import com.dtos.CovidResult;
import com.models.User;
import com.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/admins")
    public String createAdmin(@RequestBody User user) {
        user.setAdmin(true);
        Integer adminId = adminService.createAdmin(user);
        return "{\"adminId\": " + adminId + "}";
    }

    @PostMapping("/admins/{adminId}/result")
    public String updateCovidResult(@RequestBody CovidResult covidResult, @PathVariable String adminId) {

        try {
            adminService.updateResult(covidResult);
            return "{\"updated\": " + true + "}";
        } catch (Exception e) {
            return "{\"updated\": " + false + "}";
        }
    }
}
