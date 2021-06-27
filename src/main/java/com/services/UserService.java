package com.services;

import com.Dtos.SelfAssessment;
import com.models.User;
import com.models.Zone;
import com.repos.UserRepo;
import com.repos.ZoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ZoneRepo zoneRepo;
    public Integer createUser(User user) {
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

    public Integer selfAsses(SelfAssessment selfAssessment) {
        // algorithm not implemneted because of lack of time
        return 95;
    }
}
