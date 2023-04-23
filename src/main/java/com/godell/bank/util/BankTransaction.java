package com.godell.bank.util;

import com.godell.bank.model.Account;
import com.godell.bank.model.BankTransactions;

public interface BankTransaction {
	Account accountTransaction(BankTransactions transaction);

}
