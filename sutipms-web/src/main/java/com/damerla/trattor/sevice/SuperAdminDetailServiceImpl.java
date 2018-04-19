package com.damerla.trattor.sevice;


/*
 * @author  Hari
 * @date  4/18/2018
 * @version 1.0.0
 */

import com.damerla.trattor.enties.SuperAdminEntity;
import com.damerla.trattor.persistence.ISuperAdminEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SuperAdminDetailServiceImpl implements UserDetailsService {
    @Autowired
    ISuperAdminEntityRepository superAdminEntityRepo;

    @Override
    public UserDetails loadUserByUsername(String superAdminName) throws UsernameNotFoundException {

        SuperAdminEntity superAdminEntity = superAdminEntityRepo.findByUserNameAndAdminDeleted(superAdminName, false);
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(superAdminEntity.getUserType().name());

        User user = new User(superAdminEntity.getUserName(), superAdminEntity.getPassword(), Arrays.asList(grantedAuthority));
        UserDetails userDetails = (UserDetails) user;
        return userDetails;
    }
}
