package com.godell.bank.dao;

import com.godell.bank.model.Account;
import com.godell.bank.model.User;

public interface ClientDao {

	
	Account getAccount(long id);

	User createUser(User user);

}
