package com.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.banking")
@EnableDiscoveryClient
public class BankingCustomerInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingCustomerInfoApplication.class, args);
	}

}
