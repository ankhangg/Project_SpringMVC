package com.dxc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dxc.entity.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
	    customer.setIdCustomer(rs.getInt("idcustomer"));
	    customer.setNameCustomer(rs.getString("customername"));
	    customer.setAddressCustomer(rs.getString("customeraddress"));
	    customer.setPhoneCustomer(rs.getString("customerphone"));
	    customer.setUserNameCustomer(rs.getString("User_Name"));
		return customer;
	}

}
