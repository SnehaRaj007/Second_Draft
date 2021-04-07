package com.love2code.springboot.crudDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="fg_routchan")
public class Fg_Routchan implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROUTCHAN_TMPL_KEY")
	private int routchan_tmpl_key;
	
	@Column(name="ROUTCHAN_KEY")
	private int routchan_key;
	
	@Column(name="MAILBOX_NAME")
	private String mailbox;
	
	@Column(name="PROD_ORG_KEY")
	private String prod_org_key;
	
	
	@Column(name="CONS_ORG_KEY")
	private String cons_org_key;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROUTCHAN_TMPL_KEY", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Fg_Routchan_Template fg_Routchan_Template;

	public Fg_Routchan() {
		
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

	
	

	



	public Fg_Routchan_Template getFg_Routchan_Template() {
		return fg_Routchan_Template;
	}



	public void setFg_Routchan_Template(Fg_Routchan_Template fg_Routchan_Template) {
		this.fg_Routchan_Template = fg_Routchan_Template;
	}



	



	public String getMailbox() {
		return mailbox;
	}



	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}



	public Fg_Routchan(int routchan_tmpl_key, int routchan_key, String mailbox, String prod_org_key, String cons_org_key,
			Fg_Routchan_Template fg_Routchan_Template) {
		this.routchan_tmpl_key = routchan_tmpl_key;
		this.routchan_key = routchan_key;
		this.mailbox = mailbox;
		this.prod_org_key = prod_org_key;
		this.cons_org_key = cons_org_key;
		this.fg_Routchan_Template = fg_Routchan_Template;
	}



	@Override
	public String toString() {
		return "Fg_Routchan [routchan_tmpl_key=" + routchan_tmpl_key + ", routchan_key=" + routchan_key
				+ ", prod_org_key=" + prod_org_key + ", cons_org_key=" + cons_org_key + "]";
	}


	

	
	
	

}
