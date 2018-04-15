package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/14/2018
 * @version 1.0.0
 */


public enum StatusType {
    ACTIVE("Active"), INACTIVE("In Active"), DELETE("Delete");
    private String statusType;

    StatusType(String statusType) {
        this.statusType = statusType;
    }

    public String statusType() {
        return statusType;
    }
}
