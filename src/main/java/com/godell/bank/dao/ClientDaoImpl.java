package com.godell.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.godell.bank.model.Account;
import com.godell.bank.model.User;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Account getAccount(long id) {
		System.out.println("in dao");
		Session session = sessionFactory.getCurrentSession();
		Account acc= session.get(Account.class, id);
		return acc;
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public User createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		User createdUser=(User) session.merge(user);
		return createdUser;
	}

}