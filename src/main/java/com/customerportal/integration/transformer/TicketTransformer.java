package com.customerportal.integration.transformer;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.customerportal.cdm.Customer;
import com.customerportal.cdm.Ticket;
import com.customerportal.model.TicketEntity;
import com.customerportal.model.UserEntity;

@Component
public class TicketTransformer {
	@Inject private TicketCategoryTransformer ticketCategoryTransformer;
	
	public TicketEntity toEntity(Ticket ticketDto) {
		TicketEntity ticketEntity = new TicketEntity();
		ticketEntity.setCategory(ticketCategoryTransformer.toEntity(ticketDto.getCategory()));
		
		// We do either (1) the username or else (2) the e-mail and full name, but not both.
		Customer customerDto = ticketDto.getCreatedBy();
		UserEntity userEntity = new UserEntity();
		userEntity.setId(customerDto.getId());
		userEntity.setUsername(customerDto.getUserName());
		userEntity.setFirstName(customerDto.getFirstName());
		userEntity.setLastName(customerDto.getLastName());
		userEntity.setEmail(customerDto.getEmail());
		
		ticketEntity.setUser(userEntity);
		
		ticketEntity.setDateCreated(ticketDto.getDateCreated());
		ticketEntity.setDescription(ticketDto.getDescription());
		return ticketEntity;
	}
	
	public Ticket toDto(TicketEntity ticketEntity) {
		Ticket ticket = new Ticket();
		ticket.setCategory(ticketCategoryTransformer.toDto(ticketEntity.getCategory()));
		
		// We do either (1) the username or else (2) the e-mail and full name, but not both.
		UserEntity userEntity = ticketEntity.getUser();
		Customer customerDto = new Customer();
		customerDto.setId(userEntity.getId());
		customerDto.setUserName(userEntity.getUsername());
		customerDto.setFirstName(userEntity.getFirstName());
		customerDto.setLastName(userEntity.getLastName());
		customerDto.setEmail(userEntity.getEmail());
		
		ticket.setCreatedBy(customerDto);
		ticket.setId(ticketEntity.getId());
		ticket.setDateCreated(ticketEntity.getDateCreated());
		ticket.setDescription(ticketEntity.getDescription());
		return ticket;
	}
}
