package com.godell.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.godell.bank.model.Account;


@Repository
@Transactional
public class BankTransactionDaoImpl implements BankTransactionDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Account getAccountWithAccountId(long accountId) {
		Session session = sessionFactory.getCurrentSession();
		Account account= session.get(Account.class, accountId);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		Account updatedAccount=(Account) session.merge(account);
		return updatedAccount;
		
	}
	

}
