package com.damerla.trattor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damerla.trattor.enties.AddressEntity;
import com.damerla.trattor.enties.CompanyEntity;
import com.damerla.trattor.enties.SuperAdminEntity;
import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.exception.LoginException;
import com.damerla.trattor.model.LoginModel;
import com.damerla.trattor.model.UserType;
import com.damerla.trattor.persistence.IAddressEntityRepository;
import com.damerla.trattor.persistence.ICompanyEntityRepository;
import com.damerla.trattor.persistence.ISuperAdminEntityRepository;
import com.damerla.trattor.persistence.IUserEntityRepository;

/**
 * @author Hari
 * @version 1.0.0
 * @since 18/Mar/2018
 */
@Service
@Transactional(readOnly = true)
public class LoginService implements ILoginService {

    private final static Logger log = LogManager.getLogger(LoginService.class);

    @Autowired
    private IUserEntityRepository userEntityRepo;

    @Autowired
    private IAddressEntityRepository addressEntityRepo;

    @Autowired
    private ICompanyEntityRepository companyEntityRepo;

    @Autowired
    private ISuperAdminEntityRepository superAdminEntityRepo;

    /*
     * (non-Javadoc)
     *
     * @see com.damerl.tattor.service.ILoginService#authentication(java.lang.String,
     * java.lang.String)
     */
    @Override
    public boolean authentication(LoginModel loginModel) {

        return true;
    }

    @Override
    public SuperAdminEntity fetchSuperAdmin(LoginModel loginModel) {
        log.info("Start get superAdmin details -------------->");
        SuperAdminEntity superAdminEntity = null;
        try {
            superAdminEntity = superAdminEntityRepo.findByUserNameAndPassword(loginModel.getUserName(), loginModel.getPassword());
        } catch (Exception e) {
            log.error("Error while getting superAdmin ------>", e);
        }
        log.info("End get superAdmin details -------------->");

        return superAdminEntity;
    }

    @Override
    @Transactional(readOnly = false)
    public void createDefaultUser() {

        log.info("Start to create defalut user ---------------------------->");
        try {
            UserEntity userEntity = userEntityRepo.findByUserId(1);
            if (userEntity == null) {
                UserEntity entity = new UserEntity();
                entity.setActive(true);
                AddressEntity address = new AddressEntity();
                address.setCity("koduru");
                address.setCreatedDate(LocalDateTime.now());
                address.setDistrict("krishna");
                address.setLandMark("ramalayam");
                address.setModifiedDate(LocalDateTime.now());
                address.setPinCode("521328");
                address.setState("AP");
                address.setStreet("");
                address.setUsers(entity);
                addressEntityRepo.save(address);
                List<AddressEntity> addressList = new ArrayList<>();
                entity.setAddress(addressList);
                CompanyEntity companyEntity = new CompanyEntity();
                companyEntity.setActive(true);
                companyEntity.setAddress(address);
                companyEntity.setCompanyName("Damerla");
                companyEntity.setCreatedDate(LocalDateTime.now());
                companyEntity.setModifiedDate(LocalDateTime.now());
                companyEntity.setEmail("raghu@gmail.com");
                companyEntity.setPhoneNo("9492559426");
                Set<UserEntity> users = new HashSet<>();
                users.add(entity);
                companyEntity.setUsers(users);
                companyEntityRepo.save(companyEntity);
                entity.setCompanyEntity(companyEntity);
                entity.setCreatedDate(LocalDateTime.now());
                entity.setEmail("raghu@gmail.com");
                entity.setFirstName("Nagamuni");
                entity.setModifiedDate(LocalDateTime.now());
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                entity.setPassword(bCryptPasswordEncoder.encode("55java"));
                entity.setPhoneNo("9666439898");
                entity.setSecondName("Damerla");
                entity.setUserType(UserType.EMPLOYEE);
                userEntityRepo.save(entity);
            }

        } catch (LoginException e) {
            log.error("Error while create  default user -----------------> ", e);
        }
        log.info("Start to create defalut user--------------------------->");
    }

    @Transactional(readOnly = false)
    @Override
    public void createSuperAdmin() {
        log.info("Start to create superAdmin --------------------->");
        try {
            SuperAdminEntity entity = superAdminEntityRepo.findBySuperAdminId(1);
            if (entity == null) {
                SuperAdminEntity superAdminEntity = new SuperAdminEntity();
                superAdminEntity.setActive(true);
                superAdminEntity.setCreatedDate(LocalDateTime.now());
                superAdminEntity.setModifiedDate(LocalDateTime.now());
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                superAdminEntity.setPassword(bCryptPasswordEncoder.encode("55java"));
                superAdminEntity.setUserName("Raghu");
                superAdminEntity.setPhoneNo("9492559426");
                superAdminEntity.setEmail("hari@gmail.com");
                superAdminEntity.setAdminDeleted(false);
                superAdminEntity.setUserType(UserType.SUPER_ADMIN);
                superAdminEntityRepo.save(superAdminEntity);
            }
        } catch (LoginException e) {
            log.error("Error while createing super admin --------------->", e);
        }
        log.info("End to cteate superAdmin --------------------->");
    }

}
