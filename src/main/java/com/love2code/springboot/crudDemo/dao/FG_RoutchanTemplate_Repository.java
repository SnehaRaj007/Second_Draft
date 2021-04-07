package com.love2code.springboot.crudDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.love2code.springboot.crudDemo.entity.ChanTemplateDTO;
import com.love2code.springboot.crudDemo.entity.Fg_Routchan_Template;

public interface FG_RoutchanTemplate_Repository extends JpaRepository<Fg_Routchan_Template, Integer> {
	
	
	 @Query("SELECT new com.love2code.springboot.crudDemo.entity.ChanTemplateDTO(t.routchan_tmpl_key, t.tmpl_name,t.pv_mbx_pattern,t.consid_type,c.routchan_key,c.mailbox) FROM Fg_Routchan_Template t JOIN t.fg_Routchan c where c.routchan_tmpl_key = ?1 ")
	    List<ChanTemplateDTO> fetchChannelTemplateDataInnerJoin(int route_chan_temp_key);

}
