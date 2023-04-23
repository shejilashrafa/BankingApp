package com.godell.bank.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bank_transactions")
public class BankTransactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private long transactionNumber;
	private String accountType;
	private double amount;
	private String currency;
	private long accountId;
	private String operation;
	private String tran_sastus;
	


	@Column(name = "transaction_time")
	private LocalDateTime transacctionTime;
	
	@ManyToOne
	@JoinColumn(name="account_id", nullable=false)
	private Account account;
	
	public BankTransactions() {
		super();
		}
	
	public LocalDateTime getTransacctionTime() {
		return transacctionTime;
	}


	public void setTransacctionTime(LocalDateTime transacctionTime) {
		this.transacctionTime = transacctionTime;
	}


	public Account getAccount() {
		return account;
	}


	public String getTran_sastus() {
		return tran_sastus;
	}

	public void setTran_sastus(String tran_sastus) {
		this.tran_sastus = tran_sastus;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "BankTransactions [transactionNumber=" + transactionNumber + ", accountType=" + accountType + ", amount="
				+ amount + ", currency=" + currency + ", accountId=" + accountId + ", operation=" + operation
				+ ", tran_sastus=" + tran_sastus + ", transacctionTime=" + transacctionTime + ", account=" + account
				+ "]";
	}

	public BankTransactions(long transactionNumber, String accountType, double amount, String currency, long accountId,
			String operation, String tran_sastus, LocalDateTime transacctionTime, Account account) {
		super();
		this.transactionNumber = transactionNumber;
		this.accountType = accountType;
		this.amount = amount;
		this.currency = currency;
		this.accountId = accountId;
		this.operation = operation;
		this.tran_sastus = tran_sastus;
		this.transacctionTime = transacctionTime;
		this.account = account;
	}





	
	
	
	
	

}
