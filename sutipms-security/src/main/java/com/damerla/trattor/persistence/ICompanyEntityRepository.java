package com.damerla.trattor.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damerla.trattor.enties.CompanyEntity;

import java.util.List;

/**
 * 
 * @author Hari
 * @since 15/Mar/2018
 * @version 1.0.0
 *
 */
@Repository
public interface ICompanyEntityRepository extends CrudRepository<CompanyEntity, Long> {

    CompanyEntity findByCompanyId(Integer companyId);

    List<CompanyEntity> findAll();

}
