package com.dxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.CustomerDAO;
import com.dxc.entity.Customer;
import com.dxc.service.CustomerService;

@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public void addInfoCustomerNEW(Customer customer) {
		customerDAO.addInfoCustomerNEW(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> listCustomers = customerDAO.findAllCustomer();
		return listCustomers;
	}

	@Override
	public Customer findCustomer(String userNameCustomer) {
		Customer customer = customerDAO.findCustomer(userNameCustomer);
		return customer;
	}

	@Override
	public void updateInfoCustomer(Customer customer) {
		customerDAO.updateInfoCustomer(customer);		
	}

}
