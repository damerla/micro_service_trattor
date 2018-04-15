package com.damerla.trattor.enties;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

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
    @Column(name = "work_name")
    private String workName;

    @NotNull
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "active")
    private boolean isActive;

    @NotNull
    @Column(name = "is_delete")
    private boolean isDelete;

    @NotNull
    @OneToOne
    @JoinColumn(name = "create_by_user_id")
    private UserEntity crtBydUserId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "modified_by_user_id")
    private UserEntity modByUserId;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToMany
    @Column(name = "field_address_fk")
    private Set<FieldAddressEntity> fieldAddressEntities;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
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

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public UserEntity getCrtBydUserId() {
        return crtBydUserId;
    }

    public void setCrtBydUserId(UserEntity crtBydUserId) {
        this.crtBydUserId = crtBydUserId;
    }

    public UserEntity getModByUserId() {
        return modByUserId;
    }

    public void setModByUserId(UserEntity modByUserId) {
        this.modByUserId = modByUserId;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public Set<FieldAddressEntity> getFieldAddressEntities() {
        return fieldAddressEntities;
    }

    public void setFieldAddressEntities(Set<FieldAddressEntity> fieldAddressEntities) {
        this.fieldAddressEntities = fieldAddressEntities;
    }


    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", workName='" + workName + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", isActive=" + isActive +
                ", isDelete=" + isDelete +
                ", crtBydUserId=" + crtBydUserId +
                ", modByUserId=" + modByUserId +
                ", companyEntity=" + companyEntity +
                ", addressEntity=" + addressEntity +
                ", fieldAddressEntities=" + fieldAddressEntities +
                '}';
    }
}
