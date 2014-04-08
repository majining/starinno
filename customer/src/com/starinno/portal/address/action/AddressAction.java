package com.starinno.portal.address.action;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.starinno.portal.address.pojo.TbQu;
import com.starinno.portal.address.pojo.TbSheng;
import com.starinno.portal.address.pojo.TbShi;
import com.starinno.portal.address.service.AddressService;

public class AddressAction {
	//请求参数
	private String shengid;
	private String shiid;
	private String quid;
	
	private String shengname;
	private String shiname;
	private String quname;
	
	
	
	public String getQuid() {
		return quid;
	}
	public void setQuid(String quid) {
		this.quid = quid;
	}
	public String getQuname() {
		return quname;
	}
	public void setQuname(String quname) {
		this.quname = quname;
	}
	public String getShiname() {
		return shiname;
	}
	public void setShiname(String shiname) {
		this.shiname = shiname;
	}
	public String getShengname() {
		return shengname;
	}
	public void setShengname(String shengname) {
		this.shengname = shengname;
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
	
	//业务逻辑
	public AddressService as;
	public AddressService getAs() {
		return as;
	}
	public void setAs(AddressService as) {
		this.as = as;
	}
	
	//结果集
	private List<TbShi> shilist;
	private List<TbQu> qulist;
	private List<TbSheng> shenglist;
	
	public List<TbSheng> getShenglist() {
		return shenglist;
	}
	public void setShenglist(List<TbSheng> shenglist) {
		this.shenglist = shenglist;
	}
	public List<TbShi> getShilist() {
		return shilist;
	}
	public void setShilist(List<TbShi> shilist) {
		this.shilist = shilist;
	}
	public List<TbQu> getQulist() {
		return qulist;
	}
	public void setQulist(List<TbQu> qulist) {
		this.qulist = qulist;
	}
	
	/**
	 * 加载市
	 * @return
	 */

	public String loadshi(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=gb2312");
		response.setCharacterEncoding("gb2312");
		PrintStream out;
		try {
			shilist=as.findShiByShengid(shengid);
		
			//System.out.println(shilist);
			out = new PrintStream(response.getOutputStream());
			/**
			 * 拼接xml
			 */
			out.println("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
			out.println("<shis>");
			out.println("<shi>");
			out.println("<sid>-1</sid>");
			out.println("<sname>请选择</sname>");
			out.println("</shi>");
		
			for (TbShi shi : shilist) {
				//System.out.println(data.size());
				out.println("<shi>");
				out.println("<sid>"+ shi.getShiId() +"</sid>");
				out.println("<sname>"+ shi.getShiName() +"</sname>");
				out.println("</shi>");
			}
			out.println("</shis>");
			out.close();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 加载市
	 */
	public String loadqu(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=gb2312");
		response.setCharacterEncoding("gb2312");
		PrintStream out;
		try {
			qulist=as.findQuByShiid(shiid);
			//System.out.println(shilist);
			out = new PrintStream(response.getOutputStream());
			/**
			 * 拼接xml
			 */
		if(!shiid.equals("-1")){
			out.println("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
			out.println("<qus>");
			out.println("<qu>");
			out.println("<qid>-1</qid>");
			out.println("<qname>请选择</qname>");
			out.println("</qu>");
			for (TbQu qu : qulist) {
				out.println("<qu>");
				out.println("<qid>"+ qu.getQuId() +"</qid>");
				out.println("<qname>"+ qu.getQuName() +"</qname>");
				out.println("</qu>");
			}
			out.println("</qus>");
		}else{
			out.println("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
			out.println("<qus>");
		    out.println("<qu>");
			out.println("<qid>-1</qid>");
			out.println("<qname>请选择</qname>");
			out.println("</qu>");
			out.println("</qus>");			
			
		}	

			out.close();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//新增省
	public String addsheng(){
		boolean flag=as.addsheng(shengname);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "新增成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "新增失败!");
		}
		this.setShenglist(as.findBySheng());
		return "succ";
	}
	//删除生
	public String dropsheng(){
		boolean flag=as.dropsheng(shengid);
		//System.out.println(flag);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "删除成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "删除失败!");
		}
		return "succ";
	}
	//新增市
	public String addshi(){
		boolean flag=as.addshi(shengid, shiname);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "新增成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "新增失败!");
		}
		this.setShilist(as.findShiByShengid(shengid));
		return "succ";
	}
	//删除市
	public String dropshi(){
		boolean flag=as.dropshi(shiid);
		if(flag){
			ActionContext.getContext().getSession().put("operate_info", "删除成功!");
		}else{
			ActionContext.getContext().getSession().put("operate_info", "删除失败!");
		}
		return "succ";
	}
	//新增区
	public String addqu(){
			boolean flag=as.addqu(shiid, quname);
			if(flag){
				ActionContext.getContext().getSession().put("operate_info", "新增成功!");
			}else{
				ActionContext.getContext().getSession().put("operate_info", "新增失败!");
			}
			this.setQulist(as.findQuByShiid(shiid));
			return "succ";
		}
	//删除区
	public String dropqu(){
			boolean flag=as.dropqu(quid);
			if(flag){
				ActionContext.getContext().getSession().put("operate_info", "删除成功!");
			}else{
				ActionContext.getContext().getSession().put("operate_info", "删除失败!");
			}
			return "succ";
	}
	//查询全部省
	public String cksheng(){
		this.setShenglist(as.findBySheng());
		return "succ";
	}
	//根据省查询市
	public String ckshibyshengid(){
		this.setShilist(as.findShiByShengid(shengid));
		return "succ";
	}
	//根据市查询区
	public String ckqubyshiid(){
		this.setQulist(as.findQuByShiid(shiid));
		return "succ";
	}
	
}
