package com.starinno.portal.customer.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.starinno.portal.address.pojo.TbQu;
import com.starinno.portal.personnel.pojo.TbPersonnel;

/**
 * TbCustomerinfo entity. @author MyEclipse Persistence Tools
 */

public class TbCustomerinfo implements java.io.Serializable {

	// Fields

	private Integer customerId;
	private TbPersonnel tbPersonnel;
	private TbQu tbQu;
	private String customerKhname;
	private String customerSshy;
	private String customerYxqk;
	private String customerLxr;
	private String customerGphone;
	private BigDecimal customerMphone;
	private String customerAddress;
	private String customerZyyw;
	private Date customercreatetime;

	private Set tbCustomertxls = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbCustomerinfo() {
	}

	/** full constructor */
	public TbCustomerinfo(TbPersonnel tbPersonnel, TbQu tbQu,
			String customerKhname, String customerSshy, String customerYxqk,
			String customerLxr, String customerGphone,
			BigDecimal customerMphone, String customerAddress,
			String customerZyyw, Set tbCustomertxls,Date customercreatetime) {
		this.tbPersonnel = tbPersonnel;
		this.tbQu = tbQu;
		this.customerKhname = customerKhname;
		this.customerSshy = customerSshy;
		this.customerYxqk = customerYxqk;
		this.customerLxr = customerLxr;
		this.customerGphone = customerGphone;
		this.customerMphone = customerMphone;
		this.customerAddress = customerAddress;
		this.customerZyyw = customerZyyw;
		this.tbCustomertxls = tbCustomertxls;
		this.customercreatetime=customercreatetime;
	}
	public TbCustomerinfo(TbPersonnel tbPersonnel, TbQu tbQu,
			String customerKhname, String customerSshy, String customerYxqk,
			String customerLxr, String customerGphone,
			BigDecimal customerMphone, String customerAddress,
			String customerZyyw,Date customercreatetime) {
		this.tbPersonnel = tbPersonnel;
		this.tbQu = tbQu;
		this.customerKhname = customerKhname;
		this.customerSshy = customerSshy;
		this.customerYxqk = customerYxqk;
		this.customerLxr = customerLxr;
		this.customerGphone = customerGphone;
		this.customerMphone = customerMphone;
		this.customerAddress = customerAddress;
		this.customerZyyw = customerZyyw;
		this.customercreatetime=customercreatetime;
	}
	
	public TbCustomerinfo(Integer customerId) {
		super();
		this.customerId = customerId;
	}

	// Property accessors
	public Date getCustomercreatetime() {
		return customercreatetime;
	}
	
	public void setCustomercreatetime(Date customercreatetime) {
		this.customercreatetime = customercreatetime;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public TbPersonnel getTbPersonnel() {
		return this.tbPersonnel;
	}

	public void setTbPersonnel(TbPersonnel tbPersonnel) {
		this.tbPersonnel = tbPersonnel;
	}

	public TbQu getTbQu() {
		return this.tbQu;
	}

	public void setTbQu(TbQu tbQu) {
		this.tbQu = tbQu;
	}

	public String getCustomerKhname() {
		return this.customerKhname;
	}

	public void setCustomerKhname(String customerKhname) {
		this.customerKhname = customerKhname;
	}

	public String getCustomerSshy() {
		return this.customerSshy;
	}

	public void setCustomerSshy(String customerSshy) {
		this.customerSshy = customerSshy;
	}

	public String getCustomerYxqk() {
		return this.customerYxqk;
	}

	public void setCustomerYxqk(String customerYxqk) {
		this.customerYxqk = customerYxqk;
	}

	public String getCustomerLxr() {
		return this.customerLxr;
	}

	public void setCustomerLxr(String customerLxr) {
		this.customerLxr = customerLxr;
	}

	public String getCustomerGphone() {
		return this.customerGphone;
	}

	public void setCustomerGphone(String customerGphone) {
		this.customerGphone = customerGphone;
	}

	public BigDecimal getCustomerMphone() {
		return this.customerMphone;
	}

	public void setCustomerMphone(BigDecimal customerMphone) {
		this.customerMphone = customerMphone;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerZyyw() {
		return this.customerZyyw;
	}

	public void setCustomerZyyw(String customerZyyw) {
		this.customerZyyw = customerZyyw;
	}

	public Set getTbCustomertxls() {
		return this.tbCustomertxls;
	}

	public void setTbCustomertxls(Set tbCustomertxls) {
		this.tbCustomertxls = tbCustomertxls;
	}

}