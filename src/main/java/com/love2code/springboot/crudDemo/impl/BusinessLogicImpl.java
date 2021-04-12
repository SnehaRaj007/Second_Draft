package com.love2code.springboot.crudDemo.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.love2code.springboot.crudDemo.entity.Active;
import com.love2code.springboot.crudDemo.entity.ChanTemplateDTO;
import com.love2code.springboot.crudDemo.entity.ChannelsAndTemplatesWithFlg;
import com.love2code.springboot.crudDemo.entity.FgArrivedFile;
import com.love2code.springboot.crudDemo.entity.Fg_Routchan;
import com.love2code.springboot.crudDemo.entity.Partners;
import com.love2code.springboot.crudDemo.entity.PartnersWithFlg;
import com.love2code.springboot.crudDemo.exception.ResourceNotFoundException;
import com.love2code.springboot.crudDemo.service.AciveTableService;
import com.love2code.springboot.crudDemo.service.ArrivedFileResultsService;
import com.love2code.springboot.crudDemo.service.ChannelsAndTemplateWithFlagService;
import com.love2code.springboot.crudDemo.service.Fg_RoutchanTempl_Service;
import com.love2code.springboot.crudDemo.service.Fg_Routchan_Service;
import com.love2code.springboot.crudDemo.service.PartnerService;
import com.love2code.springboot.crudDemo.service.PartnerWithFlgService;

@Service
public class BusinessLogicImpl {

	/****Autowiring the services
	 * 
	 * 
	 */
	@Autowired
	private ArrivedFileResultsService arrivedFileResultsService;
	
	@Autowired
	private Fg_Routchan_Service fg_Routchan_Service;
	
	@Autowired
	PartnerService partnerService;
	
	@Autowired
	AciveTableService aciveTableService;

	@Autowired
	private Fg_RoutchanTempl_Service fg_RoutchanTempl_Service;
	
	@Autowired
	private PartnerWithFlgService partnerWithFlgService;
	
	@Autowired
	private ChannelsAndTemplateWithFlagService channelsAndTemplateWithFlagService;
	
	Logger logger = LoggerFactory.getLogger(BusinessLogicImpl.class);
	
	public BusinessLogicImpl() {
		
	}
	
/*To return all channels and templates in DB
* 
*/
	public List<Fg_Routchan> allChannelsAndTemplate()
	 {
	List<Fg_Routchan> allChannelsAndTemplate = fg_Routchan_Service.findall();
	if(allChannelsAndTemplate==null)
	{
		throw new ResourceNotFoundException("Resource Not Found");
	}
	return allChannelsAndTemplate;

}
/************************************************************************************************************************
*To return all existing partners from  DB
* 
*/	
	public List<Partners> allPartners()
	 
	 {
		 List<Partners> allPartners = partnerService.findall();
			if(allPartners==null)
			{
				throw new ResourceNotFoundException("Resource Not Found");
			}
			return allPartners;
	}
/************************************************************************************************************************
*To  download all existing routing channels and templates from DB
* 
*/
	public ResponseEntity<Resource> allChannelsAndTemplateDownload() {
	    String filename = "AllChannelsAndTemplateRepository_sheet.xlsx";
	    InputStreamResource file = new InputStreamResource(fg_Routchan_Service.downloadall());
	    
	    if (!file.exists()) {
	    	throw new ResourceNotFoundException("Resource Not Found");
	     }
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	  }
/************************************************************************************************************************
*To  download all existing Partners from DB
* 
*/
	 public ResponseEntity<Resource> allPartnersDownload() {
		    String filename = "AllPartnersRepository_sheet.xlsx";
		    InputStreamResource file = new InputStreamResource(partnerService.downloadall());
		    if (!file.exists()) {
		    	throw new ResourceNotFoundException("Resource Not Found");
		     }
		    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
		        .body(file);
		  }
/************************************************************************************************************************
*To  download all active channels and templates from DB on basis of arrived files for a date
* 
*/
	 public ResponseEntity<Resource> activeChannelsAndTemplates() {
		    String filename = "ActiveChannelsAndTemplatesRepository_sheet.xlsx";
		    InputStreamResource file = new InputStreamResource(aciveTableService.downloadactive());
		    if (!file.exists()) {
		    	throw new ResourceNotFoundException("Resource Not Found");
		     }
		    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
		        .body(file);
}
/************************************************************************************************************************
*To  find all active channels and templates from DB on basis of arrived files for a date
* 
*/
	 /*
	 * METHOD 1 (To find User-Entered Date with 23:59:59)
	 */

