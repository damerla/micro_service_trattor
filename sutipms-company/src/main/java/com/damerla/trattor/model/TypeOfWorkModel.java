package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.enties.UserEntity;

import java.io.Serializable;

public class TypeOfWorkModel implements Serializable {
    private Integer typeOfWorkId;
    private String workName;
    private Double price;
    private String description;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypeOfWorkModel{" +
                "typeOfWorkId=" + typeOfWorkId +
                ", workName='" + workName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
