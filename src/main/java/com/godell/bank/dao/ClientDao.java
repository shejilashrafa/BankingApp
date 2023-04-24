package com.godell.bank.dao;

import java.util.List;

import com.godell.bank.model.Account;
import com.godell.bank.model.User;

public interface ClientDao {

	
	Account getAccount(long id);

	User createUser(User user);

	List<User> getAllUsers();

}
