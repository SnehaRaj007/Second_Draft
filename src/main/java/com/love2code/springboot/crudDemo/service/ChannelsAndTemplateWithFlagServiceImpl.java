package com.love2code.springboot.crudDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love2code.springboot.crudDemo.dao.ChannelsAndTemplatesWithFlagRepository;
import com.love2code.springboot.crudDemo.entity.ChannelsAndTemplatesWithFlg;

@Service
public class ChannelsAndTemplateWithFlagServiceImpl implements ChannelsAndTemplateWithFlagService {

	@Autowired
	ChannelsAndTemplatesWithFlagRepository channelsAndTemplatesWithFlagRepository;
	
	@Override
	public ChannelsAndTemplatesWithFlg create(ChannelsAndTemplatesWithFlg channelsAndTemplatesWithFlg) {
		
		return channelsAndTemplatesWithFlagRepository.save(channelsAndTemplatesWithFlg);
	}

	@Override
	public void setStatusForChannel(String status, int id) {
		channelsAndTemplatesWithFlagRepository.setStatusForChannel(status, id);

	}

}
