package com.damerla.trattor.service;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */


import com.damerla.trattor.enties.AddressEntity;
import com.damerla.trattor.enties.CustomerEntity;
import com.damerla.trattor.enties.FieldAddressEntity;
import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.exception.ChangeStatusException;
import com.damerla.trattor.exception.SaveAndUpdateException;
import com.damerla.trattor.model.CustomerModel;
import com.damerla.trattor.model.KeyValue;
import com.damerla.trattor.model.StatusType;
import com.damerla.trattor.model.UserSession;
import com.damerla.trattor.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService implements ICrudService {

    private final static Logger log = LogManager.getLogger(CustomerService.class);

    @Autowired
    private IAddressEntityRepository addressEntityRepo;


    @Autowired
    private IFieldAddressEntityRepository fieldAddressEntityRepo;

    @Autowired
    private ICompanyEntityRepository companyEntityRepo;

    @Autowired
    private UserSession userSession;

    @Autowired
    private IUserEntityRepository userEntityRepo;

    @Autowired
    private ICustomerEntityRepository customerEntityRepo;

    @Override
    public <T> Boolean saveOrUpdate(T model) {
        log.info("Start saving or update AddressEntity ------------>");
        Boolean isSaveOrUpdate = false;
        try {
            CustomerModel customerModel = (CustomerModel) model;

            CustomerEntity customerEntity = null;
            UserEntity userEntity = userEntityRepo.findByUserId(userSession.getSessionModel().getUserId());

            if (customerModel.getCustomerId() == null) {
                customerEntity = new CustomerEntity();
                customerEntity.setCreatedDate(LocalDateTime.now());
                customerEntity.setActive(false);
                customerEntity.setCrtBydUserId(userEntity);
            } else {
                customerEntity = customerEntityRepo.findByCustomerId(customerModel.getCustomerId());
            }
            customerEntity.setModifiedDate(LocalDateTime.now());
            customerEntity.setFirstName(customerModel.getFirstName());
            customerEntity.setSecondName(customerModel.getSecondName());
            customerEntity.setModByUserId(userEntity);

            customerEntity.setAddressEntity(addressEntityRepo.findByAddressId(Integer.valueOf(customerModel.getSelectedAddress())));
            Set<FieldAddressEntity> fieldAddressEntitySet = new HashSet<>();
            for (String filedAddressId: customerModel.getSelectedFiledAddress()) {
                fieldAddressEntitySet.add(fieldAddressEntityRepo.findByFieldAddressId(Integer.valueOf(filedAddressId)));
            }
            customerEntity.setFieldAddressEntities(fieldAddressEntitySet);
            customerEntityRepo.save(customerEntity);

            isSaveOrUpdate = true;

        } catch (SaveAndUpdateException e) {
            log.error("Error while save or update Customer Entity ---------->", e);
        }
        log.info("End saving or update Customer Entity ------------>");
        return isSaveOrUpdate;
    }

    @Override
    public Boolean changeStatus(String entityId, String statusType) {
        log.info("Start change Status Customer Entity ------------>");
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
            log.error("Error while  changing status of Customer Entity ----------->", e);
        }
        log.info("Start change Status Customer Entity ------------>");
        return isStatusChanged;

    }

    public CustomerModel buildCustomerModel() {
        log.info("Start build customer model ------------>");
        CustomerModel customerModel = null;
        try {
            customerModel = new CustomerModel();
            List<AddressEntity> addressEntities = addressEntityRepo.findByCompanyEntity(companyEntityRepo.findByCompanyId(userSession.getSessionModel().getCompanyId()));
            List<KeyValue> address = new ArrayList<>();
            for (AddressEntity addressEntity : addressEntities) {
                address.add(new KeyValue(addressEntity.getAddressId().toString(), addressEntity.getCity()));
            }
            customerModel.setAddress(address);

            List<KeyValue> filedAddress = new ArrayList<>();
            List<FieldAddressEntity> fieldAddressEntities = fieldAddressEntityRepo.findByCompanyEntity(companyEntityRepo.findByCompanyId(userSession.getSessionModel().getCompanyId()));
            for (FieldAddressEntity fieldAddressEntity:fieldAddressEntities) {
                filedAddress.add(new KeyValue(fieldAddressEntity.getFieldAddressId().toString(), fieldAddressEntity.getFiledName()));
            }
            customerModel.setFiledAddress(filedAddress);


        } catch (Exception e) {
            log.error("Error while building customer model--------->", e);
        }
        log.info("End build cutomer model------------>");
        return customerModel;
    }

}
