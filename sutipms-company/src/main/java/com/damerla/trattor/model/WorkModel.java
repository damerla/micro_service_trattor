package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import java.io.Serializable;
import java.util.List;

public class WorkModel implements Serializable {

    private Integer workId;
    private List<TypeOfWorkModel> typeOfWorkModels;
    private Integer addressId;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public List<TypeOfWorkModel> getTypeOfWorkModels() {
        return typeOfWorkModels;
    }

    public void setTypeOfWorkModels(List<TypeOfWorkModel> typeOfWorkModels) {
        this.typeOfWorkModels = typeOfWorkModels;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
