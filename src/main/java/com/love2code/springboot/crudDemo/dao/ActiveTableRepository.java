package com.love2code.springboot.crudDemo.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springboot.crudDemo.entity.Active;

public interface ActiveTableRepository extends JpaRepository<Active, Integer> {
	
	@Query("select case when count(a)> 0 then true else false end from Active a where a.routchan_tmpl_key = ?1 and a.routchan_key=?2")
	boolean existsInActiveTable(int tmpl_key,int routchankey);
	
	@Query("select a.id  from Active a where a.routchan_tmpl_key = ?1 and a.routchan_key=?2")
	int idInActiveTable(int tmpl_key,int routchankey);
	
	@Modifying
	@Transactional
	@Query("update Active a set a.date = ?1 where a.id = ?2")
	void setDateForActive(Date date, int id);

	@Query("select case when count(a)> 0 then true else false end from Active a where a.producerId = ?1 or a.consumerId=?1")
	boolean partnerExistsInActiveTable(int partnerID);

	@Query("select case when count(a)> 0 then true else false end from Active a where a.routchan_key = ?1")
	boolean channelExistsInActiveTable(int routchan_key);

}
