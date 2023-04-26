package com.godell.bank.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")

public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long sourceAccountId;

	@Column(name = "creation_date")
	private LocalDateTime createdAt;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "balance", columnDefinition = "Decimal(10,2)default'0.00'")
	private double balance;

	@OneToMany(mappedBy = "account")
	private List<BankTransactions> bankTransactions;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public List<BankTransactions> getTransactions() {
		return bankTransactions;
	}

	public void setTransactions(List<BankTransactions> transactions) {
		this.bankTransactions = bankTransactions;
	}

	public Account() {
		super();

	}

	public Long getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(Long sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<BankTransactions> getBankTransactions() {
		return bankTransactions;
	}

	public void setBankTransactions(List<BankTransactions> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [sourceAccountId=" + sourceAccountId + ", createdAt=" + createdAt + ", accountType="
				+ accountType + ", balance=" + balance + ", bankTransactions=" + bankTransactions + ", user=" + user
				+ "]";
	}

	public Account(Long sourceAccountId, LocalDateTime createdAt, String accountType, double balance,
			List<BankTransactions> bankTransactions, User user) {
		super();
		this.sourceAccountId = sourceAccountId;
		this.createdAt = createdAt;
		this.accountType = accountType;
		this.balance = balance;
		this.bankTransactions = bankTransactions;
		this.user = user;
	}

}
