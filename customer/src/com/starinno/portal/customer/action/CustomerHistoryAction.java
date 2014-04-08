package com.starinno.portal.customer.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.starinno.portal.common.util.Page;
import com.starinno.portal.customer.pojo.TbCustomertxl;
import com.starinno.portal.customer.service.CustomerHistoryService;
import com.starinno.portal.personnel.pojo.TbPersonnel;

public class CustomerHistoryAction {
	//客户id
	private String custid;
	//联系记录id
	private String lxid; 
	//page
	private int page=1;
	
	private String date;
	private String lxcontent;
	private String[] delid;
	
	
	public String[] getDelid() {
		return delid;
	}
	public void setDelid(String[] delid) {
		this.delid = delid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLxcontent() {
		return lxcontent;
	}
	public void setLxcontent(String lxcontent) {
		this.lxcontent = lxcontent;
	}
	public String getLxid() {
		return lxid;
	}
	public void setLxid(String lxid) {
		this.lxid = lxid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	//业务逻辑
	private CustomerHistoryService chs;
	public CustomerHistoryService getChs() {
		return chs;
	}
	public void setChs(CustomerHistoryService chs) {
		this.chs = chs;
	}
	//结果集
	private List<TbCustomertxl> list=new ArrayList<TbCustomertxl>();
	public List<TbCustomertxl> getList() {
		return list;
	}
	public void setList(List<TbCustomertxl> list) {
		this.list = list;
	}
	//对象
	private TbCustomertxl tct;
	public TbCustomertxl getTct() {
		return tct;
	}
	public void setTct(TbCustomertxl tct) {
		this.tct = tct;
	}
	private Page mypage;
	public Page getMypage() {
		return mypage;
	}
	public void setMypage(Page mypage) {
		this.mypage = mypage;
	}
	//动态结果集
	private String R;
	public String getR() {
		return R;
	}
	public void setR(String r) {
		R = r;
	}
	private InputStream excelStream;
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	//根据id查询联系记录
	public String findById(){
		//如果上次有记录就取出查询
		Map map=ActionContext.getContext().getSession();
		if(map.get("custid")!=null){
			this.setCustid((String)map.get("custid"));
		}
		//分页
		int maxcount=chs.findByCustIdCount(new String[]{custid});
		int maxpage=chs.findMaxPage(maxcount);
		if(page>maxpage){
			page=1;
		}
		this.setMypage(new Page(maxcount,page,maxpage,"findtxlBycustId.action"));
		this.setList(chs.findByCustId(new String[]{custid},page));
		//然后重新封装
		map.put("custid", custid);
		return "succ";
	}
//	/**
//	 * 保存
//	 */
	public String savetxl(){
		boolean flag=chs.save((String)ActionContext.getContext().getSession().get("custid") ,date,lxcontent);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "添加联系人成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "添加联系人失败!");
		}
		return "succ";
	}
	/**
	 * 删除
	 */
	public String deletetxl(){
		boolean flag=chs.delete(delid);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "删除指定联系人成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "删除指定联系人失败!");
		}
		return "succ";
	}
	/**
	 * 获得对象
	 */
	public String gettxl(){
		this.setTct(chs.get(lxid));
		return "succ";
		
	}
	/**
	 * 修改信息
	 */
	public String uppdatetxl(){
		boolean flag=chs.update(lxid, date, lxcontent);
		this.setR(lxid);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "修改客户信息成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "修改客户信息失败!");
		}
		return "succ";
	}
	/**
	 * 导出数据
	 */
	public String importhistory(){
		//System.out.println((String)ActionContext.getContext().getSession().get("custid"));
		this.setExcelStream(chs.imphistory((String)ActionContext.getContext().getSession().get("custid")));
		return "succ";
	}
}
