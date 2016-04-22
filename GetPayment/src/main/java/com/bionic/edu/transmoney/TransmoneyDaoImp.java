package com.bionic.edu.transmoney;

import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import com.bionic.edu.merchant.Merchant;


@Repository
public class TransmoneyDaoImp implements TransmoneyDao{
	@PersistenceContext
	private EntityManager em;
	public List<Merchant> getMerchantsForFill(){
    	TypedQuery<Merchant> query = em.createQuery ("SELECT m FROM Merchant m ORDER BY m.needToSend", Merchant.class);
    	List<Merchant> lM = query.getResultList();
    	return lM;
    }
	
	public List<Transmoney> getSortedTransmoney() {
		TypedQuery<Transmoney> query = em.createQuery ("SELECT t FROM Transmoney t WHERE t.status = '0' ORDER BY t.sentDate,t.sumSent Desc", Transmoney.class);
		List<Transmoney> lT = query.getResultList();
		return lT;
	}
	
	public void update(Transmoney transmoney) {
		em.merge(transmoney);
	}
	
	public List<Transmoney> findAll() {
		TypedQuery<Transmoney> query = em.createQuery("SELECT"
				+ " t FROM Transmoney t", Transmoney.class);
		List<Transmoney> listP = query.getResultList();
		return listP;
	}
	
	public void save(Transmoney t) {
		em.persist(t);
	}
}
