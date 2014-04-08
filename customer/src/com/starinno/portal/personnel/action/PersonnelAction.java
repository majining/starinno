package com.starinno.portal.personnel.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.starinno.portal.common.util.Page;
import com.starinno.portal.personnel.pojo.TbPersonnel;
import com.starinno.portal.personnel.service.PersonnelService;
import com.starinno.portal.quanxian.pojo.TbQx;

public class PersonnelAction {
	//请求参数
	private String gonghao;
	private String pwd;
	private String oldpwd;
	private String newpwd;
	private String newpwd1;
	private String custname;
	private String custphone;
	private String sex;
	private String age;
	private String qxid;
	//分页
	private int page=1;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getQxid() {
		return qxid;
	}
	public void setQxid(String qxid) {
		this.qxid = qxid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustphone() {
		return custphone;
	}
	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getNewpwd1() {
		return newpwd1;
	}
	public void setNewpwd1(String newpwd1) {
		this.newpwd1 = newpwd1;
	}
	public String getGonghao() {
		return gonghao;
	}
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//业务逻辑
	private PersonnelService ps;
	public PersonnelService getPs() {
		return ps;
	}
	public void setPs(PersonnelService ps) {
		this.ps = ps;
	}
	//valuestack
	private TbPersonnel tp;
	public TbPersonnel getTp() {
		return tp;
	}
	public void setTp(TbPersonnel tp) {
		this.tp = tp;
	}
	
	private List<TbPersonnel> listtp=new ArrayList<TbPersonnel>();
	public List<TbPersonnel> getListtp() {
		return listtp;
	}
	public void setListtp(List<TbPersonnel> listtp) {
		this.listtp = listtp;
	}
	
	//分页对象
	private Page mypage;
	public Page getMypage() {
		return mypage;
	}
	public void setMypage(Page mypage) {
		this.mypage = mypage;
	}

	//r 动态结果集
	private String r;
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	private InputStream excelStream;
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	/**
	 * 登陆
	 */
	public String login(){
		//System.out.println(gonghao);
		tp=ps.login(gonghao, pwd);
		if(tp!=null){
			ActionContext.getContext().getSession().put("user",tp);	
			return "succ";
		}else{
			ActionContext.getContext().getSession().put("login_info","登录失败!");			
		}
		return "fail";
	}
	/**
	 * 修改密码
	 */
	public String uppdatepwd(){
		TbPersonnel tp=(TbPersonnel)ActionContext.getContext().getSession().get("user");
		boolean flag=ps.uppdatepwd(tp, oldpwd, newpwd, newpwd1);
		//System.out.println(flag);
		String info="";
		if(flag){
			info="密码修改成功!";
		}else{
			info="密码修改失败!";
		}
		ActionContext.getContext().getSession().put("operate_info", info);
		return "succ";
	}
	/**
	 * 修改资料
	 */
	public String uppdateziliao(){
		TbPersonnel tp=(TbPersonnel)ActionContext.getContext().getSession().get("user");
		boolean flag=ps.uppdateinfo(tp, custname, custphone, sex, age);
		
		String info="";
		if(flag){
			info="资料修改成功!";
		}else{
			info="资料修改失败!";
		}
		ActionContext.getContext().getSession().put("operate_info", info);
		return "succ";
	}
	/**
	 * 查询列表
	 */
	public String findByAll(){
		//性能问题 暂时不考虑
		List<TbPersonnel> list= ps.findByAll();
		int maxpage=ps.findPageBySize(list.size());
		if(page>maxpage){
			page=1;
		}
		this.setListtp(ps.findByAll(page));
		//System.out.println(list.size());
//		this.setListtp(list);
		
		//封装分页对象
		Page mypage=new Page(list.size(), page, maxpage,"findperlist.action");
		this.setMypage(mypage);
		return "succ";
	}
	/**
	 *新增对象 
	 * 
	 */
	public String addpersonnel(){
		boolean flag= ps.addper(custname, pwd, custphone, sex, qxid, age);
		String info="";
		if(flag){
			info="新增成功!";
		}else{
			info="新增失败!";
		}
		ActionContext.getContext().getSession().put("operate_info", info);
		return "succ";
	}
	
	
	/**
	 * 修改业务员
	 */
	public String xgpersonnel(){
		boolean flag=ps.uppdateper(gonghao, pwd,custname, custphone, sex, qxid, age);
		this.setR(gonghao);
		String info="";
		if(flag){
			info="业务员信息修改成功!";
		}else{
			info="业务员信息修改失败!";
		}
		ActionContext.getContext().getSession().put("operate_info", info);
		return "succ";
	}
	/**
	 * 删除业务员
	 */
	public String deletepersonnel(){
		boolean flag=ps.deleteper(gonghao);
		String info="";
		if(flag){
			info="业务员信息删除成功!";
		}else{
			info="业务员信息删除失败!";
		}
		ActionContext.getContext().getSession().put("operate_info", info);
		return "succ";
	}
	/**
	 * 查看对象
	 */
	public String ckpersonnel(){
		this.setTp(ps.findObj(gonghao));
		//System.out.println(tp.getPersonnelSex());
		return "succ";
	}
	//根据权限获得用户结果集
	public String findPersonnelAllByQxid(){
		List<TbPersonnel> list=(List<TbPersonnel>)ps.findPerByQuanxian(qxid);
		//System.out.println(customername);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=gb2312");
		try {
			PrintStream out = new PrintStream(response.getOutputStream());
			out.println("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
			out.println("<personnels>");
			for (TbPersonnel tbPersonnel : list) {
				out.println("<personnel>");
				out.println("<perid>"+tbPersonnel.getPersonnelId()+"</perid>");
				out.println("<pername>"+tbPersonnel.getPersonnelName()+"</pername>");
				out.println("</personnel>");
			}
			out.println("</personnels>");
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
	public String importper(){
		this.setExcelStream(ps.impper());
		return "succ";
	}
}
