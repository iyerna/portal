package com.customerportal.integration.transformer;

import org.springframework.stereotype.Component;

import com.customerportal.cdm.TicketCategory;
import com.customerportal.model.TicketCategoryEntity;

@Component
public class TicketCategoryTransformer {
	
	public TicketCategory toDto(TicketCategoryEntity categoryEntity) {
		TicketCategory categoryDto = new TicketCategory();
		categoryDto.setId(categoryEntity.getId());
		categoryDto.setName(categoryEntity.getName());
		return categoryDto;
	}
	
	public TicketCategoryEntity toEntity(TicketCategory categoryDto) {
		TicketCategoryEntity categoryEntity = new TicketCategoryEntity();
		categoryEntity.setId(categoryDto.getId());
		categoryEntity.setName(categoryDto.getName());
		return categoryEntity;
	}
}
