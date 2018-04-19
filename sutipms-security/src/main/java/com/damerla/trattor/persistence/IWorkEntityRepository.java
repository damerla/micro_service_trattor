package com.damerla.trattor.persistence;


/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.enties.WorkEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorkEntityRepository extends CrudRepository<WorkEntity, Long> {
    WorkEntity findByWorkId(Integer workId);
}
