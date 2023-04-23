package com.godell.bank.service;

import com.godell.bank.model.Account;
import com.godell.bank.model.User;
import com.godell.bank.model.UserDto;

public interface ClientService {

	//void create(Account clientRequest);

	Account getAccount(long id);

	UserDto createUser(User user);

}
