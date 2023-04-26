package com.godell.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.godell.bank.dao.BankTransactionDao;
import com.godell.bank.model.Account;

public class TransactionTest {
	
	@Autowired
	BankTransactionDao bankTransactionDao;
		
	@Autowired
	private SessionFactory sessionFactory;

	
	@Test
	public Account getAccountWithAccountIdTest(long accountId) {
		Session session = sessionFactory.getCurrentSession();
		Account account= session.get(Account.class, accountId);
		return account;
	}
	

}
