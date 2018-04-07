package com.damerla.trattor.enties;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Hari
 * @since 18/Mar/2018
 * @version 1.0.0
 *
 */
@Table(name = "company")
@Entity
public class CompanyEntity {

	@Id
	@Column(name = "company_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	@NotBlank
	@Column(name = "comany_name")
	private String companyName;
	@NotBlank
	@Column(name = "phone_no")
	private String phoneNo;
	@OneToOne
	@JoinColumn(name="address_id")
	private AddressEntity address;
	@Column(name = "status")
	private boolean isActive;
	@Column(name = "email")
	private String email;
	@OneToMany
	@Column(name = "user_fk")
	private Set<UserEntity> users;
	@NotNull
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@NotNull
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

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

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	@Override
	public String toString() {
		return "CompanyEntity [companyId=" + companyId + ", companyName=" + companyName + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", isActive=" + isActive + ", email=" + email + ", users=" + users
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
