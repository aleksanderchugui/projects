package com.bionic.edu.transmoney;

import java.util.List;

public interface TransmoneyService {
	public void fillTransmoneyTable();
	public List<Transmoney> getSortedTransmoney();
	public void update(Transmoney transmoney);
	public List<Transmoney> findAll();
	public void sendMoneyToMerchants(double availableSum);
}
