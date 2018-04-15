package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


public enum TypeOfWork {
    FIELD_WORK("Filed Work"), TRANSPORT("Transport");
    private String typeOfWork;

    TypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public String typeOfWork() {
        return typeOfWork;
    }
}
