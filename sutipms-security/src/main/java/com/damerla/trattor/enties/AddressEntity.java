package com.damerla.trattor.enties;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Hari
 * @version 1.0.0
 * @since 17/Mar/2017
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

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "pin_code")
    private String pinCode;

    @ManyToOne
    @JoinColumn(name = "user_FK")
    private UserEntity users;

    @NotNull
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "company_id")
    private  CompanyEntity companyEntity;

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
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

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "addressId=" + addressId +
                ", landMark='" + landMark + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", users=" + users +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", companyEntity=" + companyEntity +
                '}';
    }
}
