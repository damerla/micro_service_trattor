package com.damerla.trattor.service;

import com.damerla.trattor.enties.CompanyEntity;
import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.exception.SuperAdminException;
import com.damerla.trattor.model.*;
import com.damerla.trattor.persistence.ICompanyEntityRepository;
import com.damerla.trattor.persistence.IUserEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public DataTablePaginationModel getCompanyList() {
        log.info("Start to get all company entities ------------->");

        DataTablePaginationModel dataTablePaginationModel = null;
        try {
            dataTablePaginationModel = new DataTablePaginationModel();
            List<CompanyEntity> companyEntityList = companyEntityRepo.findAll();
            List<CompanyTableModel> companyTableModels = new ArrayList<>();
            for (CompanyEntity companyEntity:companyEntityList) {
                CompanyTableModel companyTableModel = new CompanyTableModel();
                companyTableModel.setCompanyName(companyEntity.getCompanyName());
                companyTableModel.setCompanyId(companyEntity.getCompanyId().toString());
                companyTableModel.setEmail(companyEntity.getEmail());
                companyTableModel.setOwner(companyEntity.getOwnerName());
                companyTableModel.setPhoneNo(companyEntity.getPhoneNo());

                companyTableModels.add(companyTableModel);
            }

            dataTablePaginationModel.setData(companyTableModels);
            dataTablePaginationModel.setDraw("1");
            dataTablePaginationModel.setRecordsFiltered(String.valueOf(companyTableModels.size()));
            dataTablePaginationModel.setRecordsTotal(String.valueOf(companyTableModels.size()));
        }catch (Exception e){
            log.error("Error while getting company entities --------->", e);
        }
        log.info("End to get all company entities ------------->");

        return dataTablePaginationModel;
    }

    public CompanyFilterModel getCompanyName(){
        List<CompanyEntity> companyEntityList = companyEntityRepo.findAll();
        List<KeyValue> comanyNameList = new ArrayList<>();
        companyEntityList.forEach(companyEntity ->{
            comanyNameList.add(new KeyValue(String.valueOf(companyEntity.getCompanyId()), companyEntity.getCompanyName()));
        });
        CompanyFilterModel companyFilterModel = new CompanyFilterModel();
        companyFilterModel.setCompanyKeyValue(comanyNameList);
        return companyFilterModel;
    }

    public DataTablePaginationModel getFilterCompanyList(){
        log.info("Start to get company list based on filter --------------.");
        DataTablePaginationModel dataTablePaginationModel = new DataTablePaginationModel();
        try {

        }catch (Exception e){
            log.error("Error while getting company details", e);
        }
        log.info("End to get company list based on filter --------------.");
        return dataTablePaginationModel;
    }

}
