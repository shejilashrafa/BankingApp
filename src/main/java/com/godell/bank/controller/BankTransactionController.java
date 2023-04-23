package com.godell.bank.controller;

import static com.godell.bank.util.BankingAppConstants.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.godell.bank.exception.AccountNotFoundException;
import com.godell.bank.exception.InsufficinetBalanaceException;
import com.godell.bank.model.BankTransactions;
import com.godell.bank.model.TransactionDto;
import com.godell.bank.service.TransactionsService;

@RestController()
public class BankTransactionController {
	private static final Log logger=LogFactory.getLog(BankTransactionController.class);
	
	
	@Autowired
	TransactionsService transactionsService;
	
	
	@PostMapping("bankTransaction")
	public ResponseEntity<TransactionDto> bankingTransaction(@RequestBody BankTransactions transactions){
		logger.info("Recieved transaction with accountId"+transactions.getAccountId());
		TransactionDto postTranAccount=transactionsService.transactionByBank(transactions);
		if(postTranAccount==null) {
			logger.info("Account id "+transactions.getAccountId()+" is invalid");
			throw new AccountNotFoundException(ACC_ID+transactions.getAccountId());
		}
		if(postTranAccount.getStatus().equals(INSUFFICIENT_BALANCE)) {
			logger.info("Account id "+transactions.getAccountId()+"'s balance is insufficien");
			throw new InsufficinetBalanaceException(ACC_ID+transactions.getAccountId());
			
		}
		return new ResponseEntity<TransactionDto>(postTranAccount, HttpStatus.OK);
		
		
	}

}
