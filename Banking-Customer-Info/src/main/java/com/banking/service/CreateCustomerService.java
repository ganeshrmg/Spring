package com.banking.service;

import org.springframework.stereotype.Service;

import com.banking.dto.CustomerDto;
import com.banking.entity.customerEntity;


public interface CreateCustomerService {
	void createCustomer(CustomerDto customerinfo);
	customerEntity getCustomerinfo(Long id);
	void updateCustomer(customerEntity custinfo);
	customerEntity checkEmail(String email);
	customerEntity checkUsername(String uname);	
}
