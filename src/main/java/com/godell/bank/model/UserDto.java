package com.godell.bank.model;

import java.time.LocalDateTime;

public class UserDto {
	private long userId;
	private long userAccountId;
	private LocalDateTime userCreationTime;
	private boolean userActivated;
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userAccountId=" + userAccountId + ", userCreationTime="
				+ userCreationTime + ", userActivated=" + userActivated + "]";
	}
	public UserDto(long userId, long userAccountId, LocalDateTime userCreationTime, boolean userActivated) {
		super();
		this.userId = userId;
		this.userAccountId = userAccountId;
		this.userCreationTime = userCreationTime;
		this.userActivated = userActivated;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public LocalDateTime getUserCreationTime() {
		return userCreationTime;
	}
	public void setUserCreationTime(LocalDateTime userCreationTime) {
		this.userCreationTime = userCreationTime;
	}
	public boolean isUserActivated() {
		return userActivated;
	}
	public void setUserActivated(boolean userActivated) {
		this.userActivated = userActivated;
	}
	
	

}
