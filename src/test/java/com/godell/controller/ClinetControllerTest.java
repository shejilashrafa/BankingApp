package com.godell.controller;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.godell.bank.controller.ClientController;
import com.godell.bank.model.Account;
import com.godell.bank.model.BankTransactions;
import com.godell.bank.model.User;
import com.godell.bank.model.UserDto;
import com.godell.bank.service.ClientService;

public class ClinetControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Mock
	@Autowired
	private ClientService clientService;
	
	@InjectMocks
	private ClientController clientController;
	
	private User user;
	private UserDto userDto;
	@BeforeClass
	public void testSetUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
	}

	@Before
	public void init() {
		user=new User();
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
		
		userDto=new UserDto();
		userDto.setUserActivated(true);
		userDto.setUserCreationTime(LocalDateTime.now());
	
		
	}
	

	@Test
	public void createAccount() {
		when(clientService.createUser(user)).thenReturn(userDto);
		
		/*this.mockMvc.perform(MockMvcRequestBuilders.post("/createUser").content(asJsonString(user))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status.isCreated());
		*/	
	}
	
	/*
	 * public static String asJsonString(final Object obj) { try { return new
	 * ObjectMapper().writeValueAsString(obj); } catch (Exception e) { throw new
	 * RuntimeException(e); } }
	 */
	 
	

}
	
	
	
	


