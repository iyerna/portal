package com.customerportal.integration.gateway;

import com.customerportal.cdm.Ticket;
import com.customerportal.cdm.Ticket.TicketList;

public interface TicketGateway {
	
	void createTicket(Ticket ticket);
	
	TicketList  findAllTickets();
}
