package com.godell.bank.model;

import java.time.LocalDateTime;

public class TransactionDto {
	
	private long accountId;
	private LocalDateTime tranTime;
	private long transactionId;
	private double updatedBalance;
	private String tranType;
	private String status;
	
	
	
	public LocalDateTime getTranTime() {
		return tranTime;
	}
	public void setTranTime(LocalDateTime tranTime) {
		this.tranTime = tranTime;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public double getUpdatedBalance() {
		return updatedBalance;
	}
	public void setUpdatedBalance(double updatedBalance) {
		this.updatedBalance = updatedBalance;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}


	public TransactionDto() {
		super();
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransactionDto [accountId=" + accountId + ", tranTime=" + tranTime + ", transactionId=" + transactionId
				+ ", updatedBalance=" + updatedBalance + ", tranType=" + tranType + ", status=" + status + "]";
	}
	public TransactionDto(long accountId, LocalDateTime tranTime, long transactionId, double updatedBalance,
			String tranType, String status) {
		super();
		this.accountId = accountId;
		this.tranTime = tranTime;
		this.transactionId = transactionId;
		this.updatedBalance = updatedBalance;
		this.tranType = tranType;
		this.status = status;
	}
	
	
	

}