	 public Date userEnteredDateWithHours(String userEnteredDate) {
	 	Date userEnteredDateWithHours = null;
	 	  
	 	   
	 	  String tempdate1=userEnteredDate+" 23:59:59";
	 	  try {
	 		  userEnteredDateWithHours=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tempdate1);
	 		 
	 		  logger.info("User Entered Date With Hours: "+userEnteredDateWithHours);
	 	  }
	 	  catch (ParseException e) { 
	 		   e.printStackTrace();
	 		  }
	 	  return userEnteredDateWithHours;
	 }
/*
 * METHOD 2 (To find To date (one day before User-Entered Date)
 */
	  
	 

	public Date returnOneDayBeforeDate(String userEnteredDate) {
		
		  
		  Date datetemp=null;
		  Date dateOneDayBefore=null;
		  
		  
		  try {
			  
			  
		  datetemp=new SimpleDateFormat("yyyy-MM-dd").parse(userEnteredDate);
		  Calendar calendar = Calendar.getInstance(); 
		  calendar.setTime(datetemp);
		  calendar.add(Calendar.DATE, -1); 
		  dateOneDayBefore = calendar.getTime();
		  
		  
		  logger.info("dateOneDayBefore: "+dateOneDayBefore);
		  
		  } catch (ParseException e) { 
		   e.printStackTrace();
		  }
		return dateOneDayBefore;
	}
	 
/*
 * METHOD 3 (To find To date (two weeks before User-Entered Date)
*/
	 
	 public Date returnTwoWeekBeforeDate(String userEnteredDate) {
			
		  
		  Date datetemp=null;
		  Date dateTwoWeekBefore=null;
		  
		  
		  try {
			  
			  
		  datetemp=new SimpleDateFormat("yyyy-MM-dd").parse(userEnteredDate);
		  Calendar calendar = Calendar.getInstance(); 
		  calendar.setTime(datetemp);
		  calendar.add(Calendar.DATE, -14); 
		  dateTwoWeekBefore = calendar.getTime();
		  
		  
		  logger.info("dateTwoWeekBefore: "+dateTwoWeekBefore);
		  
		  } catch (ParseException e) { 
		   e.printStackTrace();
		  }
		return dateTwoWeekBefore;
	}
	 
	/*
	 * METHOD 4 (To find list of arrived files on basis of user entered date and -1)
	 */

	public List<FgArrivedFile> findArrivedFilesListByDate(Date oneDayBeforeDate, Date userEnteredDateWithHours) {
		List<FgArrivedFile> fg_arrive_list =arrivedFileResultsService.findByStatusBetween(oneDayBeforeDate,userEnteredDateWithHours);
		if(fg_arrive_list==null)
		{
			throw new ResourceNotFoundException("Resource Not Found");
		}
		return fg_arrive_list;
	}
	
/*
* METHOD 5 (To return Partner ID from Partners (SCI_CODE_USR_XREF) table)
*/	
	
	private Integer[] returnPartnerIdfromPartnersTable(String producerName,String consumerName)
	{
	Integer[] partnerIds=new Integer[2];
	int producerId=0;
	int consumerId=0;
	producerId=partnerService.idOfPartner(producerName);
	logger.info("producer_Id"+producerId);
	consumerId=partnerService.idOfPartner(consumerName);
	logger.info("consumerId"+consumerId);
	if(producerId!=0 && consumerId!=0)
	{
	partnerIds[0]=producerId;
	partnerIds[1]=consumerId;
	}
	return partnerIds;
	}
	
	
	
	
	
	
	
