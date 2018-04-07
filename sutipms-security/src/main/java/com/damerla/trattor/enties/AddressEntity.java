package com.damerla.trattor.enties;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Hari
 * @since 17/Mar/2017
 * @version 1.0.0
 *
 */
@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	@Column(name = "land_mark")
	private String landMark;
	@Column(name = "street")
	private String street;
	@Column(name = "city")
	private String city;
	@Column(name = "distic")
	private String distic;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private String pincode;
	@ManyToOne
	@JoinColumn(name = "user_FK")
	private UserEntity users;
	@NotNull
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@NotNull
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

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

	public String getDistic() {
		return distic;
	}

	public void setDistic(String distic) {
		this.distic = distic;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
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
		return "Address [addressId=" + addressId + ", landMark=" + landMark + ", street=" + street + ", city=" + city
				+ ", distic=" + distic + ", state=" + state + ", pincode=" + pincode + ", users=" + users
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
