package com.damerla.trattor.model;

import java.io.Serializable;

/**
 * 
 * @author Hari
 * @since 19/Mar/2018
 * @version 1.0.0
 *
 */
public class LoginModel implements Serializable {

	private static final long serialVersionUID = 8012113940715085053L;

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [userName=" + userName + ", password=" + password + "]";
	}

}
