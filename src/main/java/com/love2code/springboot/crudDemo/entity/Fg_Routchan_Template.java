package com.love2code.springboot.crudDemo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fg_routchan_tmpl")
public class Fg_Routchan_Template implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROUTCHAN_TMPL_KEY")
	private int routchan_tmpl_key;
	
	@Column(name="TMPL_NAME")
	private String tmpl_name;
	
	@Column(name="PV_MBX_PATTERN")
	private String pv_mbx_pattern;
	
	
	@Column(name="CONSID_TYPE")
	private String consid_type;
	
	@OneToMany(targetEntity = Fg_Routchan.class,fetch = FetchType.LAZY)
	@JoinColumn(name="ROUTCHAN_TMPL_KEY",referencedColumnName = "routchan_tmpl_key")
	private List<Fg_Routchan> fg_Routchan; 


	public Fg_Routchan_Template() {
		// TODO Auto-generated constructor stub
	}


	public Fg_Routchan_Template(int routchan_tmpl_key, String tmpl_name, String pv_mbx_pattern, String consid_type) {
		this.routchan_tmpl_key = routchan_tmpl_key;
		this.tmpl_name = tmpl_name;
		this.pv_mbx_pattern = pv_mbx_pattern;
		this.consid_type = consid_type;
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

}
