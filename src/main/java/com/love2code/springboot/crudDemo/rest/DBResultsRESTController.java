package com.love2code.springboot.crudDemo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.love2code.springboot.crudDemo.Model.InputJson;
import com.love2code.springboot.crudDemo.entity.Active;
import com.love2code.springboot.crudDemo.entity.Fg_Routchan;
import com.love2code.springboot.crudDemo.entity.Partners;
import com.love2code.springboot.crudDemo.impl.BusinessLogicImpl;


@RestController
@RequestMapping("/api")
public class DBResultsRESTController {
	
/****Autowiring the Business implementation Service 
 * 
 * 
 */
	@Autowired
	BusinessLogicImpl businessLogicImpl;
	Logger logger = LoggerFactory.getLogger(DBResultsRESTController.class);
	
/*************************************************************************************************************************
*************************************************************************************************************************
*This is api to get all existing routing channels and templates from DB
*
*
*/
 		
@GetMapping("/channelsAndTemplates/all")
 
public ResponseEntity<List<Fg_Routchan>> allChannelsAndTemplate()
 {
	 return new ResponseEntity<List<Fg_Routchan>>(businessLogicImpl.allChannelsAndTemplate(),HttpStatus.OK);
	 
 }
 	  
/*************************************************************************************************************************
*************************************************************************************************************************
	 	  
***This is api to get all existing partners from DB
*
*/
@GetMapping("/partners/all")
public ResponseEntity<List<Partners>> allPartners()
{
	 return new ResponseEntity<List<Partners>>(businessLogicImpl.allPartners(),HttpStatus.OK);
	 
}
 /*************************************************************************************************************************
 *************************************************************************************************************************
 	 	  
 ***This is api to download all existing routing channels and templates from DB
 *
 */	
 @GetMapping("/channelsAndTemplates/all/download")
 public ResponseEntity<Resource> allChannelsAndTemplateDownload() {
	 
	    return businessLogicImpl.allChannelsAndTemplateDownload();
}
 
 /*************************************************************************************************************************
  *************************************************************************************************************************
  	 	  
  ***This is api to download all existing Partners from DB
  *
  */	
 
 @GetMapping("/partners/all/download")
 public ResponseEntity<Resource> allPartnersDownload() {
	 return businessLogicImpl.allPartnersDownload();
}
 /*************************************************************************************************************************
 * *************************************************************************************************************************
  	 	  
 ***This is api to get all active channels and templates from DB on basis of arrived files for a date
 * 
 *
 */

 
 @PostMapping("/channelsAndTemplates/active")
 public ResponseEntity<List<List<Fg_Routchan>>> activechannelsAndTemplates(@RequestBody InputJson inputJson )
 
 {
	 logger.info("Entered Date :"+inputJson.getDate());
	 String userEnteredDate=inputJson.getDate();
 	 return new ResponseEntity<List<List<Fg_Routchan>>>(businessLogicImpl.activechannelsAndTemplates(userEnteredDate),HttpStatus.OK);
 	 
 }
 
 
 
 /*************************************************************************************************************************
 * *****************************************************************************************************************************
   	 	  
 ****This is api to download all active channels and templates from DB on basis of arrived files for a date
 *
 */
 @GetMapping("/channelsAndTemplates/active/download")
 public ResponseEntity<Resource> activeChannelsAndTemplates() {
		    return businessLogicImpl.activeChannelsAndTemplates();
 }
 /*************************************************************************************************************************
  * *************************************************************************************************************************
 	  
****This is api to get all inactive channels and templates from DB 
*
*/	  
 @GetMapping("/channelsAndTemplates/inactive")
 
 public ResponseEntity<List<Fg_Routchan>> inactiveChannelsAndTemplate()
  {
 	 return new ResponseEntity<List<Fg_Routchan>>(businessLogicImpl.inactiveChannelsAndTemplate(),HttpStatus.OK);
 	 
  }  
	  
 /*************************************************************************************************************************
  * *************************************************************************************************************************
 	  
****This is api to download all inactive channels and templates from DB 
*
*/
 @GetMapping("/channelsAndTemplates/inactive/download")
 public void example6()
 {
	 
 }
 /*************************************************************************************************************************
  * *****************************************************************************************************************************
    	 	  
  ****This is api to get all inactive partners from DB
  *
  */
  @GetMapping("/partners/inactive")
  public ResponseEntity<List<Partners>> inactivePartners() {
 		    
 	 return new ResponseEntity<List<Partners>>(businessLogicImpl.inactivePartners(),HttpStatus.OK);
  }
  /*************************************************************************************************************************
  *************************************************************************************************************************
  *This is api to download all inactive partners from DB
  *
  *
  */
  @GetMapping("/partners/inactive/download")
  public void fr()
  {
	  
  }
  
  /*************************************************************************************************************************
   *************************************************************************************************************************
  *This is api to delete all entries older than an year  from Active Table
  *
  *
  */  	  
  @GetMapping("/inactive/delete")
  
  public ResponseEntity<List<Active>> deleteEntriesOlderThanAnYearFromActiveTable()
   {
  	 return new ResponseEntity<List<Active>>(businessLogicImpl.deleteEntriesOlderThanAnYearFromActiveTable(),HttpStatus.OK);
  	 
   }  
		
}
