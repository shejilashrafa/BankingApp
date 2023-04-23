package com.godell.bank.util;

public enum TransactionOperationEnum {
	WITHDRAW {
	    public double transactionOperation(double balance, double amount) { return balance - amount; }
	  }, 
	  DEPOSIT {
	    public double transactionOperation(double balance, double amount) { return balance + amount; }
	  }, 
	  ;

	  public abstract double transactionOperation(double balance, double amount);
	}
	
	
	



