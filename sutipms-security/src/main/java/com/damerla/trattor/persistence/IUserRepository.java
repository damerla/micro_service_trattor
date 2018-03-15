package com.damerla.trattor.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damerla.trattor.model.User;

/**
 * 
 * @author Hari
 * @since 15/Mar/2018
 * @version 1.0.0
 *
 */
@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
	public User findByUserId(Integer userId);

}
