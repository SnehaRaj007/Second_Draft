package com.love2code.springboot.crudDemo.service;


import com.love2code.springboot.crudDemo.entity.PartnersWithFlg;

public interface PartnerWithFlgService {
	
	public PartnersWithFlg create(PartnersWithFlg partnersWithFlg);
	void setStatusForPartner(String status, int id);

}
