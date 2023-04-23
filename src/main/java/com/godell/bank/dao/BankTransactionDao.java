package com.godell.bank.dao;

import com.godell.bank.model.Account;

public interface BankTransactionDao {
	Account getAccountWithAccountId(long accountId);

	Account updateAccount(Account account);

}
