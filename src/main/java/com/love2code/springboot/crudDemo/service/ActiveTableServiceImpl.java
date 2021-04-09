package com.love2code.springboot.crudDemo.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.springboot.crudDemo.dao.ActiveTableRepository;
import com.love2code.springboot.crudDemo.entity.Active;
import com.love2code.springboot.crudDemo.util.ExcelHelper;

@Service
public class ActiveTableServiceImpl implements AciveTableService {
	
	@Autowired
	ActiveTableRepository activeTableRepository;

	@Override
	public Active create(Active active) {
		
		return activeTableRepository.save(active);
		
		
	}

	@Override
	public boolean existsInActiveTable(int tmpl_key, int routchankey) {
		
		return activeTableRepository.existsInActiveTable(tmpl_key, routchankey);
	}

	@Override
	public int idInActiveTable(int tmpl_key, int routchankey) {
		
		return activeTableRepository.idInActiveTable(tmpl_key, routchankey);
	}

	@Override
	public void setDateForActive(Date date, int id) {
		activeTableRepository.setDateForActive(date, id);
		
	}

	@Override
	public List<Active> findall() {
		
		return activeTableRepository.findAll();
	}

	@Override
	public ByteArrayInputStream downloadactive() {
       List<Active> activeChannelsAndTemplate=activeTableRepository.findAll();
		
		ByteArrayInputStream in = ExcelHelper.ActiveChannelsAndTemplateToExcel(activeChannelsAndTemplate);
	    return in;
	}

	@Override
	public boolean partnerExistsInActiveTable(int partnerID) {
		return activeTableRepository.partnerExistsInActiveTable(partnerID);
	}

}
