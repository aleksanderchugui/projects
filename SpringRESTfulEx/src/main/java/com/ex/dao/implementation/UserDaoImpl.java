package com.ex.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ex.dao.contract.UserDaoContract;
import com.ex.entity.User;

@Repository
public class UserDaoImpl implements UserDaoContract{
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	@Override
	public User findById(int id) {
		session = sessionFactory.openSession();
		User user = (User)session.load(User.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return user;
	}

	@Override
	public List<User> findAll() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> userList = session.createCriteria(User.class).list();
		tx.commit();
		session.close();
		return userList;
	}

	@Override
	public void save(User user) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		session = sessionFactory.openSession();
		Object o = session.load(User.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		
	}

}
