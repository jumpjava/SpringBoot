package com.jumpjava.springboot.LoginDemo.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jumpjava.springboot.LoginDemo.Impl.controller.LoginResourceImpl;
import com.jumpjava.springboot.LoginDemo.model.User;

import ch.qos.logback.classic.Logger;

@Service
public interface LoginService {

	Logger logger = (Logger) LoggerFactory.getLogger(LoginService.class);

	public boolean validateUser(String userid, String password);
	public User addNewUsers(User user);
	public List<User> getAllUsers();

}
