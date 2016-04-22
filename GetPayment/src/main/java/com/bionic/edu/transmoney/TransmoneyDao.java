package com.bionic.edu.transmoney;

import java.util.List;
import com.bionic.edu.merchant.Merchant;

public interface TransmoneyDao {
	public List<Merchant> getMerchantsForFill();
	public List<Transmoney> getSortedTransmoney();
	public void update(Transmoney transmoney);
	public List<Transmoney> findAll();
	public void save(Transmoney t);
}
