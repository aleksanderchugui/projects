package com.bionic.edu.merchant;

import java.util.List;


public interface MerchantDao {
	public List<Merchant> getSortedMerchants();
	public void update(Merchant merchant);
	public List<Merchant> findAll();
}
