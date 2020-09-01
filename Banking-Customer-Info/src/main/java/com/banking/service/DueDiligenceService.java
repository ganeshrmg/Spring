package com.banking.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banking.dto.CustomerDto;
import com.banking.entity.customerEntity;
import com.banking.model.Duediligence;


@FeignClient(name = "zuul",contextId = "duediligence")
public interface DueDiligenceService {
	
	@RequestMapping(value = "/duediligence/getDuediligenceStatus/{customerid}")
	public Duediligence getDuediligenceStatus(@PathVariable Long customerid);	
}
