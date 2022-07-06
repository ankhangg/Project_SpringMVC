package com.dxc.dao;

import com.dxc.entity.Account;
import com.dxc.entity.Account_User;
import com.dxc.model.PasswordVertification;

public interface AccountDAO {
	public Account findAccount(String userName);
	public void create_account(Account_User account_User);
	public boolean checkpassWord(String password, String confirmPassword);
	public String getConfirmPassword(PasswordVertification passwordVertification);
}
