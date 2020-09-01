package com.banking.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banking.BankingConfig;
import com.banking.dto.CustomerDto;
import com.banking.entity.customerEntity;
import com.banking.model.Customer;
import com.banking.model.Duediligence;
import com.banking.service.CreateCustomerService;
import com.banking.service.DueDiligenceService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class CustomerInfoController {
	
	//private static Logger logger  = Logger.getLogger(CustomerInfoController.class);
	
	@Autowired
	CreateCustomerService createCustomerService;
	
	@Autowired
	BankingConfig bankingConfig;
	
	
	@Autowired
	DueDiligenceService dueDiligenceService;


	@PostMapping(value="/customerinfo")
	public ResponseEntity<String> customerInformation(@Valid @RequestBody Customer customerinfo,BindingResult bindingResult) {		
		
		if(bindingResult.getErrorCount() > 0) {
			return ResponseEntity.ok(bindingResult.getAllErrors().toString());
		}else {
			String error;
			ModelMapper modelmapper = new ModelMapper();
			modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);			
			String encodepassword = Base64.getEncoder().encodeToString(customerinfo.getPassword().getBytes());
			customerinfo.setPassword(encodepassword);
			String email = customerinfo.getEmail();
			String uname = customerinfo.getUsername();
			customerEntity checkEmail = createCustomerService.checkEmail(email);
			customerEntity checkUsername = createCustomerService.checkUsername(uname);
			if(checkEmail == null && checkUsername == null) {
				CustomerDto customerdata = modelmapper.map(customerinfo, CustomerDto.class);
				customerdata.setDueapproval("Pending");
				createCustomerService.createCustomer(customerdata);
				error = "Customer is created";
			}else {
				error =  "Email id (OR) Username Already Exists";
			}
			
			return ResponseEntity.ok(error);
			 
		}
		
	}
//		@RequestMapping(method=RequestMethod.POST,value="/customerinfo/update/{customerid}")
//		public ResponseEntity<String> customerInformationUpdate(@PathVariable(name="customerid",required=true) Long id,@Valid @RequestBody Customer customerinfo,BindingResult bindingResult) {		
//					
//			if(bindingResult.getErrorCount() > 0) {
//				return ResponseEntity.ok(bindingResult.getAllErrors().toString());
//			}else {
//				customerEntity custinfo = createCustomerService.getCustomerinfo(id);
//				if(custinfo != null) {
//					custinfo.setAccount(customerinfo.getAccount());
//					custinfo.setAddress(customerinfo.getAddress());
//					custinfo.setContact(customerinfo.getContact());
//					custinfo.setCountry(customerinfo.getCountry());
//					custinfo.setDob(customerinfo.getDob());
//					custinfo.setUsername(customerinfo.getUsername());
//					custinfo.setEmail(customerinfo.getEmail());
//					custinfo.setName(customerinfo.getName());
//					custinfo.setPan(customerinfo.getPan());
//					custinfo.setPassword(customerinfo.getPassword());
//					custinfo.setState(customerinfo.getState());					
//					createCustomerService.updateCustomer(custinfo);					
//				}				
//				return ResponseEntity.ok("Customer is Updated"); 
//			}
//		 
//	}
		
		@GetMapping(value="/customerinfo/{customerid}")
		@HystrixCommand(fallbackMethod = "getCustomerFallback")
		public HashMap<String,Object> getCustomer(@PathVariable(name="customerid",required=true) Long id) {					
			HashMap<String,Object> getData = new HashMap<String,Object>();			
			customerEntity custinfo = createCustomerService.getCustomerinfo(id);
			List<customerEntity> customers = new ArrayList<customerEntity>();
			customers.add(custinfo);
			customers.forEach(cust ->{
				String name = cust.getName();
				System.out.println("Name :" + name);
			});
			
			if(custinfo != null) {				
				getData.put("data", custinfo);
			}
			
			return getData;	 
	}
		
		
		@GetMapping(value="/customerdueupdate/{customerid}")
		public Duediligence getCustomerDue(@PathVariable(name="customerid",required=true) Long id) {			
			Duediligence getStatus = dueDiligenceService.getDuediligenceStatus(id);
			customerEntity custinfo = createCustomerService.getCustomerinfo(id);
			custinfo.setDueapproval("Approved");
			custinfo.setDuestatus(getStatus.getDueDiligenceStatus());
			custinfo.setScore(getStatus.getCreditScore());
			createCustomerService.updateCustomer(custinfo);			
			return getStatus;	 
	}
		
		public HashMap<String,Object> getCustomerFallback(@PathVariable(name="customerid",required=true) Long id) {
			HashMap<String,Object> getData = new HashMap<String,Object>();
			getData.put("data", bankingConfig.getName());
			return getData;
		}
}
