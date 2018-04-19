package com.damerla.trattor.service;

import com.damerla.trattor.enties.CompanyEntity;
import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.exception.SuperAdminException;
import com.damerla.trattor.model.CompanyModel;
import com.damerla.trattor.model.UserType;
import com.damerla.trattor.persistence.ICompanyEntityRepository;
import com.damerla.trattor.persistence.IUserEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SuperAdminService implements ISuperAdminService {

    private final static Logger log = LogManager.getLogger(SuperAdminService.class);

    @Autowired
    private ICompanyEntityRepository companyEntityRepo;

    @Autowired
    private IUserEntityRepository userEntityRepo;


    @Override
    public boolean saveCompany(CompanyModel companyModel) {
        log.info("Start to save company entity ------------->");
        try {
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setActive(false);
            companyEntity.setCompanyName(companyModel.getCompanyName());
            companyEntity.setCreatedDate(LocalDateTime.now());
            companyEntity.setEmail(companyModel.getEmail());
            companyEntity.setPhoneNo(companyModel.getPhoneNo());
            companyEntity.setOwnerName(companyModel.getOwnerName());
            companyEntity.setModifiedDate(LocalDateTime.now());
            companyEntityRepo.save(companyEntity);
            UserEntity userEntity = new UserEntity();
            userEntity.setActive(false);
            userEntity.setUserType(UserType.ADMIN);
            userEntity.setPhoneNo(companyModel.getPhoneNo());
            userEntity.setFirstName(companyModel.getOwnerName());
            userEntity.setSecondName(companyEntity.getOwnerName());
            userEntity.setEmail(companyEntity.getEmail());
            userEntity.setModifiedDate(LocalDateTime.now());
            userEntity.setCreatedDate(LocalDateTime.now());
            userEntity.setPassword(new BCryptPasswordEncoder().encode("55java"));
            userEntity.setCompanyEntity(companyEntity);
            userEntityRepo.save(userEntity);


        } catch (SuperAdminException e) {
            log.error("Error while saving CompanyModel ------------>", e);
        }
        log.info("End to save company entity ------------->");

        return false;
    }
}
