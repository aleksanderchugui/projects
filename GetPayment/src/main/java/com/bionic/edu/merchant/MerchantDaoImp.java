package com.bionic.edu.merchant;

import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;


@Repository
public class MerchantDaoImp implements MerchantDao{
	@PersistenceContext
    private EntityManager em;
	
	public List<Merchant> getSortedMerchants() {
		TypedQuery<Merchant> query = em.createQuery ("SELECT m FROM Merchant m ORDER BY m.lastSent, m.needToSend", Merchant.class);
    	List<Merchant> lM = query.getResultList();
    	
    	return lM;
	}	

	public void update(Merchant merchant) {
		em.merge(merchant);
	}
	
	public List<Merchant> findAll() {
		TypedQuery<Merchant> query = em.createQuery("SELECT"
				+ " m FROM Merchant m", Merchant.class);
		List<Merchant> listM = query.getResultList();
		return listM;
	}
}
