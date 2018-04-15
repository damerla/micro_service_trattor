package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


public enum PaymentStatus {
    PAYED("Payed"), PENDING("Pending"), PARTIAL_PAYED("Partial Payed");
    private String paymentStatus;

    PaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String paymentStatus() {
        return paymentStatus;
    }
}
