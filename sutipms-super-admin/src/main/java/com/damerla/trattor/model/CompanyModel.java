package com.damerla.trattor.model;


import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author haribabu
 * @version 1.0.0
 * @since 01/Apr/2018
 */
@Component
public class CompanyModel implements Serializable {

    private String companyName;
    private String phoneNo;
    private String email;
    private String address;
    private String ownerName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "CompanyModel{" +
                "companyName='" + companyName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
