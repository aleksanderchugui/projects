package com.bionic.edu.payment;

import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImp implements PaymentDao {
	@PersistenceContext
	private EntityManager em;
	
	public List<Payment> findAll() {
		TypedQuery<Payment> query = em.createQuery("SELECT"
				+ " p FROM Payment p", Payment.class);
		List<Payment> listP = query.getResultList();
		return listP;
	}
	
	public void save(Payment payment){
    	em.persist(payment);
    }

}
