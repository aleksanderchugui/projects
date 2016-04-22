package com.ex.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.dao.contract.UserDaoContract;
import com.ex.entity.User;
import com.ex.services.contract.UserServiceContract;

@Service
@Transactional
public class UserServiceImpl implements UserServiceContract {

	@Autowired
	UserDaoContract userData;
	
	@Override
	public User findById(int id) {
		return userData.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userData.findAll();
	}

	@Override
	public void save(User user) {
		userData.save(user);
		
	}

	@Override
	public void delete(int id) {
		userData.delete(id);
		
	}

}
