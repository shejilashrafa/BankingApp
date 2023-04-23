package com.godell.bank.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.godell.bank.dao.BankTransactionDao;
import com.godell.bank.model.Account;
import com.godell.bank.model.BankTransactions;

public class Withdraw implements BankTransaction{
	private static final Log logger=LogFactory.getLog(Withdraw.class);
	@Autowired
	BankTransactionDao bankTransactionDao;

	
	@Override
	public Account accountTransaction(BankTransactions transaction) {
		double finalTransactionAmount=0;
		Account account=bankTransactionDao.getAccountWithAccountId(transaction.getAccountId());
		if(account==null) {
			logger.info("Account id "+transaction.getAccountId()+" is invalid");
			return null;
			
		}	
		if(account.getBalance()<transaction.getAmount()) {
			transaction.setTran_sastus("INSUFFICIENT_BALANCE");
			return account;
		}
		finalTransactionAmount=TransactionOperationEnum.WITHDRAW.transactionOperation(account.getBalance(),transaction.getAmount());
		List<BankTransactions> tran=new ArrayList<BankTransactions>();
		tran.add(transaction);
		account.setTransactions(tran);
		account.setBalance(finalTransactionAmount);
		Account updatedAccount=bankTransactionDao.updateAccount(account);
		return updatedAccount;
	
		
	}

}
