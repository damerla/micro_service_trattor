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
@Table(name = "work")
public class WorkEntity {
    @Id
    @Column(name = "work_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workId;


    @NotNull
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @NotNull
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "create_by_user_id")
    private UserEntity crtBydUserId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "modified_by_user_id")
    private UserEntity modByUserId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "work_assign_user_id")
    private UserEntity workAssignedUserId;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @NotNull
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @NotNull
    @Column(name = "total_amount")
    private Double totalAmount;
    @NotNull
    @Column(name = "payed_amount")
    private Double payedAmount;

    @NotNull
    @Column(name = "due_amount")
    private Double dueAmount;

    @NotNull
    @Column(name = "advance_amount")
    private Double advanceAmount;

    @Column(name = "description")
    private String description;

    @NotNull
    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @NotNull
    @OneToMany
    @Column(name = "filed_address_fk")
    private Set<FieldAddressEntity> fieldAddressEntity;


    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
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

    public UserEntity getWorkAssignedUserId() {
        return workAssignedUserId;
    }

    public void setWorkAssignedUserId(UserEntity workAssignedUserId) {
        this.workAssignedUserId = workAssignedUserId;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Double payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(Double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public Set<FieldAddressEntity> getFieldAddressEntity() {
        return fieldAddressEntity;
    }

    public void setFieldAddressEntity(Set<FieldAddressEntity> fieldAddressEntity) {
        this.fieldAddressEntity = fieldAddressEntity;
    }

    @Override
    public String toString() {
        return "WorkEntity{" +
                "workId=" + workId +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", crtBydUserId=" + crtBydUserId +
                ", modByUserId=" + modByUserId +
                ", workAssignedUserId=" + workAssignedUserId +
                ", companyEntity=" + companyEntity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalAmount=" + totalAmount +
                ", payedAmount=" + payedAmount +
                ", dueAmount=" + dueAmount +
                ", advanceAmount=" + advanceAmount +
                ", description='" + description + '\'' +
                ", customerEntity=" + customerEntity +
                ", fieldAddressEntity=" + fieldAddressEntity +
                '}';
    }
}
