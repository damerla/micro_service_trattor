package com.damerla.trattor.model;


/*
 * @author  Hari
 * @date  5/6/2018
 * @version 1.0.0
 */


import java.io.Serializable;

public class KeyValue implements Serializable {

    private String key;
    private String value;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public KeyValue() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
