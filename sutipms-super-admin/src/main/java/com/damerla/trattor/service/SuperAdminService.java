package com.damerla.trattor.service;

import com.damerla.trattor.enties.CompanyEntity;
import com.damerla.trattor.exception.SuperAdminException;
import com.damerla.trattor.model.CompanyModel;
import com.damerla.trattor.persistence.ICompanyEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SuperAdminService implements ISuperAdminService {

    private final static Logger log = LogManager.getLogger(SuperAdminService.class);

    @Autowired
    private ICompanyEntityRepository companyEntityRepo;


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
            companyEntity.setModifiedDate(LocalDateTime.now());
            companyEntityRepo.save(companyEntity);

        } catch (SuperAdminException e) {
            log.error("Error while saving CompanyModel ------------>", e);
        }
        log.info("End to save company entity ------------->");

        return false;
    }
}
