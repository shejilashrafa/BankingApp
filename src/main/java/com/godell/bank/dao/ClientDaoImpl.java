package com.godell.bank.dao;

import java.util.List;

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
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}
	
	@Override
	public Account getAccount(long id) {
		System.out.println("in dao");
		Session session = getSession();
		Account acc= session.get(Account.class, id);
		System.out.println("in dao2"+acc);
		return acc;
		
	}

	
	@Override
	public User createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		//User createdUser=(User) session.merge(user);
		session.save(user);
		return user;
	}


	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> allUsers=session.createQuery("SELECT user FROM user a", User.class).getResultList();      
		return allUsers;
	}

}