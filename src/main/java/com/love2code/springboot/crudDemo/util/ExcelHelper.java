package com.love2code.springboot.crudDemo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.love2code.springboot.crudDemo.entity.Active;
import com.love2code.springboot.crudDemo.entity.Fg_Routchan;
import com.love2code.springboot.crudDemo.entity.Partners;

public class ExcelHelper {
	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  

	/*
	 * Download all the partners in excel
	 * 
	 * 
	 */
	  public static ByteArrayInputStream AllPartnersToExcel(List<Partners> allPartners) {
		  String[] HEADERs = { "tp_object_id", "user_id", "date_invited"};
		  String SHEET = "AllPartnersRepository_sheet";

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);
	      CreationHelper creationHelper=workbook.getCreationHelper();
	      CellStyle dateStyle=workbook.createCellStyle();
	      dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss"));
	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	        
	      }

	      
	      int rowIdx = 1;
	      for (Partners results : allPartners) {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(results.getTp_object_id());
	        row.createCell(1).setCellValue(results.getUser_id());
	        Cell dateCell=row.createCell(2);
	       
	        dateCell.setCellValue(results.getDate_invited());
	        dateCell.setCellStyle(dateStyle);
	        
	        
	        
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
/*
 * Download all the templates and channels in excel
 * 
 * 
 */
	  public static ByteArrayInputStream AllChannelsAndTemplateToExcel(List<Fg_Routchan> allChannelsAndTemplate) {
		  String[] HEADERs = { "routchan_key", "routchan_tmpl_key", "tmpl_name","producer","mailbox","consumer"};
		  String SHEET = "AllChannelsAndTemplateRepository_sheet";

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      
	      int rowIdx = 1;
	      for (Fg_Routchan results : allChannelsAndTemplate) {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(results.getRoutchan_key());
	        row.createCell(1).setCellValue(results.getRoutchan_tmpl_key());
	        row.createCell(2).setCellValue(results.getFg_Routchan_Template().getTmpl_name());
	        row.createCell(3).setCellValue(results.getProd_org_key());
	        row.createCell(4).setCellValue(results.getMailbox());
	        row.createCell(5).setCellValue(results.getCons_org_key());
	        
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
	  
	  /*
	   * Download active  templates and channels in excel
	   * 
	   * 
	   */
	public static ByteArrayInputStream ActiveChannelsAndTemplateToExcel(List<Active> activeChannelsAndTemplate) {
		String[] HEADERs = { "ROUTCHAN_TMPL_KEY", "ROUTCHAN_KEY","PROD_ORG_KEY","MAILBOX","CONS_ORG_KEY","ROUTCHAN_TMPL_NAME","ACTIVE","Date"};
		  String SHEET = "AllChannelsAndTemplateRepository_sheet";

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);
	      CreationHelper creationHelper=workbook.getCreationHelper();
	      CellStyle dateStyle=workbook.createCellStyle();
	      dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss"));

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      
	      int rowIdx = 1;
	      for (Active results : activeChannelsAndTemplate) {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(results.getRoutchan_tmpl_key());
	        row.createCell(1).setCellValue(results.getRoutchan_key());
	        row.createCell(2).setCellValue(results.getProd_org_key());
	        row.createCell(3).setCellValue(results.getMailbox());
	        row.createCell(4).setCellValue(results.getCons_org_key());
	        row.createCell(5).setCellValue(results.getRoutchan_tmpl_name());
	        row.createCell(6).setCellValue(results.getActive());
	        Cell dateCell=row.createCell(7);
		    dateCell.setCellValue(results.getDate());
	        dateCell.setCellStyle(dateStyle);
	       
	        
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	}
		
	
	
	
	
	
	

}
