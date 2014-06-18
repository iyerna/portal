package com.customerportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.customerportal.model.TicketCategoryEntity;

@RestResource(path = "ticketcategories")
public interface TicketCategoryRepository extends JpaRepository<TicketCategoryEntity, Long> {
}
