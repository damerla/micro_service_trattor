package com.damerla.trattor.persistence;

import com.damerla.trattor.enties.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damerla.trattor.enties.AddressEntity;

import java.util.List;

/**
 * 
 * @author Hari
 * @since 15/Mar/2018
 * @version 1.0.0
 *
 */
@Repository
public interface IAddressEntityRepository extends CrudRepository<AddressEntity, Long> {

    AddressEntity findByAddressId(Integer addressId);

    List<AddressEntity> findByCompanyEntity(CompanyEntity companyEntity);

}
