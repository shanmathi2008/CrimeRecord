package com.CrimeRecord.CrimeRecord;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Suspect {

    @Id
    private String suspectId;

    private String suspectName;
    private String caseId;
    private String crimeType;
    private String location;
    private String status;

    public Suspect() {
    }

    public String getSuspectId() {
        return suspectId;
    }

    public void setSuspectId(String suspectId) {
        this.suspectId = suspectId;
    }

    public String getSuspectName() {
        return suspectName;
    }

    public void setSuspectName(String suspectName) {
        this.suspectName = suspectName;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}