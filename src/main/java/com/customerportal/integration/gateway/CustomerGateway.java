package com.customerportal.integration.gateway;

import com.customerportal.cdm.Customer;
import com.customerportal.cdm.Customer.CustomerList;

public interface CustomerGateway {
	
	void createCustomer(Customer customer);
	
	void deleteCustomer(Customer customer);
	
	CustomerList  findAllCustomers();
}
