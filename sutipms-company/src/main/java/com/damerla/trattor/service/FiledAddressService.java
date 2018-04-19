package com.damerla.trattor.service;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.enties.FieldAddressEntity;
import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.exception.ChangeStatusException;
import com.damerla.trattor.exception.SaveAndUpdateException;
import com.damerla.trattor.model.FieldAddressModel;
import com.damerla.trattor.model.StatusType;
import com.damerla.trattor.persistence.IFieldAddressEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FiledAddressService implements ICrudService {

    private final static Logger log = LogManager.getLogger(CompanyService.class);

    @Autowired
    private IFieldAddressEntityRepository fieldAddressEntityRepo;

    @Override
    public <T> Boolean saveOrUpdate(T model) {
        log.info("Start saving or update FieldAddressEntity ------------>");
        Boolean isSaveOrUpdate = false;
        try {
            FieldAddressModel fieldAddressModel = (FieldAddressModel) model;

            FieldAddressEntity fieldAddressEntity = null;

            if (fieldAddressModel.getFieldAddressId() == null) {
                fieldAddressEntity = new FieldAddressEntity();
                fieldAddressEntity.setModifiedDate(LocalDateTime.now());
                fieldAddressEntity.setCreatedDate(LocalDateTime.now());
            } else {
                fieldAddressEntity = fieldAddressEntityRepo.findByFieldAddressId(fieldAddressModel.getFieldAddressId());
                fieldAddressEntity.setModifiedDate(LocalDateTime.now());
            }

            fieldAddressEntity.setAcres(fieldAddressModel.getAcres());



            fieldAddressEntityRepo.save(fieldAddressEntity);
            isSaveOrUpdate = true;

        } catch (SaveAndUpdateException e) {
            log.error("Error while save or update FieldAddressEntity ---------->", e);
        }
        log.info("End saving or update FieldAddressEntity ------------>");
        return isSaveOrUpdate;
    }

    @Override
    public Boolean changeStatus(String entityId, String statusType) {
        log.info("Start change Status Filed Address Entity ------------>");
        Boolean isStatusChanged = false;
        try {


            switch (StatusType.valueOf(statusType)) {
                case ACTIVE:
                    break;
                case DELETE:
                    break;
                case INACTIVE:
                    break;
            }

            isStatusChanged = true;

        } catch (ChangeStatusException e) {
            log.error("Error while  changing status of Field Address ----------->", e);
        }
        log.info("Start change Status Field Address Entity ------------>");
        return isStatusChanged;
    }
}
