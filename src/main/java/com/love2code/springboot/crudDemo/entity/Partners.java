package com.love2code.springboot.crudDemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCI_CODE_USR_XREF")
public class Partners {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TP_OBJECT_ID")
	private int tp_object_id;
	
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="DATE_INVITED")
	private Date date_invited;

	public Partners() {
		
	}

	public Partners(int tp_object_id, String user_id, Date date_invited) {
		this.tp_object_id = tp_object_id;
		this.user_id = user_id;
		this.date_invited = date_invited;
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

	@Override
	public String toString() {
		return "Partners [tp_object_id=" + tp_object_id + ", user_id=" + user_id + ", date_invited=" + date_invited
				+ "]";
	}
	
	
	

}
