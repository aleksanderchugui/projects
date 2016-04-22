package com.bionic.edu.payment;

import java.util.List;

public interface PaymentDao {
	public List<Payment> findAll();
	public void save(Payment payment);
}
