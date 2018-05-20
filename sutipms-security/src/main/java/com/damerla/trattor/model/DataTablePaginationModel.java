package com.damerla.trattor.model;/*
 /*
 * @author Hari
 * @date 4/14/2018
 * @version 1.0.0
 */

import java.io.Serializable;
import java.util.List;

public class DataTablePaginationModel implements Serializable {
    private String draw;
    private String recordsTotal;
    private String recordsFiltered;
    private List<?> data;

    public DataTablePaginationModel(String draw, String recordsTotal, String recordsFiltered, List<?> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public DataTablePaginationModel() {
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(String recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public String getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(String recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataTablePaginationModel{" +
                "draw='" + draw + '\'' +
                ", recordsTotal='" + recordsTotal + '\'' +
                ", recordsFiltered='" + recordsFiltered + '\'' +
                ", data=" + data +
                '}';
    }
}
