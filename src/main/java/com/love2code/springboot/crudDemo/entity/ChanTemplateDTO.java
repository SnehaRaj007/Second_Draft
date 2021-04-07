package com.love2code.springboot.crudDemo.entity;

public class ChanTemplateDTO implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int routchan_tmpl_key;
	private String tmpl_name;
	private String pv_mbx_pattern;
	private String consid_type;
	private int routchan_key;
	private String mailbox;
	
	public ChanTemplateDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	



	public ChanTemplateDTO(int routchan_tmpl_key, String tmpl_name, String pv_mbx_pattern, String consid_type,
			int routchan_key, String mailbox) {
		this.routchan_tmpl_key = routchan_tmpl_key;
		this.tmpl_name = tmpl_name;
		this.pv_mbx_pattern = pv_mbx_pattern;
		this.consid_type = consid_type;
		this.routchan_key = routchan_key;
		this.mailbox = mailbox;
	}







	
	@Override
	public String toString() {
		return "ChanTemplateDTO [routchan_tmpl_key=" + routchan_tmpl_key + ", tmpl_name=" + tmpl_name
				+ ", pv_mbx_pattern=" + pv_mbx_pattern + ", consid_type=" + consid_type + ", routchan_key="
				+ routchan_key + ", mailbox=" + mailbox + "]";
	}







	public int getRoutchan_tmpl_key() {
		return routchan_tmpl_key;
	}
	public void setRoutchan_tmpl_key(int routchan_tmpl_key) {
		this.routchan_tmpl_key = routchan_tmpl_key;
	}
	public String getTmpl_name() {
		return tmpl_name;
	}
	public void setTmpl_name(String tmpl_name) {
		this.tmpl_name = tmpl_name;
	}
	public String getPv_mbx_pattern() {
		return pv_mbx_pattern;
	}
	public void setPv_mbx_pattern(String pv_mbx_pattern) {
		this.pv_mbx_pattern = pv_mbx_pattern;
	}
	public String getConsid_type() {
		return consid_type;
	}
	public void setConsid_type(String consid_type) {
		this.consid_type = consid_type;
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



	
	
	
	
	

}
