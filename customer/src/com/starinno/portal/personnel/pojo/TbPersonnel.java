package com.starinno.portal.personnel.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.starinno.portal.quanxian.pojo.TbQx;

/**
 * TbPersonnel entity. @author MyEclipse Persistence Tools
 */

public class TbPersonnel implements java.io.Serializable {

	// Fields

	private String personnelId;
	private TbQx tbQx;
	private String personnelPwd;
	private String personnelName;
	private BigDecimal personnelPhone;
	private String personnelSex;
	private Date personnelCreatetime;
	private Integer personnelAge;
	private Set tbCustomerinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbPersonnel() {
	}

	/** minimal constructor */
	public TbPersonnel(String personnelPwd) {
		this.personnelPwd = personnelPwd;
	}

	/** full constructor */
	public TbPersonnel(TbQx tbQx, String personnelPwd, String personnelName,
			BigDecimal personnelPhone, String personnelSex,
			Date personnelCreatetime, Integer personnelAge, Set tbCustomerinfos) {
		this.tbQx = tbQx;
		this.personnelPwd = personnelPwd;
		this.personnelName = personnelName;
		this.personnelPhone = personnelPhone;
		this.personnelSex = personnelSex;
		this.personnelCreatetime = personnelCreatetime;
		this.personnelAge = personnelAge;
		this.tbCustomerinfos = tbCustomerinfos;
	}
	public TbPersonnel(TbQx tbQx, String personnelPwd, String personnelName,
			BigDecimal personnelPhone, String personnelSex,
			 Integer personnelAge,Date personnelCreatetime) {
		this.tbQx = tbQx;
		this.personnelPwd = personnelPwd;
		this.personnelName = personnelName;
		this.personnelPhone = personnelPhone;
		this.personnelSex = personnelSex;
		this.personnelCreatetime = personnelCreatetime;
		this.personnelAge = personnelAge;
	
	}
	// Property accessors

	public String getPersonnelId() {
		return this.personnelId;
	}

	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}

	public TbQx getTbQx() {
		return this.tbQx;
	}

	public void setTbQx(TbQx tbQx) {
		this.tbQx = tbQx;
	}

	public String getPersonnelPwd() {
		return this.personnelPwd;
	}

	public void setPersonnelPwd(String personnelPwd) {
		this.personnelPwd = personnelPwd;
	}

	public String getPersonnelName() {
		return this.personnelName;
	}

	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}

	public BigDecimal getPersonnelPhone() {
		return this.personnelPhone;
	}

	public void setPersonnelPhone(BigDecimal personnelPhone) {
		this.personnelPhone = personnelPhone;
	}

	public String getPersonnelSex() {
		return this.personnelSex;
	}

	public void setPersonnelSex(String personnelSex) {
		this.personnelSex = personnelSex;
	}

	public Date getPersonnelCreatetime() {
		return this.personnelCreatetime;
	}

	public void setPersonnelCreatetime(Date personnelCreatetime) {
		this.personnelCreatetime = personnelCreatetime;
	}

	public Integer getPersonnelAge() {
		return this.personnelAge;
	}

	public void setPersonnelAge(Integer personnelAge) {
		this.personnelAge = personnelAge;
	}

	public Set getTbCustomerinfos() {
		return this.tbCustomerinfos;
	}

	public void setTbCustomerinfos(Set tbCustomerinfos) {
		this.tbCustomerinfos = tbCustomerinfos;
	}

}