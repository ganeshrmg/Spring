package com.banking.repository;

import java.util.List;

import org.springframework.data.repository.*;

import com.banking.entity.customerEntity;

public interface CustomerRepository extends CrudRepository<customerEntity,Long> {

	List<customerEntity> findByEmail(String email);

	List<customerEntity> findByUsername(String uname);

}
