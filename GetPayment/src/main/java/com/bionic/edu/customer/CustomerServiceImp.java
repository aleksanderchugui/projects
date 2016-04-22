package com.bionic.edu.customer;

import javax.inject.*;

import org.springframework.transaction.annotation.Transactional;

@Named
public class CustomerServiceImp implements CustomerService{
	@Inject
    private CustomerDao customerDao;
	
	@Transactional
	public void save(Customer customer){
		customerDao.save(customer);
	}
}
