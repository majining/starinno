package com.starinno.portal.customer.util;

import com.starinno.portal.common.util.Page;

/**
 * 查询条件类
 * @author lmstill
 *
 */
public class PageConditionCust extends Page {
	private String caozuoyuanid="";
	private String kehuname="";
	private String suoshuhangye="";
	private String yixiangqingkuang="";
	private String lxr="";
	private String gphone="";
	private String yphone="";
	private String address="";
	private String zzyw="";
	private String shengid="-1";
	private String shiid="-1";
	private String quid="-1";
	public String getCaozuoyuanid() {
		return caozuoyuanid;
	}
	public void setCaozuoyuanid(String caozuoyuanid) {
		this.caozuoyuanid = caozuoyuanid;
	}
	public String getKehuname() {
		return kehuname;
	}
	public void setKehuname(String kehuname) {
		this.kehuname = kehuname;
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
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getGphone() {
		return gphone;
	}
	public void setGphone(String gphone) {
		this.gphone = gphone;
	}
	public String getYphone() {
		return yphone;
	}
	public void setYphone(String yphone) {
		this.yphone = yphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZzyw() {
		return zzyw;
	}
	public void setZzyw(String zzyw) {
		this.zzyw = zzyw;
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
	public PageConditionCust(int maxCount, int currentpage, int maxpage,String cxpage,
			String caozuoyuanid, String kehuname, String suoshuhangye,
			String yixiangqingkuang, String lxr, String gphone, String yphone,
			String address, String zzyw, String shengid, String shiid,
			String quid) {
		super(maxCount, currentpage, maxpage,cxpage);
		this.caozuoyuanid = caozuoyuanid;
		this.kehuname = kehuname;
		this.suoshuhangye = suoshuhangye;
		this.yixiangqingkuang = yixiangqingkuang;
		this.lxr = lxr;
		this.gphone = gphone;
		this.yphone = yphone;
		this.address = address;
		this.zzyw = zzyw;
		this.shengid = shengid;
		this.shiid = shiid;
		this.quid = quid;
	}
	public PageConditionCust() {
		super();
	}
	@Override
	public String writeTags() {
		StringBuffer sb=new StringBuffer();
		String condit="&caozuoyuan="+getCaozuoyuanid()+"&customername="+getKehuname()+"&suoshuhangye="+getSuoshuhangye()+"&yixiangqingkuang="+getYixiangqingkuang()+"&txlname="+getLxr()+"&gphone="+getGphone()+"&mphone="+getYphone()+"&address="+getAddress()+"&zyyw="+getZzyw()+"&shengid="+getShengid()+"&shiid="+getShiid()+"&quid="+getQuid();
		//String importstr="?caozuoyuan="+getCaozuoyuanid()+"&customername="+getKehuname()+"&suoshuhangye="+getSuoshuhangye()+"&yixiangqingkuang="+getYixiangqingkuang()+"&txlname="+getLxr()+"&gphone="+getGphone()+"&mphone="+getYphone()+"&address="+getAddress()+"&zyyw="+getZzyw()+"&shengid="+getShengid()+"&shiid="+getShiid()+"&quid="+getQuid();
		sb.append("<form action='"+getCxpage()+""+condit+"' method='post'>");
		sb.append("<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0' class='right-font08'>");
		sb.append("<tr>");
		//第一个td
		sb.append("<td width='30%'>共 <span class='right-text09'>"+getMaxpage()+"</span>页 |第 <span class='right-text09'>"+getCurrentpage()+"</span>页</td>");
		sb.append("<td width='35%' align='center'><a href='javascript:isimport(\""+condit+"\")'>▲▲导出以上查询数据▲▲</a></td>");
		//第二个td
		sb.append("<td width='34%' align='right'>");
		if(getCurrentpage()==1&&getCurrentpage()!=getMaxpage()){
			sb.append("[首页|上一页|<a href='"+getCxpage()+"?page="+(getCurrentpage()+1)+""+condit+"'>下一页</a>|<a href='"+getCxpage()+"?page="+getMaxpage()+""+condit+"'>末页</a>]");
		}else if(getCurrentpage()==1 && getCurrentpage()==getMaxpage()){
			sb.append("[首页|上一页|下一页|末页]");
		}else if(getCurrentpage()>1&&getCurrentpage()<getMaxpage()){
			sb.append("[<a href='"+getCxpage()+"?page=1'"+condit+">首页</a>|<a href='"+getCxpage()+"?page="+(getCurrentpage()-1)+""+condit+"'>上一页</a>|<a href='"+getCxpage()+"?page="+getCurrentpage()+1+""+condit+"'>下一页</a>|<a href='"+getCxpage()+"?page="+getMaxpage()+""+condit+"'>末页</a>]");
		}else if(getCurrentpage()==getMaxpage()){
			sb.append("[<a href='"+getCxpage()+"?page=1'"+condit+">首页</a>|<a href='"+getCxpage()+"?page="+(getCurrentpage()-1)+""+condit+"'>上一页</a>|下一页|末页]");

		}
		sb.append("</td>");
        //第三个td
		sb.append("<td width='1%'>");
		sb.append("<table width='20' border='0' cellspacing='0' cellpadding='0'>");
		sb.append("<tr>");
		sb.append(" <td width='1%'><input name='page' type='text' class='right-textfield03' size='1' /></td>");
		sb.append("<td width='87%'><input name='Submit23222' type='submit' class='right-button06' value=''/>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</td>");
		
		
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</form>");
		return sb.toString();
	}

	
}
