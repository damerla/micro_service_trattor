package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.enties.CustomerEntity;
import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.enties.WorkEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

public class FieldAddressModel implements Serializable {

    private Integer fieldAddressId;

    private String filedName;

    private String landMark;

    private Double acres;

    private boolean isDelete;


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

    @Override
    public String toString() {
        return "FieldAddressModel{" +
                "fieldAddressId=" + fieldAddressId +
                ", filedName='" + filedName + '\'' +
                ", landMark='" + landMark + '\'' +
                ", acres=" + acres +
                ", isDelete=" + isDelete +
                '}';
    }
}
