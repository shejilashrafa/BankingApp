package com.godell.bank.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.godell.bank.dao.BankTransactionDao;
import com.godell.bank.model.Account;
import com.godell.bank.model.BankTransactions;

public class CheckBalance implements BankTransaction{
	private static final Log logger=LogFactory.getLog(CheckBalance.class);
	@Autowired
	BankTransactionDao bankTransactionDao;
	@Override
	public Account accountTransaction(BankTransactions transaction) {
		logger.info("Checking balance");
		Account account=bankTransactionDao.getAccountWithAccountId(transaction.getAccountId());
		if(account==null)
			return null;
		logger.info("Balance Check is successful ");
		return account;
	}

}
