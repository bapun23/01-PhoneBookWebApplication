package com.nit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nit.entity.ContactDetailsEntity;

/**
 * 
 * This Is Extending From JpaRepository(I) To Perform DB Operation
 * 
 * @author Himanshu Sekhar
 * @version 1.0
 * @since Dec-23-2019
 *
 */
@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetailsEntity, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "update ContactDetailsEntity set recordStatus=:status where contactId=:cId")
	public void updateRecordBasedOnStatus(String status,Integer cId);

}
