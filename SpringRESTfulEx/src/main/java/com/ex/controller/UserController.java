package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ex.entity.User;
import com.ex.services.contract.UserServiceContract;

@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	UserServiceContract userService;
	
	@RequestMapping(value = "add", method = RequestMethod.POST, headers="Accept=application/json")
	public void save(User user) {
		userService.save(user);
	}
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, headers="Accept=application/json")
	public User findById(@PathVariable("id") int id) {
		User user = null;
		user = userService.findById(id);
		return user;
	}

	@RequestMapping(value = "all", headers="Accept=application/json")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET, headers="Accept=application/json")
	public void delete(@PathVariable("id") int id) {
		userService.delete(id);
	}
}
