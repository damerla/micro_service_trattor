package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

public class AddressModel implements Serializable {
    private Integer addressId;
    private String landMark;
    private String street;
    private String city;
    private String state;
    private Integer pinCode;
    private String country;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "addressId=" + addressId +
                ", landMark='" + landMark + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", country='" + country + '\'' +
                '}';
    }
}
