package com.damerla.trattor.controller;/*
 *Hari
 *4/14/2018
 *@version 1.0.0
 */

import com.damerla.trattor.enties.SuperAdminEntity;
import com.damerla.trattor.model.LoginModel;
import com.damerla.trattor.model.SessionModel;
import com.damerla.trattor.model.UserSession;
import com.damerla.trattor.model.UserType;
import com.damerla.trattor.service.ILoginService;
import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private ILoginService loginService;

    @Autowired
    private UserSession userSession;

    @Autowired
    private HttpSession httpSession;

    @PostMapping("/hari")
    public String login(@ModelAttribute LoginModel loginModel, Model model) {
        String viewName = "forward:/home";
        SuperAdminEntity superAdminEntity = loginService.fetchSuperAdmin(loginModel);
        if (superAdminEntity != null) {
            boolean isValid = loginService.authentication(loginModel);
            if (isValid) {
                viewName = "forward:/super-admin/home";
                new SessionModel();
            }
            httpSession.setAttribute("name" ,superAdminEntity.getUserName());
        } else {

            viewName = "forward:/home";
        }
        return viewName;
    }

    @GetMapping("/")
    public String loginHome(){
       String  viewName = "forward:/home";
        final Authentication user = SecurityContextHolder.getContext().getAuthentication();
        httpSession.getAttributeNames();
        SecurityContext sec = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) sec.getAuthentication().getPrincipal();
        Collection<? extends GrantedAuthority> detailsAuthorities = userDetails.getAuthorities();
        String s = detailsAuthorities.toArray()[0].toString();

        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)sec.getAuthentication();
        Map<String, SessionModel> m = new HashMap<String, SessionModel>();
        SessionModel sessionModel = new SessionModel();
        sessionModel.setCompanyId(1);
        sessionModel.setUserType(UserType.valueOf(s));
        auth.setDetails(m);

        m.put("sessionModel", sessionModel);
         sessionModel = userSession.setSessionModel(new SessionModel());
        if (sessionModel.getUserType().equals(UserType.ADMIN)) {
                viewName = "forward:/dashBoard/";
        } else if(sessionModel.getUserType().equals(UserType.SUPER_ADMIN)) {

            viewName = "forward:/super-admin/";
        }
        return viewName;
    }
}

