package com.dxc.service;

import java.util.List;

import com.dxc.entity.Customer;

public interface CustomerService {
	   public void addInfoCustomerNEW(Customer customer);
	   public List<Customer> findAllCustomer(); 
	   public Customer findCustomer(String userNameCustomer);
	   public void updateInfoCustomer(Customer customer);
}
