package com.love2code.springboot.crudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.love2code.springboot.crudDemo.entity.Partners;

public interface PartnerRepository extends JpaRepository<Partners, Integer> {
	
	@Query("select p.tp_object_id from Partners p where p.user_id = ?1")
	int idOfPartner(String partnerName);

}
