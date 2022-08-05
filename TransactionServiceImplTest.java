package com.java.retailer.serviceimpl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import com.java.retailer.bean.Trans;


public class TransactionServiceImplTest {

	private TransactionServiceImpl transactionServiceImpl;
	
	@Before
	public void setup() {
		transactionServiceImpl = new TransactionServiceImpl();
	}
	
	@Test
	public void transactionLessThan50() {
		Map<String, Integer> result = transactionServiceImpl.getRewardPoints(getSampleData(25));
		assertEquals("{AUGUST=0}", result.toString());
	}
	
	@Test
	public void transactionBetween50To100() {
		Map<String, Integer> result = transactionServiceImpl.getRewardPoints(getSampleData(75));
		assertEquals("{AUGUST=50}", result.toString());
	}

	@Test
	public void transactionEqualTo100() {
		Map<String, Integer> result = transactionServiceImpl.getRewardPoints(getSampleData(100));
		assertEquals("{AUGUST=100}", result.toString());
	}
	
	@Test
	public void transactionGreaterThan100() {
		Map<String, Integer> result = transactionServiceImpl.getRewardPoints(getSampleData(110));
		assertEquals("{AUGUST=242}", result.toString());
	}

	private List<Trans> getSampleData(int amount) {
		Trans trans = new Trans();
		trans.setSpentAmount(amount);
		trans.setTransDate(LocalDateTime.now());
		List<Trans> transList = new ArrayList<Trans>();
		transList.add(trans);
		Trans trans1 = new Trans();
		trans1.setSpentAmount(amount);
		trans1.setTransDate(LocalDateTime.now());
		transList.add(trans1);
		return transList;
	}
}
