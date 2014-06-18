package com.customerportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.customerportal.model.TicketEntity;;

@RestResource(path = "tickets")
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {	
}
