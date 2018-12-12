package com.jumpjava.springboot.LoginDemo.serviceImpl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jumpjava.springboot.LoginDemo.Impl.controller.LoginResourceImpl;
import com.jumpjava.springboot.LoginDemo.model.User;
import com.jumpjava.springboot.LoginDemo.repository.UserRepository;
import com.jumpjava.springboot.LoginDemo.service.LoginService;

import ch.qos.logback.classic.Logger;

@Service
public class LoginServiceImpl implements LoginService {

	Logger logger = (Logger) LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	public boolean validateUser(String userid, String password) {

		logger.info("*******-validateUser-Called-********");
		boolean credentialMatched = false;
		boolean username = userid.equalsIgnoreCase("om");
		boolean pass = password.equalsIgnoreCase("om");

		if (username == pass) {
			credentialMatched = true;
		} else {
			credentialMatched = false;
		}
		/*
		 * return userid.equalsIgnoreCase("om") &&
		 * password.equalsIgnoreCase("om");
		 */
		logger.info("*******-Service Validation Value********" + credentialMatched);
		return credentialMatched;

	}

	@Override
	public User addNewUsers(User user) {
		logger.info("*******-Service User save sucessfully.********");
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("*******-Service Got All User sucessfully.********");
		return userRepository.findAll();
	}

}
