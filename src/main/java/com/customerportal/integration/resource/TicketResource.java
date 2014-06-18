package com.customerportal.integration.resource;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class TicketResource implements Serializable {
	
	private static final long serialVersionUID = -7788619177798333712L;
	
	private long id;
	private String userName;
	private String category;
	private String description;
	private Date dateCreated;
	
	public long getId() { return id; }
	
	public void setId(long id) { this.id = id; }
	
	public String getUsername() { return userName; }
	
	public void setUsername(String username) { this.userName = username; }
	
	public String getCategory() { return category; }
	
	public void setCategory(String category) { this.category = category; }
	
	@NotNull
	@Size(max = 4000)
	public String getDescription() { return description; }
	
	public void setDescription(String description) { this.description = description; }
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getDateCreated() { return dateCreated; }
	
	public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

	@Override
	public String toString() {
		return "TicketResource [ id="+ id
				+ ", username=" + userName
				+ ", category=" + category
				+ ", description=" + description
				+ ", dateCreated=" + dateCreated
				+ "]";
	}
}
