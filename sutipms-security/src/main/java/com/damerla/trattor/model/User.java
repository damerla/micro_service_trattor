package com.damerla.trattor.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Hari
 * @since 15/Mar/2018
 * @version 1.0.0
 *
 */
@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer userId;
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	@NotNull
	@Column(name = "second_name")
	private String secondName;
	@NotNull
	@Column(name = "phone_no")
	private String phoneNo;
	@NotNull
	@Column(name = "email")
	private String email;
	@NotNull
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@NotNull
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	@NotNull
	@Column(name = "active")
	private boolean isActive;
	@NotNull
	@Column(name = "user_type")
	private UserType userType;

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", secondName=" + secondName + ", phoneNo="
				+ phoneNo + ", email=" + email + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", isActive=" + isActive + ", userType=" + userType + "]";
	}

}
