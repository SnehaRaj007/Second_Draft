package com.love2code.springboot.crudDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Channels_And_Templates_FLG")
public class ChannelsAndTemplatesWithFlg {
	
	
	
	@Column(name="ROUTCHAN_TMPL_KEY")
	private int routchan_tmpl_key;
	
	@Id
	@Column(name="ROUTCHAN_KEY")
	private int routchan_key;
	
	@Column(name="MAILBOX_NAME")
	private String mailbox;
	
	@Column(name="PROD_ORG_KEY")
	private String prod_org_key;
	
	
	@Column(name="CONS_ORG_KEY")
	private String cons_org_key;
	
	@Column(name="TMPL_NAME")
	private String tmpl_name;
	
	@Column(name="STATUS")
	private String status;

	public ChannelsAndTemplatesWithFlg() {
		
	}

	public ChannelsAndTemplatesWithFlg(int routchan_tmpl_key, int routchan_key, String mailbox, String prod_org_key,
			String cons_org_key, String tmpl_name,String status) {
		this.routchan_tmpl_key = routchan_tmpl_key;
		this.routchan_key = routchan_key;
		this.mailbox = mailbox;
		this.prod_org_key = prod_org_key;
		this.cons_org_key = cons_org_key;
		this.tmpl_name = tmpl_name;
		this.status=status;
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

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
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

	public String getTmpl_name() {
		return tmpl_name;
	}

	public void setTmpl_name(String tmpl_name) {
		this.tmpl_name = tmpl_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ChannelsAndTemplatesWithFlg [routchan_tmpl_key=" + routchan_tmpl_key + ", routchan_key=" + routchan_key
				+ ", mailbox=" + mailbox + ", prod_org_key=" + prod_org_key + ", cons_org_key=" + cons_org_key
				+ ", tmpl_name=" + tmpl_name + ", status=" + status + "]";
	}
	
	
	
	

}
