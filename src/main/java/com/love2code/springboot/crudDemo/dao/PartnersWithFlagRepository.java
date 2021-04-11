package com.love2code.springboot.crudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springboot.crudDemo.entity.PartnersWithFlg;

public interface PartnersWithFlagRepository extends JpaRepository<PartnersWithFlg, Integer> {
	
	@Modifying
	@Transactional
	@Query("update PartnersWithFlg p set p.Status = ?1 where p.tp_object_id = ?2")
	void setStatusForPartner(String status, int id);

}
