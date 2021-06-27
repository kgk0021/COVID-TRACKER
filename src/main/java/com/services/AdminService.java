package com.services;

import com.Dtos.CovidResult;
import com.models.User;
import com.models.Zone;
import com.repos.UserRepo;
import com.repos.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ZoneRepo zoneRepo;

    public Integer createAdmin(User user) {
        Zone zone;
        try {
            zone = zoneRepo.findById(user.getPinCode()).get();

        } catch (Exception e) {
            zone = new Zone();
            zone.setNumCases(0);
            zone.setPinCode(user.getPinCode());
            zoneRepo.saveAndFlush(zone);
        }
        userRepo.saveAndFlush(user);
        return user.getUser_id();
    }

    public void updateResult(CovidResult covidResult) {
        User admin = userRepo.findById(Integer.valueOf(covidResult.getAdminId())).get();
        if (admin == null || !admin.getAdmin()) throw new RuntimeException("fraud admin or incorrect user");
        User user = userRepo.findById(Integer.valueOf(covidResult.getAdminId())).get();
        user.setResult(covidResult.getResult());
        userRepo.saveAndFlush(user);
        Zone zone = zoneRepo.findById(user.getPinCode()).get();
        if (covidResult.getResult().equals("positive"))
            zone.setNumCases(zone.getNumCases() + 1);
        if (covidResult.getResult().equals("negative"))
            zone.setNumCases(zone.getNumCases() - 1);
        zoneRepo.saveAndFlush(zone);
    }
}
