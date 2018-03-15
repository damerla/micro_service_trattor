package com.damerla.trattor.model;

/**
 * 
 * @author Hari
 * @since 15/Mar/2018
 * @version 1.0.0
 *
 */
public enum UserType {
	Admin("admin"), NORMAL("normal"), EMPLOEE("emploee");
	private String userType;

	UserType(String userType) {
		this.userType = userType;
	}

	public String userType() {
		return userType;
	}

}
