package com.CrimeRecord.CrimeRecord;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Investigation {

    @Id
    private String investigationId;

    private String caseId;
    private String officerName;
    private String investigationDate;
    private String investigationDetails;
    private String evidence;
    private String status;

    public Investigation() {
    }

    public String getInvestigationId() {
        return investigationId;
    }

    public void setInvestigationId(String investigationId) {
        this.investigationId = investigationId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getInvestigationDate() {
        return investigationDate;
    }

    public void setInvestigationDate(String investigationDate) {
        this.investigationDate = investigationDate;
    }

    public String getInvestigationDetails() {
        return investigationDetails;
    }

    public void setInvestigationDetails(String investigationDetails) {
        this.investigationDetails = investigationDetails;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}