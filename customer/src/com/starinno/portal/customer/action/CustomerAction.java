package com.starinno.portal.customer.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.starinno.portal.address.pojo.TbSheng;
import com.starinno.portal.address.service.AddressService;
import com.starinno.portal.common.util.Page;
import com.starinno.portal.common.util.PageUtil;
import com.starinno.portal.customer.pojo.TbCustomerinfo;
import com.starinno.portal.customer.service.CustomerService;
import com.starinno.portal.customer.util.PageConditionCust;
import com.starinno.portal.personnel.pojo.TbPersonnel;


public class CustomerAction {
	//请求参数
	private String  custid;
	private String caozuoyuan="-1";
	private String customername="";
	private String suoshuhangye="";
	private String yixiangqingkuang="";
	private String txlname="";
	private String gphone="";
	private String mphone="";
	private String address="";
	private String zyyw="";
	private String shengid="-1";
	private String shiid="-1";
	private String quid="-1";
	private String[] delid;
	
	public String[] getDelid() {
		return delid;
	}
	public void setDelid(String[] delid) {
		this.delid = delid;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getCaozuoyuan() {
		return caozuoyuan;
	}
	public void setCaozuoyuan(String caozuoyuan) {
		this.caozuoyuan = caozuoyuan;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getSuoshuhangye() {
		return suoshuhangye;
	}
	public void setSuoshuhangye(String suoshuhangye) {
		this.suoshuhangye = suoshuhangye;
	}
	public String getYixiangqingkuang() {
		return yixiangqingkuang;
	}
	public void setYixiangqingkuang(String yixiangqingkuang) {
		this.yixiangqingkuang = yixiangqingkuang;
	}
	public String getTxlname() {
		return txlname;
	}
	public void setTxlname(String txlname) {
		this.txlname = txlname;
	}
	public String getGphone() {
		return gphone;
	}
	public void setGphone(String gphone) {
		this.gphone = gphone;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getZyyw() {
		return zyyw;
	}
	public void setZyyw(String zyyw) {
		this.zyyw = zyyw;
	}
	public String getShengid() {
		return shengid;
	}
	public void setShengid(String shengid) {
		this.shengid = shengid;
	}
	public String getShiid() {
		return shiid;
	}
	public void setShiid(String shiid) {
		this.shiid = shiid;
	}
	public String getQuid() {
		return quid;
	}
	public void setQuid(String quid) {
		this.quid = quid;
	}
	
	
	//动态结果集
	private String r="";
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}

	
	//页数
	private int page=1;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	//业务逻辑
	private CustomerService cs;
	public CustomerService getCs() {
		return cs;
	}
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	
	
	private AddressService as;
	public AddressService getAs() {
		return as;
	}
	public void setAs(AddressService as) {
		this.as = as;
	}

	//valuestack   客户信息list 结果集
	private List<TbCustomerinfo> list=new ArrayList<TbCustomerinfo>();
	public List<TbCustomerinfo> getList() {
		return list;
	}
	public void setList(List<TbCustomerinfo> list) {
		this.list = list;
	}
	//省结果集
	private List<TbSheng> shenglist=new ArrayList<TbSheng>();
	public List<TbSheng> getShenglist() {
		return shenglist;
	}
	public void setShenglist(List<TbSheng> shenglist) {
		this.shenglist = shenglist;
	}
	//客户信息对象
	private TbCustomerinfo tc=new TbCustomerinfo();
	public TbCustomerinfo getTc() {
		return tc;
	}
	public void setTc(TbCustomerinfo tc) {
		this.tc = tc;
	}
	//分页对象
	private Page pageobj;
	public Page getPageobj() {
		return pageobj;
	}
	public void setPageobj(Page pageobj) {
		this.pageobj = pageobj;
	}
	
	private InputStream excelStream;
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	/**
	 * 条件查询
	 * @return
	 */
	public String findByCondition(){
		
		//分页
		int maxcount=cs.findByConditionCount(caozuoyuan, customername, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid);
		int maxpage=cs.findMaxPage(maxcount);
		if(page>maxpage){
			page=1;
		}
		Page mypage=new PageConditionCust(maxcount, page,maxpage,"findByCondition.action", caozuoyuan, customername, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid);
		this.setPageobj(mypage);
		//获得查询结果
		list=cs.findByCondition(caozuoyuan, customername, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid, page);
		//省加载
		this.setShenglist(as.findBySheng());
		return "succ";
	}
	//全部查询
	public String findByAll(){
		//分页
		TbPersonnel tp1=(TbPersonnel)ActionContext.getContext().getSession().get("user");
		
		if(tp1.getTbQx().getQxName().equals("普通人员")){
			this.setCaozuoyuan(tp1.getPersonnelId());
		}
		int maxcount=cs.findByConditionCount(caozuoyuan, customername, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid);
		int maxpage=cs.findMaxPage(maxcount);
		if(page>maxpage){
			page=1;
		}
		//分页封装
	
		Page mypage=new Page(maxcount,page,maxpage,"findlist.action");
		this.setPageobj(mypage);		
		//查询全部数据
		list=cs.findByCondition(caozuoyuan, customername, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid, page);
		//顺便获得省
		this.setShenglist(as.findBySheng());
		//清空sessionid custid
		ActionContext.getContext().getSession().remove("custid");
		return "succ";
	}
	/**
	 * 初始化新增
	 * 加载省
	 */
	public String initcreate(){
		this.setShenglist(as.findBySheng());
		return "succ";
	}
	/**
	 * 保存
	 */
	public String savecust(){
		TbPersonnel tp=(TbPersonnel)ActionContext.getContext().getSession().get("user");
		boolean flag=cs.addCust(tp, quid, customername,suoshuhangye , yixiangqingkuang, txlname, gphone, mphone, address,zyyw);
		 
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "添加客户信息成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "添加客户信息失败!");
		}
		return "succ";
	}
	/**
	 * 删除
	 */
	public String deletecust(){
		boolean flag=cs.deleteCust(delid);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "删除客户信息成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "删除客户信息失败!");
		}
		return "succ";
	}
	/**
	 * 获得对象
	 */
	public String getcust(){
		this.setTc(cs.findByObj(custid));
		return "succ";
		
	}
	/**
	 * 修改信息
	 */
	public String uppdatecust(){
		boolean flag=cs.uppdatecust(custid, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, quid);
		this.setR(custid);
		//System.out.println(flag);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "修改客户信息成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "修改客户信息失败!");
		}
		return "succ";
	}
	/**
	 * 验证客户存在
	 */
	public String iscunzai(){
		try {
			customername=new String(customername.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str=cs.isCunzai(customername);
		//System.out.println(customername);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=gb2312");
		try {
			PrintStream out = new PrintStream(response.getOutputStream());
			out.println(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 导出数据
	 */
	public String importcust(){
		
		try {
			caozuoyuan=new String(caozuoyuan.getBytes("iso-8859-1"),"utf-8");
			customername=new String(customername.getBytes("iso-8859-1"),"utf-8");
			suoshuhangye=new String(suoshuhangye.getBytes("iso-8859-1"),"utf-8");
			yixiangqingkuang=new String(yixiangqingkuang.getBytes("iso-8859-1"),"utf-8");
			txlname=new String(txlname.getBytes("iso-8859-1"),"utf-8");
			address=new String(address.getBytes("iso-8859-1"),"utf-8");
			zyyw=new String(zyyw.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.setExcelStream(cs.impcust(caozuoyuan, customername, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid));
		//System.out.println(this.getExcelStream());
		return "succ";
	}
	
}
