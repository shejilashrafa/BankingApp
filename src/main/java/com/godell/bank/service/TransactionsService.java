package com.godell.bank.service;

import com.godell.bank.model.BankTransactions;
import com.godell.bank.model.TransactionDto;

public interface TransactionsService {
	public TransactionDto transactionByBank(BankTransactions trans);

}
