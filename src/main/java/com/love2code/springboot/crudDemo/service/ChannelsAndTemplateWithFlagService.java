package com.love2code.springboot.crudDemo.service;

import com.love2code.springboot.crudDemo.entity.ChannelsAndTemplatesWithFlg;

public interface ChannelsAndTemplateWithFlagService {
	
	public ChannelsAndTemplatesWithFlg create(ChannelsAndTemplatesWithFlg channelsAndTemplatesWithFlg);
	void setStatusForChannel(String status, int id);

}
