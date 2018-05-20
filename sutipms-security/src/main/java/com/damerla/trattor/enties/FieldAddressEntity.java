package com.damerla.trattor.enties;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "field_address")
public class FieldAddressEntity {

    @Id
    @Column(name = "field_address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fieldAddressId;

    @NotNull
    @Column(name = "filed_name")
    private String filedName;

    @Column(name = "land_mark")
    private String landMark;

    @NotNull
    @Column(name = "acres")
    private Double acres;

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

    @NotNull
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;


    @ManyToOne
    @JoinColumn(name = "customer_id_fk")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "work_entity_fk")
    private WorkEntity workEntity;

    @NotNull
    @OneToOne
    @JoinColumn(name = "company_id")
    private  CompanyEntity companyEntity;

    public Integer getFieldAddressId() {
        return fieldAddressId;
    }

    public void setFieldAddressId(Integer fieldAddressId) {
        this.fieldAddressId = fieldAddressId;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public Double getAcres() {
        return acres;
    }

    public void setAcres(Double acres) {
        this.acres = acres;
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

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public WorkEntity getWorkEntity() {
        return workEntity;
    }

    public void setWorkEntity(WorkEntity workEntity) {
        this.workEntity = workEntity;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    @Override
    public String toString() {
        return "FieldAddressEntity{" +
                "fieldAddressId=" + fieldAddressId +
                ", filedName='" + filedName + '\'' +
                ", landMark='" + landMark + '\'' +
                ", acres=" + acres +
                ", isDelete=" + isDelete +
                ", crtBydUserId=" + crtBydUserId +
                ", modByUserId=" + modByUserId +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", customerEntity=" + customerEntity +
                ", workEntity=" + workEntity +
                ", companyEntity=" + companyEntity +
                '}';
    }
}
