package com.dxc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.AccountDAO;
import com.dxc.entity.Account;
import com.dxc.entity.Account_User;
import com.dxc.model.PasswordVertification;

@Transactional
public class AccountDAOImpl implements AccountDAO {

    private static final String String = null;
	@Autowired
    private SessionFactory sessionFactory;

    
	@Override
	public Account findAccount(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Account.class);
        crit.add(Restrictions.eq("userName", userName));
        return (Account) crit.uniqueResult();
	}

	@Override
	public void create_account(Account_User account_User) {
		String userName = account_User.getUserName();
		Account account = null;
		boolean isNew = false;
//		if (userName != null) {
//			account = this.findAccount(userName);
//		}
//		if (account == null) {
//			isNew = true;
//			account = new Account();
//		}
//	    if(account != null) {
//	    	System.out.println("Ten dang nhap da ton tai");
//	    }
		if (account == null) {
			isNew = true;
			account = new Account();
			if (checkpassWord(account_User.getPassword(), account_User.getPassword2())==true)  {
				account.setUserName(account_User.getUserName());
				account.setPassword(account_User.getPassword());
				account.setPassword2(account_User.getPassword2());
				account.setUserRole(account_User.getUserRole());
				account.setActive(account_User.isActive());
			}
			if (isNew) {
				 this.sessionFactory.getCurrentSession().persist(account);	
			}
	        this.sessionFactory.getCurrentSession().flush();
		}
	}

	@Override
	public boolean checkpassWord(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {
			return true;
		}
		return false;
	}

	@Override
	public String getConfirmPassword(PasswordVertification passwordVertification) {
	 return passwordVertification.getConfirmPassword();
	}

}
