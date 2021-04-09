package com.love2code.springboot.crudDemo.entity;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import javax.persistence.UniqueConstraint;



@Entity
@Table(uniqueConstraints = {
@UniqueConstraint(columnNames = {"routchan_tmpl_key","routchan_key"})
})
public class Active implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@Column(name="ROUTCHAN_TMPL_KEY")
	private int routchan_tmpl_key;
	
	
	@Column(name="ROUTCHAN_KEY")
	private int routchan_key;
	
	@Column(name="PROD_ORG_KEY")
	private String prod_org_key;
	
	
	@Column(name="CONS_ORG_KEY")
	private String cons_org_key;
	
	@Column(name="ROUTCHAN_TMPL_NAME")
	private String routchan_tmpl_name;
	
	@Column(name="MAILBOX")
	private String mailbox;
	
	@Column(name="ACTIVE")
	private String active;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="PRODUCER_ID")
	private int producerId;
	
	@Column(name="CONSUMER_ID")
	private int consumerId;

	public Active() {
		
	}


	

	



	public int getProducerId() {
		return producerId;
	}








	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}








	public int getConsumerId() {
		return consumerId;
	}








	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}








	public String getMailbox() {
		return mailbox;
	}








	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}








	public int getRoutchan_tmpl_key() {
		return routchan_tmpl_key;
	}



	public void setRoutchan_tmpl_key(int routchan_tmpl_key) {
		this.routchan_tmpl_key = routchan_tmpl_key;
	}



	public int getRoutchan_key() {
		return routchan_key;
	}



	public void setRoutchan_key(int routchan_key) {
		this.routchan_key = routchan_key;
	}



	public String getProd_org_key() {
		return prod_org_key;
	}



	public void setProd_org_key(String prod_org_key) {
		this.prod_org_key = prod_org_key;
	}



	public String getCons_org_key() {
		return cons_org_key;
	}



	public void setCons_org_key(String cons_org_key) {
		this.cons_org_key = cons_org_key;
	}

	
	

	



	


	public String getRoutchan_tmpl_name() {
		return routchan_tmpl_name;
	}








	public void setRoutchan_tmpl_name(String routchan_tmpl_name) {
		this.routchan_tmpl_name = routchan_tmpl_name;
	}








	public String getActive() {
		return active;
	}








	public void setActive(String active) {
		this.active = active;
	}












	public Date getDate() {
		return date;
	}








	public void setDate(Date date) {
		this.date = date;
	}








	








	








	








	public Active(int routchan_tmpl_key, int routchan_key, String prod_org_key, String cons_org_key,
			String routchan_tmpl_name, String mailbox, String active, Date date, int producerId, int consumerId) {
		this.routchan_tmpl_key = routchan_tmpl_key;
		this.routchan_key = routchan_key;
		this.prod_org_key = prod_org_key;
		this.cons_org_key = cons_org_key;
		this.routchan_tmpl_name = routchan_tmpl_name;
		this.mailbox = mailbox;
		this.active = active;
		this.date = date;
		this.producerId = producerId;
		this.consumerId = consumerId;
	}








	@Override
	public String toString() {
		return "Active [id=" + id + ", routchan_tmpl_key=" + routchan_tmpl_key + ", routchan_key=" + routchan_key
				+ ", prod_org_key=" + prod_org_key + ", cons_org_key=" + cons_org_key + ", routchan_tmpl_name="
				+ routchan_tmpl_name + ", mailbox=" + mailbox + ", active=" + active + ", date=" + date
				+ ", producerId=" + producerId + ", consumerId=" + consumerId + "]";
	}








	








	








	


	

	
	
	

}
