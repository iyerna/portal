package com.customerportal.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.customerportal.cdm.Ticket;
import com.customerportal.cdm.Ticket.TicketList;
import com.customerportal.integration.gateway.TicketGateway;
import com.customerportal.integration.resource.TicketResource;
/**
 * Web controller for help desk tickets.
 * 
 */
@Controller
@RequestMapping(value = "/rest/tickets/", method = RequestMethod.GET)
public class TicketController {
	private static final Logger log = LoggerFactory.getLogger(TicketController.class);
	
	//@Inject private TicketRepository ticketRepo;
	@Inject private TicketGateway ticketGateway;
	
	// =================================================================================================================
	// Tickets home
	// =================================================================================================================
	
	@RequestMapping(method = RequestMethod.GET, headers="accept=application/json")
	@ResponseBody
	public List<TicketResource> getAllTickets() {
		
		//List<TicketEntity> tickets = ticketRepo.findAll();
		
		//get all tickets from the TicketGateway
		TicketList ticketList = ticketGateway.findAllTickets();
		
		//convert ticket entity to ticket resource
		List<TicketResource> ticketResources = new ArrayList<TicketResource>();		
		if (ticketList != null && ticketList.getElements() != null
				&& !ticketList.getElements().isEmpty()) {

			for (Ticket ticket : ticketList.getElements()) {
				TicketResource ticketResource = new TicketResource();
				ticketResource.setId(ticket.getId());
				ticketResource.setCategory(ticket.getCategory().getName());
				ticketResource.setDateCreated(ticket.getDateCreated());
				ticketResource.setDescription(ticket.getDescription());
				ticketResource.setUsername(ticket.getCreatedBy().getUserName());
				ticketResources.add(ticketResource);
			}
		}
		return ticketResources;
	}
}
