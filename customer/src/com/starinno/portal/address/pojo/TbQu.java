package com.starinno.portal.address.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TbQu entity. @author MyEclipse Persistence Tools
 */

public class TbQu implements java.io.Serializable {

	// Fields

	private Integer quId;
	private TbShi tbShi;
	private String quName;
	private Set tbCustomerinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbQu() {
	}

	/** minimal constructor */
	public TbQu(TbShi tbShi, String quName) {
		this.tbShi = tbShi;
		this.quName = quName;
	}

	/** full constructor */
	public TbQu(TbShi tbShi, String quName, Set tbCustomerinfos) {
		this.tbShi = tbShi;
		this.quName = quName;
		this.tbCustomerinfos = tbCustomerinfos;
	}

	// Property accessors

	public TbQu(Integer quId) {
		super();
		this.quId = quId;
	}

	public Integer getQuId() {
		return this.quId;
	}

	public void setQuId(Integer quId) {
		this.quId = quId;
	}

	public TbShi getTbShi() {
		return this.tbShi;
	}

	public void setTbShi(TbShi tbShi) {
		this.tbShi = tbShi;
	}

	public String getQuName() {
		return this.quName;
	}

	public void setQuName(String quName) {
		this.quName = quName;
	}

	public Set getTbCustomerinfos() {
		return this.tbCustomerinfos;
	}

	public void setTbCustomerinfos(Set tbCustomerinfos) {
		this.tbCustomerinfos = tbCustomerinfos;
	}

}