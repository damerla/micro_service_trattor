package com.damerla.trattor.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damerla.trattor.enties.UserEntity;

/**
 * 
 * @author Hari
 * @since 15/Mar/2018
 * @version 1.0.0
 *
 */
@Repository
public interface IUserEntityRepository extends CrudRepository<UserEntity, Long> {
	public UserEntity findByUserId(Integer userId);

	public UserEntity findByEmail(String email);


	//public UserEntity findByEmailAndActive(String email,Boolean isActive);

}
