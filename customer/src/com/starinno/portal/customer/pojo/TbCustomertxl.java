package com.starinno.portal.customer.pojo;

import java.util.Date;

/**
 * TbCustomertxl entity. @author MyEclipse Persistence Tools
 */

public class TbCustomertxl implements java.io.Serializable {

	// Fields

	private Integer customertxlId;
	private TbCustomerinfo tbCustomerinfo;
	private Date customertxlLxtime;
	private String customertxlLxcontent;

	// Constructors

	/** default constructor */
	public TbCustomertxl() {
	}

	/** full constructor */
	public TbCustomertxl(TbCustomerinfo tbCustomerinfo, Date customertxlLxtime,
			String customertxlLxcontent) {
		this.tbCustomerinfo = tbCustomerinfo;
		this.customertxlLxtime = customertxlLxtime;
		this.customertxlLxcontent = customertxlLxcontent;
	}
	
	public TbCustomertxl(Integer customertxlId) {
		super();
		this.customertxlId = customertxlId;
	}

	// Property accessors

	public Integer getCustomertxlId() {
		return this.customertxlId;
	}

	public void setCustomertxlId(Integer customertxlId) {
		this.customertxlId = customertxlId;
	}

	public TbCustomerinfo getTbCustomerinfo() {
		return this.tbCustomerinfo;
	}

	public void setTbCustomerinfo(TbCustomerinfo tbCustomerinfo) {
		this.tbCustomerinfo = tbCustomerinfo;
	}

	public Date getCustomertxlLxtime() {
		return this.customertxlLxtime;
	}

	public void setCustomertxlLxtime(Date customertxlLxtime) {
		this.customertxlLxtime = customertxlLxtime;
	}

	public String getCustomertxlLxcontent() {
		return this.customertxlLxcontent;
	}

	public void setCustomertxlLxcontent(String customertxlLxcontent) {
		this.customertxlLxcontent = customertxlLxcontent;
	}

}