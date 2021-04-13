package com.love2code.springboot.crudDemo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.springboot.crudDemo.dao.PartnerRepository;

import com.love2code.springboot.crudDemo.entity.Partners;
import com.love2code.springboot.crudDemo.util.ExcelHelper;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepository partnerRepository;
	@Override
	public List<Partners> findall() {
		
		return partnerRepository.findAll();
	}
	@Override
	public ByteArrayInputStream downloadall(String filename) {
		List<Partners> allPartners=partnerRepository.findAll();
		
		ByteArrayInputStream in = ExcelHelper.AllPartnersToExcel(allPartners,filename);
	    return in;
	}
	@Override
	public int idOfPartner(String partnerName) {
		
		return partnerRepository.idOfPartner(partnerName);
	}
	@Override
	public ByteArrayInputStream downloadall(List<Partners> inactivePartnersList,String filename) {
		ByteArrayInputStream in = ExcelHelper.AllPartnersToExcel(inactivePartnersList,filename);
	    return in;
	}

}
