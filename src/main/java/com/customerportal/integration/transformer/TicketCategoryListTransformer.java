package com.customerportal.integration.transformer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.customerportal.cdm.TicketCategory;
import com.customerportal.cdm.TicketCategory.TicketCategoryList;
import com.customerportal.model.TicketCategoryEntity;

@Component
public class TicketCategoryListTransformer {
	@Inject private TicketCategoryTransformer categoryTransformer;
	
	public TicketCategoryList toDto(List<TicketCategoryEntity> categoryEntities) {
		List<TicketCategory> categoryDtoList = new ArrayList<TicketCategory>();
		for (TicketCategoryEntity categoryEntity : categoryEntities) {
			categoryDtoList.add(categoryTransformer.toDto(categoryEntity));
		}
		return new TicketCategoryList(categoryDtoList);
	}
}
