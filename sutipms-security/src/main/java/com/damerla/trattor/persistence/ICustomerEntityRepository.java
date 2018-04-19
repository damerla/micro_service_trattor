package com.damerla.trattor.persistence;

/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.enties.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerEntityRepository  extends CrudRepository<CustomerEntity, Long> {

    CustomerEntity findByCustomerId(Integer customerId);
}
