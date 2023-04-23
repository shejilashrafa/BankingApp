package com.godell.bank.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	

	@Column(name = "user_name")
	private String userName;

	@Column(name = "account_type")
	private String accountType;
	
	private int mobileNumber;
	
	private String email;
	
	private LocalDate dateOfBirth;
	
	private String pan;
	
	@OneToMany(mappedBy = "user")
	private List<Account> account;
	
	private boolean userActivateStatus;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, mobileNumber, pan, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && mobileNumber == other.mobileNumber
				&& Objects.equals(pan, other.pan) && Objects.equals(userName, other.userName);
	}

	

	public boolean isUserActivateStatus() {
		return userActivateStatus;
	}

	public void setUserActivateStatus(boolean userActivateStatus) {
		this.userActivateStatus = userActivateStatus;
	}
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", accountType=" + accountType + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", pan=" + pan + ", account="
				+ account + ", userActivateStatus=" + userActivateStatus + "]";
	}

	public User(Long userId, String userName, String accountType, int mobileNumber, String email, LocalDate dateOfBirth,
			String pan, List<Account> account, boolean userActivateStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.accountType = accountType;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.pan = pan;
		this.account = account;
		this.userActivateStatus = userActivateStatus;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	


}
