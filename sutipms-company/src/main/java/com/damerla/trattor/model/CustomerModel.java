package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import java.io.Serializable;
import java.util.List;

public class CustomerModel  implements Serializable {

    private Integer customerId;

    private String firstName;

    private String secondName;

    private String phoneNo;

    private String email;

    private List<KeyValue>  filedAddress;

    private List<KeyValue>  Address;

    private List<String> selectedFiledAddress;

    private String selectedAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public List<KeyValue> getFiledAddress() {
        return filedAddress;
    }

    public void setFiledAddress(List<KeyValue> filedAddress) {
        this.filedAddress = filedAddress;
    }

    public List<KeyValue> getAddress() {
        return Address;
    }

    public void setAddress(List<KeyValue> address) {
        Address = address;
    }

    public List<String> getSelectedFiledAddress() {
        return selectedFiledAddress;
    }

    public void setSelectedFiledAddress(List<String> selectedFiledAddress) {
        this.selectedFiledAddress = selectedFiledAddress;
    }

    public String getSelectedAddress() {
        return selectedAddress;
    }

    public void setSelectedAddress(String selectedAddress) {
        this.selectedAddress = selectedAddress;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", filedAddress=" + filedAddress +
                ", Address=" + Address +
                ", selectedFiledAddress=" + selectedFiledAddress +
                ", selectedAddress='" + selectedAddress + '\'' +
                '}';
    }
}
