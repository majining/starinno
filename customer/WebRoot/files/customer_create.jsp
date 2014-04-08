<%@ include file="../power.jsp" %>
<%@page import="com.starinno.portal.address.pojo.TbSheng"%>
<%@page import="com.starinno.portal.address.service.AddressService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>创建</title>
		<script type="text/javascript" src="../js/Address.js"></script>
		<script type="text/javascript" src="../js/validate.js"></script>
		<script type="text/javascript" src="../js/validate1.js"></script>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>
<body>
<%
	if(session.getAttribute("operate_info")!=null){
		    out.println("<script>alert('"+session.getAttribute("operate_info")+"');</script>");
	session.removeAttribute("operate_info");
		}
%>
<form name="fom" id="fom" method="post" action="savecust.action" onsubmit="return customerinfoval()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">       
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;<input name="Submit3" type="button" class="right-button08" value="后退->客户列表" onclick="location.href='findlist.action'"/></td>
			  <td width="100%" align="center" style="font: bold 20px arial,sans-serif;">客户信息创建</td>
			  </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>	
        <TD height="40" class="font42">
			<table width="100%" border="2"  height="200" style="font-size:12px">
		       	
                  <tr bgcolor="#FFFFFF" height="10">
				    <td width="16%" align="right">客户名称</td>
                    <td width="84%"><input name="customername" id="customername" type="text" value="" onblur="isflag()"/><label id="customerinfo" style="color:red;"></label></td>
                    </tr>
                  <tr bgcolor="#FFFFFF">
				    <td align="right">所属行业:</td>
				    <td><input id="suoshuhangye" name="suoshuhangye" type="text" value=""/></td>
                    </tr>
                  <tr bgcolor="#FFFFFF">
				    <td align="right">意向情况:</td>
				    <td>
				    <textarea id="yixiangqingkuang" rows="5" cols="50" name="yixiangqingkuang"></textarea>
				    </td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">联系人:</td>
				    <td><input id="txlname" name="txlname" type="text" value=""/></td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">电话:</td>
				    <td><input id="gphone" name="gphone" type="text" value=""/></td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">手机:</td>
				    <td><input id="mphone" name="mphone" type="text" value=""/></td>
                   </tr>
                   <tr bgcolor="#FFFFFF">
				    	<td align="right" >地址:</td>
				    	<td><input  id="address" name="address" type="text" value=""/></td>
                   </tr>
                    <tr bgcolor="#FFFFFF">
				    	<td align="right">省:</td>
				    	<td>
				    	<select id="sheng" onchange="loadshi()">
				    		<%
				    			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
				    				    				    	 	AddressService as= (AddressService)wac.getBean("addressservice");
				    				    				    	 	List<TbSheng> shenglist=as.findBySheng();
				    				    				    	 	for(TbSheng ts:shenglist){
				    		%>
			 				<option value="<%=ts.getShengId()%>"><%=ts.getShengName() %></option>
			 			<%
			 				}
			 			 %>
				    	</select>
				    	</td>
                   </tr>
                     <tr bgcolor="#FFFFFF">
				    	<td align="right">市:</td>
				    	<td>
				    	<select name="shiid" id="shi" onchange="loadqu()">
				    		<option value="-1">请选择</option>
				    	</select>
				    	</td>
                   </tr>
                     <tr bgcolor="#FFFFFF">
				    	<td align="right">区:</td>
				    	<td>
				    	<select id="qu" name="quid">
				    		<option value="-1">请选择</option>
				    	</select>
				    	</td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">主营业务:</td>
				    <td><input name="zyyw" type="text" id="zyyw" value=""/></td>
                   </tr>
                   <tr bgcolor="#FFFFFF">
				    <td align="right"></td>
				    <td><input name="Submit3" type="submit" class="right-button08" value="添加"/></td>
                   </tr>
					
             </table>
		</TD>
		</tr> 
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
		
</table>
</form>
</body>
</html>

