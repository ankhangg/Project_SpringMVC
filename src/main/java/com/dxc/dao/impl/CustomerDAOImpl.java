package com.dxc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.CustomerDAO;
import com.dxc.entity.Customer;
import com.dxc.mapper.CustomerMapper;

public class CustomerDAOImpl implements CustomerDAO {
	  @Autowired
	  private HibernateTemplate hibernateTemplate;
	  
	  @Autowired
	  private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public void addInfoCustomerNEW(Customer customer) {
		this.hibernateTemplate.saveOrUpdate(customer);
	}
		
	

	@Override
	public Customer findCustomer(String string) {
	   String sql = "Select * from Customer where User_Name = ?";
	   Customer thisCustomer = jdbcTemplate.queryForObject(sql, new CustomerMapper(), string);
	  return thisCustomer;
	}


	@Override
	public List<Customer> findAllCustomer() {
//		List<Customer> customers = this.hibernateTemplate.loadAll(Customer.class);
//		return customers;
		//String sql = "Select * from Customer";
		String sql = "Select c.idcustomer, c.customername, c.customeraddress,c.customerphone,c.User_Name from Account a, Customer c where a.User_Name = c.User_Name AND a.User_Role like 'USER' ";
		List<Customer> customers = jdbcTemplate.query(sql, new CustomerMapper());
		return customers;
	}



	@Override
	public void updateInfoCustomer(Customer customer) {
		String sql = "Update Customer set customername= ?, customeraddress = ?, customerphone= ? where  idcustomer= ?";
		Object[] objects = {customer.getNameCustomer(), customer.getAddressCustomer(), customer.getPhoneCustomer(), customer.getIdCustomer()};
		jdbcTemplate.update(sql, objects);
		System.out.println("1 Customer is update...");
	}

}
