package com.starinno.portal.address.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TbShi entity. @author MyEclipse Persistence Tools
 */

public class TbShi implements java.io.Serializable {

	// Fields

	private Integer shiId;
	private TbSheng tbSheng;
	private String shiName;
	private Set tbQus = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbShi() {
	}

	/** minimal constructor */
	public TbShi(TbSheng tbSheng, String shiName) {
		this.tbSheng = tbSheng;
		this.shiName = shiName;
	}

	/** full constructor */
	public TbShi(TbSheng tbSheng, String shiName, Set tbQus) {
		this.tbSheng = tbSheng;
		this.shiName = shiName;
		this.tbQus = tbQus;
	}
	
	public TbShi(Integer shiId) {
		super();
		this.shiId = shiId;
	}

	// Property accessors

	public Integer getShiId() {
		return this.shiId;
	}

	public void setShiId(Integer shiId) {
		this.shiId = shiId;
	}

	public TbSheng getTbSheng() {
		return this.tbSheng;
	}

	public void setTbSheng(TbSheng tbSheng) {
		this.tbSheng = tbSheng;
	}

	public String getShiName() {
		return this.shiName;
	}

	public void setShiName(String shiName) {
		this.shiName = shiName;
	}

	public Set getTbQus() {
		return this.tbQus;
	}

	public void setTbQus(Set tbQus) {
		this.tbQus = tbQus;
	}

}