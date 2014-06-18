package com.customerportal.integration.transformer;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.customerportal.cdm.Customer;
import com.customerportal.model.UserEntity;

@Component
public class CustomerTransformer {
	@Inject private TicketCategoryTransformer ticketCategoryTransformer;
	
	public UserEntity toEntity(Customer customerDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(customerDto.getId());
		userEntity.setUsername(customerDto.getUserName());
		userEntity.setFirstName(customerDto.getFirstName());
		userEntity.setLastName(customerDto.getLastName());
		userEntity.setEmail(customerDto.getEmail());
		userEntity.setPassword(customerDto.getPassword());
		
		return userEntity;
	}
	
	public Customer toDto(UserEntity userEntity) {
		Customer customerDto = new Customer();		
		// We do either (1) the username or else (2) the e-mail and full name, but not both.
		customerDto.setId(userEntity.getId());
		customerDto.setUserName(userEntity.getUsername());
		customerDto.setFirstName(userEntity.getFirstName());
		customerDto.setLastName(userEntity.getLastName());
		customerDto.setEmail(userEntity.getEmail());
		customerDto.setPassword(userEntity.getPassword());
		return customerDto;
	}
}
