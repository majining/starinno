package com.starinno.portal.address.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TbSheng entity. @author MyEclipse Persistence Tools
 */

public class TbSheng implements java.io.Serializable {

	// Fields

	private Integer shengId;
	private String shengName;
	private Set tbShis = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbSheng() {
	}

	/** minimal constructor */
	public TbSheng(String shengName) {
		this.shengName = shengName;
	}

	/** full constructor */
	public TbSheng(String shengName, Set tbShis) {
		this.shengName = shengName;
		this.tbShis = tbShis;
	}

	// Property accessors

	public TbSheng(Integer shengId) {
		super();
		this.shengId = shengId;
	}

	public Integer getShengId() {
		return this.shengId;
	}

	public void setShengId(Integer shengId) {
		this.shengId = shengId;
	}

	public String getShengName() {
		return this.shengName;
	}

	public void setShengName(String shengName) {
		this.shengName = shengName;
	}

	public Set getTbShis() {
		return this.tbShis;
	}

	public void setTbShis(Set tbShis) {
		this.tbShis = tbShis;
	}

}