package com.nit.service;

import java.util.List;

import com.nit.model.Contact;

/**
 * 
 * This Provides Implementation For Performing Different Types Of DB Operation
 * 
 * @author Himanshu Sekhar
 * @version 1.0
 * @since Dec-23-2019
 *
 */
public interface ContactService {
	
	public boolean saveContact(Contact c);
	
	public List<Contact> getAllContact();
	
	public Contact getContactById(Integer cId);
	
	public boolean deleteContact(Integer cId);
	
}
