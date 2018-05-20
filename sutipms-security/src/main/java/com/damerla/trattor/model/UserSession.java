package com.damerla.trattor.model;


/*
 * @author  Hari
 * @date  4/15/2018
 * @version 1.0.0
 */

import com.damerla.trattor.enties.UserEntity;
import com.damerla.trattor.persistence.IUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserSession  implements Serializable {

    private SessionModel sessionModel;

    @Autowired
    private IUserEntityRepository userEntityRepo;

    @Autowired
    private HttpSession httpSession;

    public SessionModel getSessionModel() {
        AbstractAuthenticationToken auth = (AbstractAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Map<String, SessionModel> m = (Map<String, SessionModel>) auth.getDetails();

        sessionModel = m.get("sessionModel");
        return sessionModel;
    }

    public SessionModel setSessionModel(SessionModel sessionModel) {
        final Authentication user = SecurityContextHolder.getContext().getAuthentication();
        SecurityContext sec = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) sec.getAuthentication().getPrincipal();
        Collection<? extends GrantedAuthority> detailsAuthorities = userDetails.getAuthorities();
        String s = detailsAuthorities.toArray()[0].toString();

        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)sec.getAuthentication();
        Map<String, SessionModel> m = new HashMap<String, SessionModel>();
        UserEntity userEntity = userEntityRepo.findByEmail(userDetails.getUsername());
       if(userEntity!=null) {
           sessionModel.setCompanyId(userEntity.getCompanyEntity().getCompanyId());
           sessionModel.setUserId(userEntity.getUserId());
       }
        sessionModel.setUserType(UserType.valueOf(s));

        switch (UserType.valueOf(s)){
            case ADMIN:
                sessionModel.setMenuType("Admin");
                break;
            case SUPER_ADMIN:
                sessionModel.setMenuType(UserType.SUPER_ADMIN.name());
                break;

            case NORMAL:
                sessionModel.setMenuType("Normal");
                break;

        }

        httpSession.setAttribute("sessionModel", sessionModel);


        m.put("sessionModel", sessionModel);
        auth.setDetails(m);


        this.sessionModel = sessionModel;
        return sessionModel;
    }
}
