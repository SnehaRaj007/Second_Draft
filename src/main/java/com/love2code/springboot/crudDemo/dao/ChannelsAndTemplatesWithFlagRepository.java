package com.love2code.springboot.crudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springboot.crudDemo.entity.ChannelsAndTemplatesWithFlg;

public interface ChannelsAndTemplatesWithFlagRepository extends JpaRepository<ChannelsAndTemplatesWithFlg, Integer> {
	
	@Modifying
	@Transactional
	@Query("update ChannelsAndTemplatesWithFlg c set c.status = ?1 where c.routchan_key = ?2")
	void setStatusForChannel(String status, int id);


}
