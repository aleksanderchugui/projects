package com.bionic.edu.merchant;

import java.util.List;
import javax.inject.*;
import org.springframework.transaction.annotation.Transactional;


@Named
public class MerchantServiceImp implements MerchantService{
	@Inject
    private MerchantDao merchantDao;
	
	@Transactional
	public List<Merchant> getSortedMerchants() {
		return merchantDao.getSortedMerchants();
	}
	
	@Transactional
	public void update(Merchant merchant) {
		merchantDao.update(merchant);
	}
	
	public List<Merchant> findAll() {
		return merchantDao.findAll();
	}
}
