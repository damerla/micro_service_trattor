package com.damerla.trattor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Hari
 * @since 17/Mar/2017
 * @version 1.0.0
 *
 */
@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer addressId;
	@Column(name="land_mark")
	private String landMark;
	@Column(name="street")
	private String street;
	@Column(name="city")
	private String city;
	@Column(name="distic")
	private String distic;
	@Column(name="state")
	private String state;
	@Column(name="pincode")
	private String pincode;
	@ManyToOne
	@JoinColumn(name="LicenseeFK")
	private User users;

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



	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", landMark=" + landMark + ", street=" + street + ", city=" + city
				+ ", distic=" + distic + ", state=" + state + ", pincode=" + pincode + ", users=" + users + "]";
	}
	
	
	

}
