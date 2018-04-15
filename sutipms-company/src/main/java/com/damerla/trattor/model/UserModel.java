package com.damerla.trattor.model;

/*
 * @author  Hari
 * @date  4/14/2018
 * @version 1.0.0
 */

import java.io.Serializable;
import java.util.Arrays;

public class UserModel implements Serializable {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String isActive;
    private String password;
    private UserType selectedUserType;
    private UserType[] userTypes;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getSelectedUserType() {
        return selectedUserType;
    }

    public void setSelectedUserType(UserType selectedUserType) {
        this.selectedUserType = selectedUserType;
    }

    public UserType[] getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(UserType[] userTypes) {
        this.userTypes = userTypes;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", isActive='" + isActive + '\'' +
                ", password='" + password + '\'' +
                ", selectedUserType='" + selectedUserType + '\'' +
                ", userTypes=" + Arrays.toString(userTypes) +
                '}';
    }
}
