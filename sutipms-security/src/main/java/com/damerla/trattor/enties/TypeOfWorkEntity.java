package com.damerla.trattor.enties;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.model.TypeOfWork;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "type_of_work")
public class TypeOfWorkEntity {

    @Id
    @Column(name = "type_of_work_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeOfWorkId;

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

    @NotNull
    @Column(name = "type_of_work")
    @Enumerated(EnumType.STRING)
    private TypeOfWork typeOfWork;

    @NotNull
    @Column(name = "price")
    private Double price;


    public Integer getTypeOfWorkId() {
        return typeOfWorkId;
    }

    public void setTypeOfWorkId(Integer typeOfWorkId) {
        this.typeOfWorkId = typeOfWorkId;
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

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TypeOfWorkEntity{" +
                "typeOfWorkId=" + typeOfWorkId +
                ", workName='" + workName + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", isActive=" + isActive +
                ", isDelete=" + isDelete +
                ", crtBydUserId=" + crtBydUserId +
                ", modByUserId=" + modByUserId +
                ", companyEntity=" + companyEntity +
                ", typeOfWork=" + typeOfWork +
                ", price=" + price +
                '}';
    }
}
