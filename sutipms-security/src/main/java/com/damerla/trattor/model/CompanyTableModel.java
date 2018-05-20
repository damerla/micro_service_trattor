package com.damerla.trattor.model;


/*
 * @author  Hari
 * @date  5/6/2018
 * @version 1.0.0
 */

import java.io.Serializable;

public class CompanyTableModel implements Serializable {

    private String companyId;
    private String companyName;
    private String email;
    private String owner;
    private String phoneNo;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "CompanyTableModel{" +
                "comapanyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", owner='" + owner + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
