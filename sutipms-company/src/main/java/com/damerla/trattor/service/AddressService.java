package com.damerla.trattor.service;
/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.enties.AddressEntity;
import com.damerla.trattor.enties.CompanyEntity;
import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.exception.ChangeStatusException;
import com.damerla.trattor.exception.SaveAndUpdateException;
import com.damerla.trattor.model.AddressModel;
import com.damerla.trattor.model.DataTablePaginationModel;
import com.damerla.trattor.model.StatusType;
import com.damerla.trattor.model.UserSession;
import com.damerla.trattor.persistence.IAddressEntityRepository;
import com.damerla.trattor.persistence.ICompanyEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AddressService implements  ICrudService {

    private final static Logger log = LogManager.getLogger(TypeOfWorkService.class);

    @Autowired
    private IAddressEntityRepository addressEntityRepo;

    @Autowired
    private ICompanyEntityRepository companyEntityRepo;

    @Autowired
    private UserSession userSession;

    @Override
    public <T> Boolean saveOrUpdate(T model) {
        log.info("Start saving or update AddressEntity ------------>");
        Boolean isSaveOrUpdate = false;
        try {
            AddressModel addressModel = (AddressModel) model;

            AddressEntity addressEntity = null;

            if (addressModel.getAddressId() == null) {
                addressEntity = new AddressEntity();
                addressEntity.setCreatedDate(LocalDateTime.now());
                addressEntity.setModifiedDate(LocalDateTime.now());


            } else {
                addressEntityRepo.findByAddressId(addressModel.getAddressId());
                addressEntity.setAddressId(addressModel.getAddressId());
                addressEntity.setModifiedDate(LocalDateTime.now());
            }

            addressEntity.setCity(addressModel.getCity());
            addressEntity.setDistrict(addressModel.getCity());
            addressEntity.setPinCode(addressModel.getPinCode().toString());
            addressEntity.setCompanyEntity(companyEntityRepo.findByCompanyId(userSession.getSessionModel().getCompanyId()));




            addressEntityRepo.save(addressEntity);
            isSaveOrUpdate = true;

        } catch (SaveAndUpdateException e) {
            log.error("Error while save or update Address Entity ---------->", e);
        }
        log.info("End saving or update Address Entity ------------>");
        return isSaveOrUpdate;
    }

    @Override
    public Boolean changeStatus(String entityId, String statusType) {
        log.info("Start change Status Address Entity ------------>");
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
            log.error("Error while  changing status of Address Entity ----------->", e);
        }
        log.info("Start change Status Address Entity ------------>");
        return isStatusChanged;
    }

    public DataTablePaginationModel getAddress(){
        log.info("Start to get all address from database -------------->");
        DataTablePaginationModel dataTablePaginationModel = new DataTablePaginationModel();
        try {
            CompanyEntity companyEntity = companyEntityRepo.findByCompanyId(userSession.getSessionModel().getCompanyId());
            List<AddressEntity> addressEntities = addressEntityRepo.findByCompanyEntity(companyEntity);
            List<AddressModel> addressModels = new ArrayList<>();

            addressEntities.forEach(addressEntity -> {
                AddressModel addressModel = new AddressModel();
                addressModel.setCity(addressEntity.getCity());
                addressModel.setPinCode(Integer.valueOf(addressEntity.getPinCode()));
                addressModel.setState(addressEntity.getState());
                addressModels.add(addressModel);
            });

            dataTablePaginationModel.setDraw("1");
            dataTablePaginationModel.setRecordsTotal(String.valueOf(addressModels.size()));
            dataTablePaginationModel.setRecordsFiltered(String.valueOf(addressModels.size()));
            dataTablePaginationModel.setData(addressModels);

        }catch (Exception e){
            log.error("Error while fetching address ---------------->", e);
        }
        log.info("End to get all address from database -------------->");
        return  dataTablePaginationModel;
    }
}
