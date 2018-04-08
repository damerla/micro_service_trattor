package com.damerla.trattor.model;


import java.io.Serializable;

/**
 * @author haribabu
 * @version 1.0.0
 * @since 01/Apr/2018
 */
public class CompanyModel implements Serializable {


    private String companyName;
    private String phoneNo;
    private String email;
    private String address;

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

    @Override
    public String toString() {
        return "CompanyModel{" +
                "companyName='" + companyName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
