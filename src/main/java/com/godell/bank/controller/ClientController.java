package com.godell.bank.controller;

import static com.godell.bank.util.BankingAppConstants.ACC_ID;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godell.bank.exception.AccountNotFoundException;
import com.godell.bank.model.Account;
import com.godell.bank.model.User;
import com.godell.bank.model.UserDto;
import com.godell.bank.service.ClientService;

@RestController()
public class ClientController {
	private static final Log logger=LogFactory.getLog(ClientController.class);
	
	

	@Autowired
	ClientService clientService;
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createAccount(@Valid @RequestBody User user) {
		UserDto createdUser=clientService.createUser(user);
		
		
		return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);
		
	}

	@GetMapping("/getAccount")
	public ResponseEntity<Account> getAccountwithId(@RequestParam long id) {
		Account account = clientService.getAccount(id);
		if(account==null)
		{
			logger.info("Account id "+id+" is invalid");
			throw new AccountNotFoundException(ACC_ID+id);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

}