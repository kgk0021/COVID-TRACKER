package com.Dtos;

import javax.persistence.*;
import java.util.ArrayList;


public class SelfAssessment {

    Integer SelfAssessmentId;


    ArrayList<String> symptomps;

    public SelfAssessment() {
    }

    public Integer getSelfAssessmentId() {
        return SelfAssessmentId;
    }

    public void setSelfAssessmentId(Integer selfAssessmentId) {
        SelfAssessmentId = selfAssessmentId;
    }

    public ArrayList<String> getSymptomps() {
        return symptomps;
    }

    public void setSymptomps(ArrayList<String> symptomps) {
        this.symptomps = symptomps;
    }

    public Boolean getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(Boolean travelHistory) {
        this.travelHistory = travelHistory;
    }

    public Boolean getContactWithCovidPatient() {
        return contactWithCovidPatient;
    }

    public void setContactWithCovidPatient(Boolean contactWithCovidPatient) {
        this.contactWithCovidPatient = contactWithCovidPatient;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    Boolean travelHistory;


    Boolean contactWithCovidPatient;


    String user_id;

}
