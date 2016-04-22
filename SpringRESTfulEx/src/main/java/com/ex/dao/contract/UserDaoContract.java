package com.ex.dao.contract;

import com.ex.entity.User;
import java.util.List;

public interface UserDaoContract {
	public User findById(int id);
	public List<User> findAll();
	public void save(User user);
	public void delete(int id);
}
