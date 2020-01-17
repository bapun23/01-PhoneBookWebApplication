package com.nit.model;

import lombok.Data;

/**
 * 
 * This Is A Model Class Which Collects Form Data And Sends Rresults To Form
 * 
 * @author Himanshu Sekhar
 * @version 1.0
 * @since Dec-23-2019
 *
 */
@Data
public class Contact {
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long phoneNo;
	
}
