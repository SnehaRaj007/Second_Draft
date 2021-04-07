package com.love2code.springboot.crudDemo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.love2code.springboot.crudDemo.entity.Fg_Routchan;

public interface FG_RoutchanRepository extends JpaRepository<Fg_Routchan, Integer> {
	
	@Query("SELECT f FROM Fg_Routchan f where f.prod_org_key = ?1 and f.mailbox=?2")
    public List<Fg_Routchan> findByProducerAndMailbox(String producerName,String mailbox);
    
  /*  @Query("SELECT new com.love2code.springboot.crudDemo.entity.ChanTemplateDTO(d.routchan_tmpl_key,d.fg_Routchan.tmpl_name, d.fg_Routchan.pv_mbx_pattern, d.fg_Routchan.consid_type, d.routchan_key) from Fg_Routchan d, Fg_Routchan_Template e  where d.routchan_tmpl_key=e")
	List<ChanTemplateDTO> fetchChannelTemplateDataInnerJoin();*/
   

}
