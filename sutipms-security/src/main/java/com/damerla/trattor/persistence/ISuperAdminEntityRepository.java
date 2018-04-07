package com.damerla.trattor.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.damerla.trattor.enties.SuperAdminEntity;

@Repository
public interface ISuperAdminEntityRepository extends CrudRepository<SuperAdminEntity, Long> {
    public SuperAdminEntity findBySuperAdminId(Integer superAdminId);

    /**
     * <p>Give's {@link SuperAdminEntity} instance based on userNmae and password.</p>
     */

    public SuperAdminEntity findByUserNameAndPassword(String userName, String password);

}
