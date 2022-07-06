package com.dxc.entity;

public class Account_User {
    private String userName;
    private String password;
    private String password2;
    private boolean active;
    private String userRole;
    
    private boolean newAccount = false;
    
	public boolean isNewAccount() {
		return newAccount;
	}
	public void setNewAccount(boolean newAccount) {
		this.newAccount = newAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Account_User() {
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
    
    
}
