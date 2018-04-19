package com.damerla.trattor.sevice;


/*
 * @author  Hari
 * @date  4/19/2018
 * @version 1.0.0
 */

import com.damerla.trattor.enties.SuperAdminEntity;
import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.persistence.ISuperAdminEntityRepository;
import com.damerla.trattor.persistence.IUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserEntityRepository userEntityRepo;

    @Autowired
    ISuperAdminEntityRepository superAdminEntityRepo;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = null;
        SuperAdminEntity superAdminEntity = superAdminEntityRepo.findByUserNameAndAdminDeleted(userEmail, false);
        if (superAdminEntity != null) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(superAdminEntity.getUserType().name());

            user = new User(superAdminEntity.getUserName(), superAdminEntity.getPassword(), Arrays.asList(grantedAuthority));
        } else {
            UserEntity userEntity = userEntityRepo.findByEmail(userEmail);
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userEntity.getUserType().name());
            user = new User(userEntity.getEmail(), userEntity.getPassword(), Arrays.asList(simpleGrantedAuthority));
        }
        UserDetails userDetails = (UserDetails) user;

        return userDetails;
    }
}
