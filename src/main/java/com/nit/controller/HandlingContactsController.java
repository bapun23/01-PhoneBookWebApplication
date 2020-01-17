package com.nit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.model.Contact;
import com.nit.service.ContactService;

/**
 * This Class Contacts With Service Class To Handle ContactInformation Like Edit
 * And Delete
 * 
 * @author Himanshu Sekhar
 * @version 1.0
 * @since Dec-23-2019
 * 
 */
@Controller
public class HandlingContactsController {

	@Autowired
	private ContactService contactService;

	/**
	 * This Method Is For Editing The Contact Details
	 * 
	 * @param HttpServletRequest req
	 * @param Model              model
	 * 
	 * @return String
	 */
	@RequestMapping("/editContact")
	public String editContact(HttpServletRequest req, Model model) {
		String parameter = req.getParameter("cId");
		int cId = 0;
		if (parameter != null && parameter != "")
			cId = Integer.parseInt(parameter);
		Contact contact = contactService.getContactById(cId);
		model.addAttribute("contact", contact);
		return "contact";
	}

	/**
	 * This Method Is Used For Deleting The Contact Record Control Redirect To
	 * viewContact()
	 * 
	 * @param HttpServletRequest req
	 * @param Model              model
	 * 
	 * @return String
	 */
	@RequestMapping("/deleteContact")
	public String deleteContact(HttpServletRequest req, Model model) {
		String id = req.getParameter("cId");
		if (id != null && id != "") {
			int cId = Integer.parseInt(id);
			contactService.deleteContact(cId);
		}
		return "redirect:/findAllContact";
	}

}
