package com.damerla.trattor.service;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.exception.SaveAndUpdateException;
import com.damerla.trattor.model.StatusType;
import com.damerla.trattor.model.UserModel;
import com.damerla.trattor.persistence.IUserEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService implements ICrudService {

    private final static Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    private IUserEntityRepository userEntityRepo;

    @Override
    public <T> Boolean saveOrUpdate(T model) {
        log.info("Start saving or update userEntity ------------>");
        Boolean isSaveOrUpdate = false;
        try {
            UserModel userModel = (UserModel) model;

            UserEntity userEntity = null;

            if (userModel.getUserId() == null) {
                userEntity = new UserEntity();
                userEntity.setModifiedDate(LocalDateTime.now());
                userEntity.setCreatedDate(LocalDateTime.now());
                userEntity.setActive(false);
            } else {
                userEntity = userEntityRepo.findByUserId(userModel.getUserId());
                userEntity.setModifiedDate(LocalDateTime.now());
            }

            userEntity.setEmail(userModel.getEmail());
            userEntity.setFirstName(userModel.getFirstName());
            userEntity.setSecondName(userModel.getLastName());
            userEntity.setPhoneNo(userModel.getPhoneNo());
            userEntity.setUserType(userModel.getSelectedUserType());

            userEntityRepo.save(userEntity);
            isSaveOrUpdate = true;

        } catch (SaveAndUpdateException e) {
            log.error("Error while save or update UserEntity ---------->", e);
        }
        log.info("End saving or update userEntity ------------>");
        return isSaveOrUpdate;
    }

    @Override
    public Boolean changeStatus(String entiryId, String statusType) {
        log.info("Start change Status userEntity ------------>");
        Boolean isStatusChanged = false;
        try {

            UserEntity userEntity = userEntityRepo.findByUserId(Integer.valueOf(entiryId));

            switch (StatusType.valueOf(statusType)) {
                case ACTIVE:
                    userEntity.setActive(true);
                    break;
                case DELETE:
                    break;
                case INACTIVE:
                    userEntity.setActive(false);
                    break;
            }

            userEntityRepo.save(userEntity);
            isStatusChanged = true;

        } catch (SaveAndUpdateException e) {
            log.error("Error while  changing status of UserEntity ----------->", e);
        }

        log.info("End change status userEntity ------------>");
        return isStatusChanged;
    }
}
