package com.damerla.trattor.enties;

import com.damerla.trattor.model.UserType;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Hari
 * @version 1.0.0
 * @since 19/Mar/2018
 */
@Entity
@Table(name = "superadmin")
public class SuperAdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "super_admin_id")
    private Integer superAdminId;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "status")
    private boolean isActive;

    @NotNull
    @Column(name = "is_deleted")
    private boolean adminDeleted;

    @NotNull
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @NotNull
    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Integer getSuperAdminId() {
        return superAdminId;
    }

    public void setSuperAdminId(Integer superAdminId) {
        this.superAdminId = superAdminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
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

    public boolean isAdminDeleted() {
        return adminDeleted;
    }

    public void setAdminDeleted(boolean adminDeleted) {
        this.adminDeleted = adminDeleted;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "SuperAdminEntity{" +
                "superAdminId=" + superAdminId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", adminDeleted=" + adminDeleted +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }

}
