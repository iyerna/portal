package com.customerportal.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.customerportal.cdm.Customer;
import com.customerportal.cdm.Customer.CustomerList;
import com.customerportal.integration.gateway.CustomerGateway;
import com.customerportal.integration.resource.CustomerResource;

@Controller
public class CustomerController {
	private static final String GUEST = "guest";

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Inject private CustomerGateway customerGateway;
	
	// =================================================================================================================
	// Tickets home
	// =================================================================================================================
	
	@RequestMapping(method = RequestMethod.GET, value = "/rest/customers", headers="accept=application/json")
	@ResponseBody
	public List<CustomerResource> getAllCustomers() {
		
		//List<TicketEntity> tickets = ticketRepo.findAll();	
		//get all tickets from the TicketGateway
		CustomerList customerList = customerGateway.findAllCustomers();
		
		//convert ticket entity to ticket resource
		List<CustomerResource> customerResources = new ArrayList<CustomerResource>();		
		if (customerList != null && customerList.getElements() != null
				&& !customerList.getElements().isEmpty()) {

			for (Customer customer : customerList.getElements()) {
				CustomerResource customerResource = new CustomerResource();
				customerResource.setId(customer.getId());
				customerResource.setFirstName(customer.getFirstName());
				customerResource.setLastName(customer.getLastName());
				customerResource.setUserName(customer.getUserName());
				customerResource.setEmail(customer.getEmail());
				customerResources.add(customerResource);
			}
		}
		return customerResources;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/rest/customers/create", headers="accept=application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public void createCustomer(@RequestBody CustomerResource customerResource) {
		Customer customer = new Customer();
		customer.setId(customerResource.getId());
		customer.setFirstName(customerResource.getFirstName());
		customer.setLastName(customerResource.getLastName());
		customer.setEmail(customerResource.getEmail());
		customer.setUserName(customerResource.getUserName());
		//set default password to "guest"
		customer.setPassword(GUEST);
		customerGateway.createCustomer(customer);
    }
 
}
