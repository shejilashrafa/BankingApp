package com.godell.bank.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.godell.bank.dao.BankTransactionDao;
import com.godell.bank.model.Account;
import com.godell.bank.model.BankTransactions;

public class Deposit implements BankTransaction{
	private static final Log logger=LogFactory.getLog(Deposit.class);
	@Autowired
	BankTransactionDao bankTransactionDao;

	@Override
	public Account accountTransaction(BankTransactions transaction) {
		logger.info("In Deposit ");
		double finalTransactionAmount=0;
		Account account=bankTransactionDao.getAccountWithAccountId(transaction.getAccount().getSourceAccountId());
		if(account==null) {
			logger.info("Account id "+transaction.getAccount().getSourceAccountId()+" is invalid");
			return null;
		}
		finalTransactionAmount=TransactionOperationEnum.DEPOSIT.transactionOperation(transaction.getAmount(),account.getBalance());
		List<BankTransactions> tran=new ArrayList<BankTransactions>();
		tran.add(transaction);
		account.setTransactions(tran);
		account.setBalance(finalTransactionAmount);
		Account updatedAccount=bankTransactionDao.updateAccount(account);
		logger.info("Deposit is successful Transaction id "+updatedAccount.getTransactions().get(0).getTransactionNumber());
		return updatedAccount;
	}

}
