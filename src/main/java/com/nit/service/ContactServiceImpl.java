package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.ContactDetailsEntity;
import com.nit.model.Contact;
import com.nit.repository.ContactDetailsRepository;

/**
 * 
 * This Is A Implementation Of ContactService(I) It FulFills The Requirment Of
 * Controller To Perform DB Related Operation
 * 
 * @author Himanshu Sekhar
 * @version 1.0
 * @since Dec-23-2019
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDetailsRepository cntctDetailsRepo;

	/**
	 * This Method Is For Storing Contact Details To DataBase
	 * 
	 * @param Contact c
	 * @return boolean
	 */
	@Override
	public boolean saveContact(Contact c) {
		ContactDetailsEntity entity = new ContactDetailsEntity();
		BeanUtils.copyProperties(c, entity);
		entity.setRecordStatus("Y");
		ContactDetailsEntity savedEntity = cntctDetailsRepo.save(entity);
		return savedEntity.getContactId() > 0;
	}

	/**
	 * This Method Is For Fetching All Contact From DataBase
	 * 
	 * @return List<Contact>
	 */
	@Override
	public List<Contact> getAllContact() {
		List<ContactDetailsEntity> entityList = cntctDetailsRepo.findAll();

		List<Contact> contactList = new ArrayList<>();
		List<ContactDetailsEntity> finalEntityList = entityList.stream()
				.filter(entity -> "Y".equals(entity.getRecordStatus())).collect(Collectors.toList());

		finalEntityList.forEach(entity -> {
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			contactList.add(c);
		});
		return contactList;
	}

	/**
	 * This Method Is For Finding Contact Based On Id Value
	 * 
	 * @param Integer cId
	 * 
	 * @return Contact
	 */
	@Override
	public Contact getContactById(Integer cId) {
		Optional<ContactDetailsEntity> optional = cntctDetailsRepo.findById(cId);
		Contact contact = new Contact();
		if (optional.isPresent()) {
			ContactDetailsEntity entity = optional.get();
			BeanUtils.copyProperties(entity, contact);
		}
		return contact;
	}

	/**
	 * This Method Is Used For Soft Deleting Operation
	 * 
	 * @param Integer cId
	 * 
	 * @return boolean
	 */
	@Override
	public boolean deleteContact(Integer cId) {
		cntctDetailsRepo.updateRecordBasedOnStatus("N", cId);
		return true;
	}

}
