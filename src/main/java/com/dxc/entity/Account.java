package com.dxc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Account",uniqueConstraints={@UniqueConstraint(columnNames={"User_Name"})})
public class Account implements Serializable {
	
	private static final long serialVersionUID = 7849909627432614481L;
	public static final String ROLE_MANAGER = "MANAGER";
	    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

	    private String userName;
	    private String password;
	    private String password2;
	    private boolean active;
	    private String userRole;

	    @Id
	    @Column(name = "User_Name", length = 20, nullable = false)
	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    @Column(name = "Password", length = 20, nullable = false)
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	    @Column(name = "Password2", length = 20, nullable = false)
		public String getPassword2() {
			return password2;
		}

		public void setPassword2(String password2) {
			this.password2 = password2;
		}
	    @Column(name = "Active", length = 1, nullable = false)
	    public boolean isActive() {
	        return active;
	    }

	    public void setActive(boolean active) {
	        this.active = active;
	    }

	    @Column(name = "User_Role", length = 20, nullable = false)
	    public String getUserRole() {
	        return userRole;
	    }

	    public void setUserRole(String userRole) {
	        this.userRole = userRole;
	    }
	    
		@Override
	    public String toString()  {
	        return "["+ this.userName+","+ this.password+","+ this.userRole+"]";
	    }

	    
	    
}
