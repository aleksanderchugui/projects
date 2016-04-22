package com.ex.services.contract;

import java.util.List;
import com.ex.entity.User;

public interface UserServiceContract {
	public User findById(int id);
	public List<User> findAll();
	public void save(User user);
	public void delete(int id);
}
