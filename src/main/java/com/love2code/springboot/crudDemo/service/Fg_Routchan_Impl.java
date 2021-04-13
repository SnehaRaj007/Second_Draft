package com.love2code.springboot.crudDemo.service;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.springboot.crudDemo.dao.FG_RoutchanRepository;
import com.love2code.springboot.crudDemo.entity.Fg_Routchan;
import com.love2code.springboot.crudDemo.exception.ResourceNotFoundException;
import com.love2code.springboot.crudDemo.util.ExcelHelper;

@Service
public class Fg_Routchan_Impl implements Fg_Routchan_Service {

	private FG_RoutchanRepository fG_RoutchanRepository;
	
	
	
	@Autowired
	public Fg_Routchan_Impl(FG_RoutchanRepository fG_RoutchanRepository) {
		this.fG_RoutchanRepository = fG_RoutchanRepository;
	}
	
	@Override
	public List<Fg_Routchan> findByProducerAndMailbox(String producerName,String mailbox) {
		List<Fg_Routchan> tempList=fG_RoutchanRepository.findByProducerAndMailbox(producerName,mailbox);
		if(tempList==null)
		{
			throw new ResourceNotFoundException("Resource Not Found");
		}
		
		return tempList;
	}

	@Override
	public List<Fg_Routchan> findall() {
		
		return fG_RoutchanRepository.findAll();
	}

	@Override
	public ByteArrayInputStream downloadall(String filename) {
       List<Fg_Routchan> allChannelsAndTemplate=fG_RoutchanRepository.findAll();
		
		ByteArrayInputStream in = ExcelHelper.AllChannelsAndTemplateToExcel(allChannelsAndTemplate,filename);
	    return in;
	}

	@Override
	public ByteArrayInputStream downloadall(List<Fg_Routchan> inactiveChannelsAndTemplates, String filename) {
		ByteArrayInputStream in = ExcelHelper.AllChannelsAndTemplateToExcel(inactiveChannelsAndTemplates,filename);
	    return in;
	}
	

	

	

}
