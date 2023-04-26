package com.godell.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;


import com.godell.bank.dao.ClientDao;
import com.godell.bank.model.Account;
import com.godell.bank.model.BankTransactions;
import com.godell.bank.model.User;
import com.godell.bank.model.UserDto;
import com.godell.bank.service.ClientService;
import com.godell.bank.service.impl.ClientServiceImpl;

public class ClientServiceTest {
	   @Mock
	    private ClientDao clientDao;

	    @InjectMocks
	    private ClientServiceImpl clientService;
	   
	    
	    private User user;
	    private UserDto userDetails;
	    
	    @BeforeClass
		public void setUp() throws Exception {
			MockitoAnnotations.initMocks(this);
			user=new User();
			user.setUserId(1L);
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
			
			userDetails=new UserDto();
			userDetails.setUserActivated(true);
			userDetails.setUserCreationTime(LocalDateTime.now());
	    }
	    @Test
	    public void testCreateUser() {
	    	//User updatedUser=clientDao.createUser(user);
	    	given(clientDao.createUser(user)).willReturn(user);
	    	userDetails=new UserDto();
			userDetails.setUserAccountId(user.getAccount().get(0).getSourceAccountId());
			userDetails.setUserActivated(true);
			userDetails.setUserCreationTime(user.getAccount().get(0).getCreatedAt());
			userDetails.setUserId(user.getUserId());
			
			UserDto updatedUserDto = clientService.createUser(user);
			assertEquals(1L, updatedUserDto.getUserId());

	    }
	    
	
}
