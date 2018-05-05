package com.damerla.trattor.model;


/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

public class SessionModel implements Serializable {
    private Integer companyId;
    private Integer userId;
    private UserType userType;
    private String menuType;

    public SessionModel() {
    }

    public SessionModel(Integer companyId, Integer userId, UserType userType) {
        this.companyId = companyId;
        this.userId = userId;
        this.userType = userType;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        return "SessionModel{" +
                "companyId=" + companyId +
                ", userId=" + userId +
                ", userType=" + userType +
                ", menuType='" + menuType + '\'' +
                '}';
    }
}
