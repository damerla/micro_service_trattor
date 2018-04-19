package com.damerla.trattor.model;


/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import java.io.Serializable;

public class UserSession  implements Serializable {

    private SessionModel sessionModel;

    public SessionModel getSessionModel() {
        return sessionModel;
    }

    public void setSessionModel(SessionModel sessionModel) {
        this.sessionModel = sessionModel;
    }
}
