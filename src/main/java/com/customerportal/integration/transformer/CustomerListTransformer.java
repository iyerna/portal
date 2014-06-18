package com.customerportal.integration.transformer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.customerportal.cdm.Customer;
import com.customerportal.cdm.Customer.CustomerList;
import com.customerportal.model.UserEntity;

@Component
public class CustomerListTransformer {
	@Inject private CustomerTransformer customerTransformer;
	
	public CustomerList toDto(List<UserEntity> userEntities) {
		List<Customer> customerDtoList = new ArrayList<Customer>();
		for (UserEntity userEntity : userEntities) {
			customerDtoList.add(customerTransformer.toDto(userEntity));
		}
		return new CustomerList(customerDtoList);
	}
}
