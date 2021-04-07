package com.love2code.springboot.crudDemo.service;

import java.io.ByteArrayInputStream;
import java.util.List;


import com.love2code.springboot.crudDemo.entity.Partners;

public interface PartnerService {
	public List<Partners> findall();
	public ByteArrayInputStream downloadall();

}
