package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hp.constants.AppConstants;
import com.nit.model.Contact;
import com.nit.service.ContactService;

/**
 * This Class Contacts With Service Class To Save Contact Information And Retriving All Available Records
 * 
 * @author		Himanshu Sekhar
 * @version 		1.0
 * @since 		Dec-23-2019
 *
 */
@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	/**
	 * This Method Is Used For Loading The Form And Adding The Form Data To Model Attribute
	 * 
	 * @param Model model
	 * 
	 * @return String
	 */
	@RequestMapping(value = {"/","addContact"}, method = RequestMethod.GET)
	public String displayContactForm(Model model) {
		Contact c = new Contact();
		model.addAttribute(AppConstants.CONTACTID, c);
		return AppConstants.CONTACTID;
	}

	/**
	 * This Method Is Used To Handle Save Contact Form Submission
	 * Control Redirect To displayContactForm()
	 * 
	 * @param Contact c
	 * @param RedirectAttribute
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String handleSubmitButton(@ModelAttribute(AppConstants.CONTACTID) Contact c, RedirectAttributes attribute) {
		boolean flag = contactService.saveContact(c);
		if (flag)
			attribute.addFlashAttribute("result", "Contact Saved Successfully...!!");
		else
			attribute.addFlashAttribute("result", "Contact Not Saved...!!");
		return "redirect:/addContact";
	}

	/**
	 * This Method Is Used For Showing All the Contacts Available In DataBase
	 * 
	 * @param Model model
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/findAllContact")
	public String viewContact(Model model) {
		List<Contact> allContact = contactService.getAllContact();
		model.addAttribute("contact", allContact);
		return "view_contact";
	}

}
