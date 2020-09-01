package com.banking.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.banking.BankingConfig;
import com.banking.controller.CustomerInfoController;
import com.banking.dto.CustomerDto;
import com.banking.entity.customerEntity;
import com.banking.repository.CustomerRepository;
import com.banking.service.CreateCustomerService;
import com.banking.service.DueDiligenceService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CreateCustomerServiceImplTest {
	
	@InjectMocks
	private CreateCustomerServiceImpl createCustomerServiceImpl;
	
	@Mock
	private CustomerRepository customerRepository;
	
	
	@Before
    public void setUp() throws Exception {
          MockitoAnnotations.initMocks(this);
    }	

	@Test
	void testcreateCustomer() {		
		CustomerDto customerinfo = new CustomerDto();
		customerinfo.setName("Test");
		customerinfo.setUsername("Rmg");
		customerinfo.setEmail("tt@gmail.com");
		customerinfo.setAccount("Standard");
		customerinfo.setAddress("Test");
		customerinfo.setContact("2323342312");
		customerinfo.setCountry("India");
		customerinfo.setState("TamilNadu");
		customerinfo.setDob(new Date(0));
		customerinfo.setScore(100);
		customerinfo.setDueapproval("Pending");
		customerinfo.setDuestatus("Good");
		createCustomerServiceImpl.createCustomer(customerinfo);
	}
	
	@Test
	void testgetCustomerinfo() {
		customerEntity customerinfo = getData();
		 when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customerinfo));
		 customerEntity getCust = createCustomerServiceImpl.getCustomerinfo(1L);
		 assertEquals(getCust.getEmail(),"test@gmail.com");
	}
	
	@Test
	void testcheckEmail() {
		customerEntity customerinfo = getData();
		List<customerEntity> customerinfolist = new ArrayList<customerEntity>();
		customerinfolist.add(customerinfo);
		  when(customerRepository.findByEmail(anyString())).thenReturn(customerinfolist);
		 customerEntity getmail =  createCustomerServiceImpl.checkEmail("test@gmail.com");
		 assertEquals(getmail.getEmail(),"test@gmail.com");
		 System.out.println(getmail);
	}
	
	@Test
	void testcheckUsername() {
		customerEntity customerinfo = getData();
		List<customerEntity> customerinfolist = new ArrayList<customerEntity>();
		customerinfolist.add(customerinfo);
		  when(customerRepository.findByUsername(anyString())).thenReturn(customerinfolist);
		 customerEntity getmail =  createCustomerServiceImpl.checkUsername("test");
		 assertEquals(getmail.getName(),"test");		 
	}
	
	public customerEntity getData() {
		customerEntity customerinfo = new customerEntity();
		customerinfo.setName("test");
		customerinfo.setUsername("Rmg");
		customerinfo.setEmail("test@gmail.com");
		customerinfo.setAccount("Standard");
		customerinfo.setAddress("Test");
		customerinfo.setContact("2323342312");
		customerinfo.setCountry("India");
		customerinfo.setState("TamilNadu");
		customerinfo.setDob(new Date(0));
		customerinfo.setScore(100);
		customerinfo.setDueapproval("Pending");
		customerinfo.setDuestatus("Good");	
		return customerinfo;	
		
	}

}
