package com.jumpjava.springboot.LoginDemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jumpjava.springboot.LoginDemo.model.User;

@Controller
@SessionAttributes("name")
public interface LoginResource {

	@RequestMapping(value = "/showlogin", method = RequestMethod.GET)
	public String showcreateNewUsers();
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addNewUsers(ModelMap model,@RequestBody User user);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage();
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password);
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUsers();
	
}
