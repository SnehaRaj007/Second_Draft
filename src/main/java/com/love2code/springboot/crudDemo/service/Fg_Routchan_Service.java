package com.love2code.springboot.crudDemo.service;

import java.io.ByteArrayInputStream;
import java.util.List;
import com.love2code.springboot.crudDemo.entity.Fg_Routchan;

public interface Fg_Routchan_Service {
	
	public List<Fg_Routchan> findByProducerAndMailbox(String producerName,String mailbox);
	public List<Fg_Routchan> findall();
	public ByteArrayInputStream downloadall(String filename);
	public ByteArrayInputStream downloadall(List<Fg_Routchan> inactiveChannelsAndTemplates, String filename);
	
	
}
