package com.love2code.springboot.crudDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.springboot.crudDemo.dao.PartnersWithFlagRepository;
import com.love2code.springboot.crudDemo.entity.PartnersWithFlg;

@Service
public class PartnerWithFlgServiceImpl implements PartnerWithFlgService {
	
	@Autowired
	PartnersWithFlagRepository partnersWithFlagRepository;

	

	@Override
	public PartnersWithFlg create(PartnersWithFlg partnersWithFlg) {
		
		return partnersWithFlagRepository.save(partnersWithFlg);
	}



	@Override
	public void setStatusForPartner(String status, int id) {
		partnersWithFlagRepository.setStatusForPartner(status, id);
		
	}



	

}
