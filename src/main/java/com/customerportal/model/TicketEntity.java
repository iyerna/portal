package com.customerportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * The idea behind the customer-related fields in this class is as follows. If the username is available (e.g., an
 * authenticated user submits a ticket), then we leave the e-mail address and full name blank, and look those up from
 * the portal whenever we need them. That way we don't have to worry about keeping the e-mail and full name in sync
 * with the authoritative customer data. If the username is *not* available (e.g., customer submitted an e-mail), then
 * we leave the username blank, and we store the customer's e-mail address and (if available) full name.
 * </p>
 * <p>
 * For right now all tickets have usernames, but in recipe 13.5 we'll have tickets from an e-mail channel where no
 * username is available. Indeed the customer may be a prospective customer with no account and hence no username.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Entity
@Table(name = "ticket")
public class TicketEntity {
	private static final Logger log = LoggerFactory.getLogger(TicketEntity.class);
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "ticket_category_id")
	private TicketCategoryEntity category;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	public Long getId() { return id; }
	
	@SuppressWarnings("unused")
	private void setId(Long id) { this.id = id; }
	
	@NotNull
	public TicketCategoryEntity getCategory() { return category; }
	
	public void setCategory(TicketCategoryEntity category) { this.category = category; }
	
	@NotNull
	public UserEntity getUser() { return user; }
	
	public void setUser(UserEntity user) { this.user = user; }
	
	@NotNull
	@Size(min = 1, max = 4000)
	public String getDescription() { return description; }

	public void setDescription(String desc) { this.description = desc; }
	
	public Date getDateCreated() { return dateCreated; }

	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		
		TicketEntity other = (TicketEntity) obj;
		
		if (category == null) {
			if (other.category != null) { return false; }
		} else if (!category.equals(other.category)) {
			return false;
		}
		
		if (user == null) {
			if (other.user != null) { return false; }
		} else if (!user.equals(other.user)) {
			return false;
		}
		
		if (dateCreated == null) {
			if (other.dateCreated != null) { return false; }
		} else if (!dateCreated.equals(other.dateCreated)) {
			return false;
		}
		
		if (description == null) {
			if (other.description != null) { return false; }
		} else if (!description.equals(other.description)) {
			return false;
		}
		
		if (id == null) {
			if (other.id != null) { return false; }
		} else if (!id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
}
