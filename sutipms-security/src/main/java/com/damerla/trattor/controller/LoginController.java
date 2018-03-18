package com.damerla.trattor.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damerla.trattor.model.User;
import com.damerla.trattor.model.UserType;
import com.damerla.trattor.persistence.IUserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private IUserRepository  userRep;
	
	@GetMapping("/")
	public String  login() {
		User user = new User();
		user.setActive(true);
		user.setEmail("hari@gmail.com");
		user.setCreatedDate(LocalDateTime.now());
		user.setModifiedDate(LocalDateTime.now());
		user.setFirstName("Hari");
		user.setSecondName("Babu");
		user.setPhoneNo("9492559426");
		user.setUserType(UserType.EMPLOEE);
		userRep.save(user);
		
		return "login";
	}
	@PostMapping("/calling")
	public String  login(Model model) {
		return "login";
	}

}
