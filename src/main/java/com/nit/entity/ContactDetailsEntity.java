package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * 
 * This Is A Helper Class Which Hepls Repository To Complete DB Operation
 * 
 * @author Himanshu Sekhar
 * @version 1.0
 * @since Dec-23-2019
 *
 */
@Entity
@Table(name = "CONTACT_DETAILS")
@Data
public class ContactDetailsEntity {
	
	@Id
	@Column(name = "contact_Id" ,length = 10)
	@GeneratedValue
	private Integer contactId;
	
	@Column(name = "contact_name",length = 50)
	private String contactName;
	
	@Column(name = "contact_email",length = 50)
	private String contactEmail;
	
	@Column(name = "mobile_no",length = 10)
	private Long phoneNo;
	
	@Column(name = "record_status",length = 1)
	private String recordStatus;

}
