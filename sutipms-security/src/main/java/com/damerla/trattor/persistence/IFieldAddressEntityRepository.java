package com.damerla.trattor.persistence;


/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.enties.CompanyEntity;
import com.damerla.trattor.enties.FieldAddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFieldAddressEntityRepository extends CrudRepository<FieldAddressEntity, Long> {

    FieldAddressEntity findByFieldAddressId(Integer fieldAddressId);

    List<FieldAddressEntity> findByCompanyEntity(CompanyEntity companyEntity);
}
