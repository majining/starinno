package com.starinno.portal.quanxian.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TbQx entity. @author MyEclipse Persistence Tools
 */

public class TbQx implements java.io.Serializable {

	// Fields

	private Integer qxId;
	private String qxName;
	private Set tbPersonnels = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbQx() {
	}

	/** minimal constructor */
	public TbQx(String qxName) {
		this.qxName = qxName;
	}

	/** full constructor */
	public TbQx(String qxName, Set tbPersonnels) {
		this.qxName = qxName;
		this.tbPersonnels = tbPersonnels;
	}

	// Property accessors

	public Integer getQxId() {
		return this.qxId;
	}

	public void setQxId(Integer qxId) {
		this.qxId = qxId;
	}

	public String getQxName() {
		return this.qxName;
	}

	public void setQxName(String qxName) {
		this.qxName = qxName;
	}

	public Set getTbPersonnels() {
		return this.tbPersonnels;
	}

	public void setTbPersonnels(Set tbPersonnels) {
		this.tbPersonnels = tbPersonnels;
	}

}