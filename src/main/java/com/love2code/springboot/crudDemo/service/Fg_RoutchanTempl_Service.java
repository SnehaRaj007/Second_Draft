package com.love2code.springboot.crudDemo.service;

import java.util.List;

import com.love2code.springboot.crudDemo.entity.ChanTemplateDTO;

public interface Fg_RoutchanTempl_Service {
	
	List<ChanTemplateDTO> fetchChannelTemplateDataInnerJoin(int route_chan_temp_key);

}
