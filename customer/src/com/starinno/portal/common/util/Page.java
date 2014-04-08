package com.starinno.portal.common.util;


public class Page {
	private int maxCount;
	private int currentpage;
	private int maxpage;
	private String cxpage;
	public String getCxpage() {
		return cxpage;
	}
	public void setCxpage(String cxpage) {
		this.cxpage = cxpage;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public Page(int maxCount, int currentpage, int maxpage,String cxpage) {
		super();
		this.maxCount = maxCount;
		this.currentpage = currentpage;
		this.maxpage = maxpage;
		this.cxpage=cxpage;
	}
	public Page() {
		super();
	}
	//写输出 判断页面
	public String writeTags(){
//		System.out.println(getCurrentpage());
//		System.out.println(getMaxpage());
		StringBuffer sb=new StringBuffer();
		sb.append("<form action='"+cxpage+"' method='post'>");
		sb.append("<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0' class='right-font08'>");
		sb.append("<tr>");
		//第一个td
		sb.append("<td width='30%'>共 <span class='right-text09'>"+getMaxpage()+"</span>页 |第 <span class='right-text09'>"+getCurrentpage()+"</span>页</td>");
		//第二个
		sb.append("<td width='35%' align='center'><a href='javascript:isimport()'>▲▲导出以上查询数据▲▲</a></td>");
		//第三个td
		sb.append("<td width='34%' align='right'>");
		if(getCurrentpage()==1&&getCurrentpage()!=getMaxpage()){
			sb.append("[首页|上一页|<a href='"+cxpage+"?page="+(getCurrentpage()+1)+"'>下一页</a>|<a href="+cxpage+"?page="+getMaxpage()+">末页</a>]");
		}else if(getCurrentpage()==1 && getCurrentpage()==getMaxpage()){
			sb.append("[首页|上一页|下一页|末页]");
		}else if(getCurrentpage()>1&&getCurrentpage()<getMaxpage()){
			sb.append("[<a href='"+cxpage+"?page=1'>首页</a>|<a href='"+cxpage+"?page="+(getCurrentpage()-1)+"'>上一页</a>|<a href='"+cxpage+"?page="+(getCurrentpage()+1)+"'>下一页</a>|<a href='"+cxpage+"?page="+getMaxpage()+"'>末页</a>]");
		}else if(getCurrentpage()==getMaxpage()){
			sb.append("[<a href='"+cxpage+"?page=1'>首页</a>|<a href='"+cxpage+"?page="+(getCurrentpage()-1)+"'>上一页</a>|下一页|末页]");

		}
		sb.append("</td>");
        //第四个td
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
