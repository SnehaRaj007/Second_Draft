package com.love2code.springboot.crudDemo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FG_ARRIVEDFILE")
public class FgArrivedFile implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ARRIVEDFILE_KEY")
	private int id;
	
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="FILE_NAME")
	private String file_name;
	
	
	@Column(name="MAILBOX_PATH")
	private String mailbox_path;
	
	
	//@Temporal(value = TemporalType.TIME)
	@Column(name="CREATETS")
	private Date status;
	
	
	


	

	public FgArrivedFile() {
		
	}





	public FgArrivedFile(int id, String user_id, String file_name, String mailbox_path, Date status) {
		this.id = id;
		this.user_id = user_id;
		this.file_name = file_name;
		this.mailbox_path = mailbox_path;
		this.status = status;
	}




























	public int getId() {
		return id;
	}










	public void setId(int id) {
		this.id = id;
	}










	public String getUser_id() {
		return user_id;
	}










	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}










	public String getFile_name() {
		return file_name;
	}










	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}










	public String getMailbox_path() {
		return mailbox_path;
	}










	public void setMailbox_path(String mailbox_path) {
		this.mailbox_path = mailbox_path;
	}










	









	public Date getStatus() {
		return status;
	}










	public void setStatus(Date status) {
		this.status = status;
	}










	@Override
	public String toString() {
		return "FgArrivedFile [id=" + id + ", user_id=" + user_id + ", file_name=" + file_name + ", mailbox_path="
				+ mailbox_path + ", status=" + status + "]";
	}










	



	
	



	




	
	
	
	

}
