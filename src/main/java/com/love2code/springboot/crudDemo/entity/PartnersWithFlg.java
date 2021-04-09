package com.love2code.springboot.crudDemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Partners_FLG")
public class PartnersWithFlg {
	
	
	@Id
	
	@Column(name="TP_OBJECT_ID")
	private int tp_object_id;
	
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="DATE_INVITED")
	private Date date_invited;
	
	@Column(name="STATUS")
	private String Status;

	public PartnersWithFlg() {
		
	}
	
	

	public PartnersWithFlg(int tp_object_id, String user_id, Date date_invited, String status) {
		this.tp_object_id = tp_object_id;
		this.user_id = user_id;
		this.date_invited = date_invited;
		Status = status;
	}



	public int getTp_object_id() {
		return tp_object_id;
	}

	public void setTp_object_id(int tp_object_id) {
		this.tp_object_id = tp_object_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getDate_invited() {
		return date_invited;
	}

	public void setDate_invited(Date date_invited) {
		this.date_invited = date_invited;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "PartnersWithFlg [tp_object_id=" + tp_object_id + ", user_id=" + user_id + ", date_invited="
				+ date_invited + ", Status=" + Status + "]";
	}
	
	
	
	

}
