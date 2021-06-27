package com.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zone {
    public Zone() {
    }

    @Id
    String pinCode;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getNumCases() {
        return numCases;
    }

    public void setNumCases(Integer numCases) {
        this.numCases = numCases;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Column
    Integer numCases;

    String zoneType;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.MERGE)
    List<User> users;


}
