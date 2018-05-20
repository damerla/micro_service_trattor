package com.damerla.trattor.model;


/*
 * @author  Hari
 * @date  5/20/2018
 * @version 1.0.0
 */

import java.time.temporal.ValueRange;
import java.util.List;

public class CompanyFilterModel {

    private String companyName;
    private List<KeyValue> companyKeyValue;

    public CompanyFilterModel(String companyName, List<KeyValue> companyKeyValue) {
        this.companyName = companyName;
        this.companyKeyValue = companyKeyValue;
    }

    public CompanyFilterModel() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<KeyValue> getCompanyKeyValue() {
        return companyKeyValue;
    }

    public void setCompanyKeyValue(List<KeyValue> companyKeyValue) {
        this.companyKeyValue = companyKeyValue;
    }

    @Override
    public String toString() {
        return "CompanyFilterModel{" +
                "companyName='" + companyName + '\'' +
                ", companyKeyValue=" + companyKeyValue +
                '}';
    }
}
