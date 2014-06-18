package com.customerportal.integration.transformer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.customerportal.cdm.Ticket;
import com.customerportal.cdm.Ticket.TicketList;
import com.customerportal.model.TicketEntity;

@Component
public class TicketListTransformer {
	@Inject private TicketTransformer ticketTransformer;
	
	public TicketList toDto(List<TicketEntity> ticketEntities) {
		List<Ticket> ticketDtoList = new ArrayList<Ticket>();
		for (TicketEntity ticketEntity : ticketEntities) {
			ticketDtoList.add(ticketTransformer.toDto(ticketEntity));
		}
		return new TicketList(ticketDtoList);
	}
}
