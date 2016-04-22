package com.bionic.edu.merchant;

import java.util.List;

public interface MerchantService {
	public List<Merchant> getSortedMerchants();
	public void update(Merchant merchant);
	public List<Merchant> findAll();
}