/*
* METHOD 6 (Utility Method To find list of active channels and templates on basis of user entered date and -14 days)
*/
	public List<List<Fg_Routchan>> returnActiveChannelsAndTemplatesList(List<FgArrivedFile> fg_arrive_list) {
		List <List<Fg_Routchan>> finnalFgRoutelist=new ArrayList<List<Fg_Routchan>>();
		for (FgArrivedFile templist:fg_arrive_list)
		{
			List<Fg_Routchan> tempval = fg_Routchan_Service.findByProducerAndMailbox(templist.getUser_id(),templist.getMailbox_path());
			
			finnalFgRoutelist.add(tempval);
			for  (Fg_Routchan fg_Routchan:tempval)
			{
				
				List<ChanTemplateDTO> tempjoin = fg_RoutchanTempl_Service.fetchChannelTemplateDataInnerJoin(fg_Routchan.getRoutchan_tmpl_key());
				
				logger.info("tempjoin: "+tempjoin);
				for (ChanTemplateDTO tempDTO:tempjoin)
				{
				 
				
			Integer[] partnerIds = returnPartnerIdfromPartnersTable(tempDTO.getPv_mbx_pattern(),tempDTO.getConsid_type());
				
		
							
				boolean entryexistsinActiveTable=aciveTableService.existsInActiveTable(tempDTO.getRoutchan_tmpl_key(), tempDTO.getRoutchan_key());
				 if(!entryexistsinActiveTable)
				 {
					 
					 Active active=new Active(tempDTO.getRoutchan_tmpl_key(),
							 tempDTO.getRoutchan_key(),
							 tempDTO.getPv_mbx_pattern(),
							 tempDTO.getConsid_type(),
							 tempDTO.getTmpl_name(),
							 tempDTO.getMailbox(),
							 "Yes", 
							 templist.getStatus(),
							 partnerIds[0].intValue(),
							 partnerIds[1].intValue());
					 aciveTableService.create(active);
					 
					
				 }
				 else
				 {
					 int id=aciveTableService.idInActiveTable(tempDTO.getRoutchan_tmpl_key(), tempDTO.getRoutchan_key());
					 
					 logger.info("ID :"+id);
					 aciveTableService.setDateForActive(templist.getStatus(),id);
				 }
				 
				 
				 
				
				}
				
				
			}
			
		}
		return finnalFgRoutelist;
	}
/*
* METHOD 7 (Main Method To find list of active channels and templates on basis of user entered date and -14 days,
* this methods calls the Method 6 for looping and fetching values)
*/	

	public List<List<Fg_Routchan>> activechannelsAndTemplates(String userEnteredDate) {
		Date toDate=userEnteredDateWithHours(userEnteredDate);
		 Date fromDate = returnTwoWeekBeforeDate(userEnteredDate);
		  
		 List<FgArrivedFile> fg_arrive_list =findArrivedFilesListByDate(fromDate,toDate);
		  
		  logger.info("Size "+fg_arrive_list.size());
		  
		  
		  List <List<Fg_Routchan>> finnalFgRoutelist = returnActiveChannelsAndTemplatesList(fg_arrive_list);
		  if(finnalFgRoutelist==null)
			{
				throw new ResourceNotFoundException("Resource Not Found");
			}
		return finnalFgRoutelist;
	}

/************************************************************************************************************************
*To  get all inactive partners from DB on basis of arrived files for a date
* 
*/	

	public List<Partners> inactivePartners() {
		List<Partners>allPartners=allPartners();
		List<Partners> partnersWithFlg=new  ArrayList<Partners>();
		for(Partners tempPartner:allPartners ) 
		{
			String flag="inactive";
			
			PartnersWithFlg	 partnerflg=new PartnersWithFlg(tempPartner.getTp_object_id(),
					tempPartner.getUser_id(),
					tempPartner.getDate_invited(),
					 flag);
					 partnerWithFlgService.create(partnerflg);
			
			boolean partnerExistsInActiveTable=aciveTableService.partnerExistsInActiveTable(tempPartner.getTp_object_id());
			if(partnerExistsInActiveTable)
			{
				flag="active";
				partnerWithFlgService.setStatusForPartner(flag,tempPartner.getTp_object_id());
				
			}
			else
			{
				partnersWithFlg.add(tempPartner);
			}
			
			
			
		}
		
		return partnersWithFlg;
	}
