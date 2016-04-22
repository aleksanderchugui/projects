package com.bionic.edu.transmoney;

import java.time.LocalDate;
import java.util.List;
import javax.inject.*;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.merchant.Merchant;
import com.bionic.edu.merchant.MerchantService;


@Named
public class TransmoneyServiceImp implements TransmoneyService{
	@Inject
	private TransmoneyDao transmoneyDao;
	
	@Transactional
	public void fillTransmoneyTable() {
		LocalDate dt = LocalDate.now();
		java.sql.Date sentDate = java.sql.Date.valueOf(dt);
		for(Merchant m : transmoneyDao.getMerchantsForFill()) {
    		LocalDate lastsent = m.getLastSent().toLocalDate();
    		switch(m.getPeriod()) {
    			case 1:
    				lastsent = lastsent.plusWeeks(1);
    				break;
    				
    			case 2:
    				lastsent = lastsent.plusDays(10);
    				break;
    				
    			case 3:
    				lastsent = lastsent.plusMonths(1);
    				break;
    		}
    		if((m.getNeedToSend() > m.getMinSum()) && (dt.isAfter(lastsent))) {
    			Transmoney t = new Transmoney();
    			t.setMerchantId(m.getId());
    			t.setSumSent(m.getNeedToSend());
    			t.setSentDate(sentDate);
    			transmoneyDao.save(t);
    		}
    	}
	}
	
	@Transactional
	public List<Transmoney> getSortedTransmoney() {
		return transmoneyDao.getSortedTransmoney();
	}
	
	@Transactional
	public void update(Transmoney transmoney) {
		transmoneyDao.update(transmoney);
	}
	
	public List<Transmoney> findAll() {
		return transmoneyDao.findAll();
	}
	@Transactional
	public void sendMoneyToMerchants(double availableSum) {
		java.time.LocalDate ld = java.time.LocalDate.now();
		java.time.Instant instant = ld.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant();
    	java.sql.Date dt = new java.sql.Date(java.util.Date.from(instant).getTime());
    	double sumInUse = 0.0;
    	org.springframework.context.ApplicationContext context = new   
		    	org.springframework.context.support.ClassPathXmlApplicationContext 
	        	("spring/application-config.xml");
			MerchantService merchantService = (MerchantService)context.getBean("merchantServiceImp");
    	for(Merchant m : merchantService.getSortedMerchants()) {
    		for(Transmoney t : transmoneyDao.getSortedTransmoney()) {
    			if(m.getId() == t.getMerchantId()) {
    					if(t.getSumSent() > availableSum) {
    						continue;
    					}
    				sumInUse += t.getSumSent();
    					if(sumInUse > availableSum) {
    						break;
    					}
    				m.setSent(Math.round((m.getSent() + t.getSumSent()) * 100.0) / 100.0);
    				m.setNeedToSend(0.0);
    				m.setLastSent(dt);
    				t.setStatus((short)1);
    				merchantService.update(m);
    				transmoneyDao.update(t);
    			}
    		}
    	}
	}
}
