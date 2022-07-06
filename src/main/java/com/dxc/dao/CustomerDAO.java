package com.dxc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dxc.entity.Customer;

@Component
public interface CustomerDAO {
   public void addInfoCustomerNEW(Customer customer);
   public Customer findCustomer(String userNameCustomer);
   public List<Customer> findAllCustomer(); 
   public void updateInfoCustomer(Customer customer);
   
}
