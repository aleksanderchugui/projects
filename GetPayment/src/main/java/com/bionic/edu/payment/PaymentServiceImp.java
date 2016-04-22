package com.bionic.edu.payment;

import java.util.List;
import javax.inject.*;

import org.springframework.transaction.annotation.Transactional;

@Named
public class PaymentServiceImp implements PaymentService {
	@Inject
	private PaymentDao paymentDao;
	
	public List<Payment> findAll() {
		return paymentDao.findAll();
	}
	
	@Transactional
	public void save(Payment payment){
		paymentDao.save(payment);
    }

}
