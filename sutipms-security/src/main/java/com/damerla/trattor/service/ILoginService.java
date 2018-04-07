package com.damerla.trattor.service;

import com.damerla.trattor.enties.SuperAdminEntity;
import org.springframework.stereotype.Service;

import com.damerla.trattor.model.LoginModel;

/**
 * 
 * @author Hari
 * @since 18/Mar/2018
 * @version 1.0.0
 *
 */
@Service
public interface ILoginService {
	/**
	 * <p>
	 * This {@link #authentication(String, String)} is used to authentication login
	 * <b>user</b> .
	 * </p>
	 * 
	 * @param loginModel
	 * @return {@code boolean}
	 */
	public boolean authentication(LoginModel loginModel);

	public SuperAdminEntity fetchSuperAdmin(LoginModel loginModel);

	public void createDefaultUser();
	
	public void createSuperAdmin();

}
