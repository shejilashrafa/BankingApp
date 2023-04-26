package com.godell.dao.impl;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.godell.bank.dao.ClientDao;
import com.godell.bank.model.Account;
import com.godell.bank.model.BankTransactions;
import com.godell.bank.model.User;

public class ClientDaoTest {
	
	@Autowired
	ClientDao clientDao;
	
	@Test
	public void createUser() {
		User user=new User();
		user.setAccountType("Individual");
		user.setDateOfBirth(LocalDate.of(2013, 10, 24));
		user.setEmail("xyz@gmail.com");
		user.setMobileNumber(889988999);
		user.setPan("wer45");
		user.setUserActivateStatus(true);
		user.setUserName("Tom");
	
		Account account=new Account();
		account.setAccountType("Savings");
		account.setBalance(0);
		account.setCreatedAt(LocalDateTime.now());
		account.setUser(user);
		
		List<Account> accList=new ArrayList<>();
		accList.add(account);
		
		
		BankTransactions bankTransactions=new BankTransactions();
		bankTransactions.setAccount(account);
		bankTransactions.setAccountType("Savings");
		bankTransactions.setAmount(0);
		bankTransactions.setCurrency("USD");
		bankTransactions.setOperation("BalanceCheck");
		bankTransactions.setTran_sastus("Success");
		bankTransactions.setTransacctionTime(LocalDateTime.now());
		
		List<BankTransactions> tranList=new ArrayList<>();
		tranList.add(bankTransactions);
		account.setTransactions(tranList);
		user.setAccount(accList);
		
		/*
		 * BankTransactions bankTransactions=new BankTransactions();
		 * bankTransactions.setAccount(account);
		 * bankTransactions.setAccountType("Savings"); bankTransactions.setAmount(0);
		 */
		clientDao.createUser(user);
		assertEquals("wer45", user.getPan());
		
	}
}
