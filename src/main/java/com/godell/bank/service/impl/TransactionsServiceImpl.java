package com.godell.bank.service.impl;

import static com.godell.bank.util.BankingAppConstants.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.godell.bank.model.Account;
import com.godell.bank.model.BankTransactions;
import com.godell.bank.model.TransactionDto;
import com.godell.bank.service.TransactionsService;
import com.godell.bank.util.BankTransaction;
import com.godell.bank.util.TransactionsFactory;
@Service
public class TransactionsServiceImpl implements TransactionsService{
	private static final Log logger=LogFactory.getLog(TransactionsServiceImpl.class);
	
	
	
	@Override
	public TransactionDto transactionByBank(BankTransactions trans) {
		TransactionsFactory transactionFactory=new TransactionsFactory();
		BankTransaction bankTransaction=transactionFactory.createTransfer(trans.getOperation());
		Account updatedAccount=bankTransaction.accountTransaction(trans);
		if(updatedAccount==null) {
			return null;
		}
		TransactionDto updatedTranDetails=new TransactionDto();
		if(updatedAccount.getTransactions().get(0).getTran_sastus().equals(INSUFFICIENT_BALANCE)) {
			updatedTranDetails.setStatus(updatedAccount.getTransactions().get(0).getTran_sastus());
			return updatedTranDetails;
		}
		updatedTranDetails.setTransactionId(updatedAccount.getTransactions().get(0).getTransactionNumber());
		updatedTranDetails.setTranTime(updatedAccount.getTransactions().get(0).getTransacctionTime());
		updatedTranDetails.setTranType(updatedAccount.getTransactions().get(0).getOperation());
		updatedTranDetails.setUpdatedBalance(updatedAccount.getBalance());
		updatedTranDetails.setAccountId(updatedAccount.getSourceAccountId());
		updatedTranDetails.setStatus(SUCCESS);
		return updatedTranDetails;
	}

}
