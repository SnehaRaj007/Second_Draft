package com.love2code.springboot.crudDemo.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import com.love2code.springboot.crudDemo.entity.Active;


public interface AciveTableService {
	
	public List<Active> findall();
	public Active create(Active active);
	boolean existsInActiveTable(int i,int j);
	int idInActiveTable(int tmpl_key,int routchankey);
	void setDateForActive(Date date, int id);
	public ByteArrayInputStream downloadactive();
	

}
