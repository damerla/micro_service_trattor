package com.damerla.trattor.service;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.exception.SaveAndUpdateException;
import com.damerla.trattor.model.AddressModel;
import com.damerla.trattor.model.StatusType;
import com.damerla.trattor.model.WorkModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class WorkService implements ICrudService {

    private final static Logger log = LogManager.getLogger(WorkService.class);

    @Override
    public <T> Boolean saveOrUpdate(T model) {
        log.info("Start saving or update AddressEntity ------------>");
        Boolean isSaveOrUpdate = false;
        try {
            WorkModel workModel = (WorkModel) model;

            UserEntity userEntity = null;

            if (workModel.getWorkId() == null) {
                /*userEntity = new UserEntity();
                userEntity.setModifiedDate(LocalDateTime.now());
                userEntity.setCreatedDate(LocalDateTime.now());
                userEntity.setActive(false);*/
            } else {
              /*  userEntity = userEntityRepo.findByUserId(userModel.getUserId());
                userEntity.setModifiedDate(LocalDateTime.now());*/
            }

           /* userEntity.setEmail(userModel.getEmail());
            userEntity.setFirstName(userModel.getFirstName());
            userEntity.setSecondName(userModel.getLastName());
            userEntity.setPhoneNo(userModel.getPhoneNo());
            userEntity.setUserType(userModel.getSelectedUserType());

            userEntityRepo.save(userEntity);*/
            isSaveOrUpdate = true;

        } catch (SaveAndUpdateException e) {
            log.error("Error while save or update Address Entity ---------->", e);
        }
        log.info("End saving or update Address Entity ------------>");
        return isSaveOrUpdate;
    }

    @Override
    public Boolean changeStatus(String entityId, String statusType) {
        log.info("Start change Status Work Entity ------------>");
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

        } catch (SaveAndUpdateException e) {
            log.error("Error while  changing status of Work Entity ----------->", e);
        }
        log.info("Start change Status Work Entity ------------>");
        return isStatusChanged;
    }
}
