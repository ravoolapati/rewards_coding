package com.java.retailer.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.retailer.bean.Trans;

@Service
public class TransactionServiceImpl{
	
	public Map<String, Integer> getRewardPoints(List<Trans> transactionList) {
		Map<String, Integer> monthSpent = new HashMap<>();
		
		transactionList.forEach(transaction -> {
			String month = transaction.getTransDate().getMonth().name();
			int rewards = 0;
			if(transaction.getSpentAmount() < 50) {
				rewards = 0;
			} else if(transaction.getSpentAmount() <=100 && transaction.getSpentAmount() > 50) {
				rewards = transaction.getSpentAmount() - 50;
			} else if(transaction.getSpentAmount() > 100) {
				rewards = ((transaction.getSpentAmount()-50)/50) + (2* transaction.getSpentAmount()-100);
			}

			if(monthSpent.containsKey(month)){
				
				int total = monthSpent.get(month) + rewards;
				monthSpent.put(month, total);
			} else {
				monthSpent.put(month, rewards);
			}
		});
		return monthSpent;
	}
}
