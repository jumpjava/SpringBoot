package com.jumpjava.springboot.LoginDemo.Impl.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jumpjava.springboot.LoginDemo.controller.LoginResource;
import com.jumpjava.springboot.LoginDemo.model.User;
import com.jumpjava.springboot.LoginDemo.repository.UserRepository;
import com.jumpjava.springboot.LoginDemo.service.LoginService;

import ch.qos.logback.classic.Logger;

//http://localhost:8080/login/

@Controller
@SessionAttributes("name")
public class LoginResourceImpl implements LoginResource {

	Logger logger = (Logger) LoggerFactory.getLogger(LoginResourceImpl.class);

	@Autowired
	LoginService service;
	@Autowired
	UserRepository userRepository;

	@Override
	public String addNewUsers(ModelMap model, User user) {

		boolean isSucess = false;

		logger.info("************* addNewUsers-Called. ***********");

		try {
			service.addNewUsers(user);
			isSucess = true;
			logger.info("************* User save sucessfully. ***********");
		} catch (Exception e) {
			isSucess = false;
			logger.info("****** Exception Occured while creating User. *******" + e.getMessage());
		}

		model.put("name", user.getUserId());
		model.put("password", user.getPassword());

		if (isSucess = false) {
			logger.info("************* Page redirect to-LoginCreateError . ***********");
			return "loginCreateError";
		} else {
			logger.info("************* Page redirect to-LoginCreateSuccess. ***********");
			return "loginCreateSuccess";
		}

	}

	public String showLoginPage() {
		System.out.println("--------------------------------------------IAMFROMLOGIN-----------");
		logger.info("*******-showLoginPage-Called-********");
		return "login";
	}

	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		boolean isValidUser = service.validateUser(name, password);
		logger.info("*******-show WelcomePage-Called-********");

		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			logger.error("*******-Invalid login Credentials-********");
			return "login";
		}

		model.put("name", name);
		model.put("password", password);

		return "welcome";
	}

	@Override
	public String showcreateNewUsers() {
		logger.info("*******-showcreateNewUsers-Called-********");
		return "userRegistration";
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("*******-getAllUsers-Called-********");
		List<User> allUser =service.getAllUsers();
		Iterator<User> itr=allUser.iterator();
		while(itr.hasNext()){
			
			System.out.println("User Name -"+itr.next().getUserId());
			//System.out.println("User Password -"+itr.next().getPassword());
		}
		
		
		
		return allUser;
	}

}
