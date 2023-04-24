package com.godell.bank.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godell.bank.dao.ClientDao;
import com.godell.bank.model.Account;
import com.godell.bank.model.User;
import com.godell.bank.model.UserDto;
//import com.godell.bank.repository.AccountRepo;
import com.godell.bank.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientDao clientDao;


	@Override
	public Account getAccount(long id) {
		System.out.println("In service "+id);
		return clientDao.getAccount(id);
		 
	}


	@Override
	public UserDto createUser(User user) {
		
		//List<User> allUsers=clientDao.getAllUsers();
		
		
		user.setUserActivateStatus(true);
		user.setDateOfBirth(LocalDate.now());
		User createdUser=clientDao.createUser(user);
		UserDto userDetails=new UserDto();
		userDetails.setUserAccountId(createdUser.getAccount().get(0).getSourceAccountId());
		userDetails.setUserActivated(true);
		userDetails.setUserCreationTime(createdUser.getAccount().get(0).getCreatedAt());
		userDetails.setUserId(createdUser.getUserId());
		return userDetails;
	}

}