package com.services;

import com.models.Zone;
import org.springframework.stereotype.Service;

@Service
public class ZoneService {
    public String getStatus(Zone zone) {
        // algo not implemented becasue of lack of time
        // zone row and get numcases and based on num cases i am going to return ORANGE GREEN RED
        return "GREEN";
    }
}
