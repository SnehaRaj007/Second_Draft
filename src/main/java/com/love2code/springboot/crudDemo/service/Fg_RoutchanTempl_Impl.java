package com.love2code.springboot.crudDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.springboot.crudDemo.dao.FG_RoutchanTemplate_Repository;
import com.love2code.springboot.crudDemo.entity.ChanTemplateDTO;
import com.love2code.springboot.crudDemo.exception.ResourceNotFoundException;

@Service
public class Fg_RoutchanTempl_Impl implements Fg_RoutchanTempl_Service {
	
private FG_RoutchanTemplate_Repository fG_RoutchanTemplate_Repository;
	
	@Autowired
	public Fg_RoutchanTempl_Impl(FG_RoutchanTemplate_Repository fG_RoutchanTemplate_Repository) {
		this.fG_RoutchanTemplate_Repository = fG_RoutchanTemplate_Repository;
	}

	@Override
	public List<ChanTemplateDTO> fetchChannelTemplateDataInnerJoin(int route_chan_temp_key) {
		
		List<ChanTemplateDTO> tempDTO=fG_RoutchanTemplate_Repository.fetchChannelTemplateDataInnerJoin(route_chan_temp_key);
		if(tempDTO==null)
		{
			throw new ResourceNotFoundException("Resource Not Found");
		}
		return tempDTO;
	}

	

}
