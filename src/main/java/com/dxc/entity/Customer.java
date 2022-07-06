package com.dxc.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "Customer",uniqueConstraints={@UniqueConstraint(columnNames={"User_Name"})})
public class Customer {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcustomer")
	private int idCustomer;
	
	@Column(name="customername")
	private String nameCustomer;
	
	@Column(name="customeraddress")
	private String addressCustomer;
	
	@Column(name="customerphone")
	private String phoneCustomer;
	
	@Column(name="User_Name")
	private String userNameCustomer;

	public Customer() {

	}
	
	public Customer(int idCustomer, String nameCustomer, String addressCustomer, String phoneCustomer, String userNameCustomer) {
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.addressCustomer = addressCustomer;
		this.phoneCustomer = phoneCustomer;
		this.userNameCustomer = userNameCustomer;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getAddressCustomer() {
		return addressCustomer;
	}
	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public String getPhoneCustomer() {
		return phoneCustomer;
	}
	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}
	public String getUserNameCustomer() {
		return userNameCustomer;
	}
	public void setUserNameCustomer(String userNameCustomer) {
		this.userNameCustomer = userNameCustomer;
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", nameCustomer=" + nameCustomer + ", addressCustomer="
				+ addressCustomer + ", phoneCustomer=" + phoneCustomer + ", userNameCustomer=" + userNameCustomer + "]";
	}


	
}
