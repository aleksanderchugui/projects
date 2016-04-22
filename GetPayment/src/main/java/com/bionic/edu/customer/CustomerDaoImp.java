package com.bionic.edu.customer;

import javax.persistence.*;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImp implements CustomerDao{
	@PersistenceContext
    private EntityManager em;
	
	public void save(Customer customer){
    	if (customer.getId() == 0){
    		em.persist(customer);
    	} else{
    		em.merge(customer);
    	}
    }
}
