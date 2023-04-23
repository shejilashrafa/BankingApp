package com.godell.bank.util;

import static com.godell.bank.util.BankingAppConstants.*;

public class TransactionsFactory {
	
	public BankTransaction createTransfer(String action) {
		if(action==null)
			return null;
		switch(action) {
		case DEPOSIT :
			return new Deposit();
		case WITHDRAW:
			return new Withdraw();
		case BALANCE_CHECK:
			return new CheckBalance();
		default:	
		throw new IllegalArgumentException(INVALID_TRANSACTION+action);
			
		}
	}

}
