package com.controllers;


import com.models.Zone;
import com.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ZoneController {
    @Autowired
    ZoneService zoneService;

    @PostMapping("/Zone/pincode/info")
    public String getZoneInfo(Zone zone) {
        String status = zoneService.getStatus(zone);
        return "{\"numCases\":\" " + zone.getNumCases() + " \",\"zoneType\":\" " + status + "\"}";

    }
}
