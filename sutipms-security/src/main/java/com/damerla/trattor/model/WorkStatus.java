package com.damerla.trattor.model;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


public enum WorkStatus {
    COMPLETED("Completed"), SCHEDULED("Scheduled"), CANCELED("Canceled"), RE_PLANED("RePlaned");
    private String workStatus;

    WorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String workStatus() {
        return workStatus;
    }
}