/************************************************************************************************************************
*To  get all inactive channels and templates from DB on basis of arrived files for a date
* 
*/	

public List<Fg_Routchan> inactiveChannelsAndTemplate() {
	List<Fg_Routchan> allChannelsAndTemplates=allChannelsAndTemplate();
	List<Fg_Routchan> inactiveChannelsAndTemplate=new  ArrayList<Fg_Routchan>();
	for (Fg_Routchan tempChannelsAndTemplates:allChannelsAndTemplates )
	{
		String flag="inactive";
		
		ChannelsAndTemplatesWithFlg	 channelsAndTemplatesWithFlg=new ChannelsAndTemplatesWithFlg(tempChannelsAndTemplates.getRoutchan_tmpl_key(),
				tempChannelsAndTemplates.getRoutchan_key(),
				tempChannelsAndTemplates.getMailbox(),
				tempChannelsAndTemplates.getProd_org_key(),
				tempChannelsAndTemplates.getCons_org_key(),
				tempChannelsAndTemplates.getFg_Routchan_Template().getTmpl_name(),
				 flag);
		channelsAndTemplateWithFlagService.create(channelsAndTemplatesWithFlg);
		
		boolean channelExistsInActiveTable=aciveTableService.channelExistsInActiveTable(tempChannelsAndTemplates.getRoutchan_key());
		if(channelExistsInActiveTable)
		{
			flag="active";
			channelsAndTemplateWithFlagService.setStatusForChannel(flag, tempChannelsAndTemplates.getRoutchan_key());
			
		}
		else
		{
			inactiveChannelsAndTemplate.add(tempChannelsAndTemplates);
		}
		
	}
	
	return inactiveChannelsAndTemplate;
}
/************************************************************************************************************************
*To  delete all rows older than one year from Active Table
* 
*/

public List<Active> deleteEntriesOlderThanAnYearFromActiveTable() {
	List<Active> allActive=aciveTableService.findall();
	List<Active> deletedActiveOlderThanAnYear=new  ArrayList<Active>();
	if(allActive!=null)
	{
		Date previousYear=getPreviousYear();
		deletedActiveOlderThanAnYear=deletedActiveOlderThanAnYear(previousYear,allActive);
		if(deletedActiveOlderThanAnYear==null)
		{
			//Work on exiting with message--NOTHING TO DELETE
		}
	}
	else
	{
		throw new ResourceNotFoundException("Resource Not Found");
	}
	return deletedActiveOlderThanAnYear;
	
	
	
}

/*
* METHOD 8 (To find the list of rows from active table to be deleted, called by main method)
*/
private List<Active> deletedActiveOlderThanAnYear(Date previousYear, List<Active> allActive) {
List<Active> deletedActiveOlderThanAnYear=new  ArrayList<Active>();
	
	for(Active tempActive:allActive)
	{
		Date date = tempActive.getDate();
		boolean isDateOlderThanOneYear = date.before(previousYear);
		if(isDateOlderThanOneYear)
			
		{
			aciveTableService.delete(tempActive);
			deletedActiveOlderThanAnYear.add(tempActive);
			
		}
	}
	
	
	
	return deletedActiveOlderThanAnYear;
	
}

/*
* METHOD 9 (To find previous year, called by main method)
*/
private Date getPreviousYear() {
	Calendar cal = Calendar.getInstance();
    Date cdate = cal.getTime();
    cal.add(Calendar.YEAR, -1);
    Date previousYear=cal.getTime();
    return previousYear;
	}


}
