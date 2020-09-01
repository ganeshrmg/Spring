package com.banking.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dto.CustomerDto;
import com.banking.entity.customerEntity;
import com.banking.repository.CustomerRepository;
import com.banking.service.CreateCustomerService;

@Service
public class CreateCustomerServiceImpl implements CreateCustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public void createCustomer(CustomerDto customerinfo) {	
		System.out.println("Testt");
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);		
		customerEntity CustomerEntity = modelmapper.map(customerinfo, customerEntity.class);		
		customerRepository.save(CustomerEntity);	
		
		
	}
	public customerEntity getCustomerinfo(Long id) {
		Optional<customerEntity> getinfo = customerRepository.findById(id);
		if(getinfo.isEmpty()) {
			return null;
		}else {			
			return getinfo.get();
		}
				
	}
	
	public void updateCustomer(customerEntity custinfo) {
		customerRepository.save(custinfo);
	}	
	
	public customerEntity checkEmail(String email) {
		List<customerEntity> getCustomer = customerRepository.findByEmail(email);		
		customerEntity customer = null;
		if(getCustomer.size() > 0) {
			customer = getCustomer.get(0);
		}
		return customer;
	}
	
	public customerEntity checkUsername(String uname) {
		List<customerEntity> getCustomer = customerRepository.findByUsername(uname);		
		customerEntity customer = null;
		if(getCustomer.size() > 0) {
			customer = getCustomer.get(0);
		}
		return customer;
	}
}
