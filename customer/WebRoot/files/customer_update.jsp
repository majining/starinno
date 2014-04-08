<%@ include file="../power.jsp" %>
<%@page import="com.starinno.portal.customer.pojo.TbCustomerinfo"%>
<%@page import="com.starinno.portal.address.pojo.TbSheng"%>
<%@page import="com.starinno.portal.address.service.AddressService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>查看</title>
		<script type="text/javascript" src="../js/Address.js"></script>
		<script type="text/javascript" src="../js/validate1.js"></script>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
	</head>
<body>
<%
	if(session.getAttribute("operate_info")!=null){
		    out.println("<script>alert('"+session.getAttribute("operate_info")+"');</script>");
	session.removeAttribute("operate_info");
		}
%>
<form name="fom" id="fom" method="post" action="updatecust.action" onsubmit="return customerinfoval()">
<input name="custid" type="hidden" value="<s:property value="tc.customerId"/>"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">       
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;<input name="Submit3" type="button" class="right-button08" value="后退->客户列表" onclick="location.href='findlist.action'"/></td>
			  <td width="100%" align="center" style="font: bold 20px arial,sans-serif;">客户信息修改</td>
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
                    <td width="84%"><input  id="customername" type="text" value="<s:property value="tc.customerKhname"/>"  disabled="disabled"/><label style="color:red">*当前不支持修改</label></td>
                    </tr>
                  <tr bgcolor="#FFFFFF">
				    <td align="right">所属行业:</td>
				    <td><input name="suoshuhangye" id="suoshuhangye" type="text"  value="<s:property value="tc.customerSshy"/>"/></td>
                    </tr>
                  <tr bgcolor="#FFFFFF">
				    <td align="right" >意向情况:</td>
				    <td>
				    <textarea rows="5" cols="50" id="yixiangqingkuang" name="yixiangqingkuang"><s:property value="tc.customerYxqk"/></textarea>
				    </td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">联系人:</td>
				    <td><input name="txlname" type="text" id="txlname" value="<s:property value="tc.customerLxr"/>"/></td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">电话:</td>
				    <td><input name="gphone" id="gphone" type="text" value="<s:property value="tc.customerGphone"/>"/></td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">手机:</td>
				    <td><input name="mphone" type="text" id="mphone" value="<s:property value="tc.customerMphone"/>"/></td>
                   </tr>
                   <tr bgcolor="#FFFFFF">
				    	<td align="right" >地址:</td>
				    	<td><input name="address" id="address" type="text" value="<s:property value="tc.customerAddress"/>"/></td>
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
				    				    				    	 		TbSheng myts=((TbCustomerinfo)request.getAttribute("tc")).getTbQu().getTbShi().getTbSheng();
				    				    					    	 	if(ts.getShengId().equals(myts.getShengId())){
				    				    				 		 			out.println("<option value='"+ts.getShengId()+"' selected='selected'>"+ts.getShengName()+"</option>");
				    				    				 		 			continue;
				    				    			 		 			}
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
				    	<select id="shi" onchange="loadqu()">
				    		<option value="<s:property value="tc.tbQu.tbShi.shiId"/>"><s:property value="tc.tbQu.tbShi.shiName"/></option>
				    	</select>
				    	</td>
                   </tr>
                     <tr bgcolor="#FFFFFF">
				    	<td align="right">区:</td>
				    	<td>
				    	<select id="qu" name="quid">
				    		<option value="<s:property value="tc.tbQu.quId"/>"><s:property value="tc.tbQu.quName"/></option>
				    	</select>
				    	</td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">主营业务:</td>
				    <td><input name="zyyw" type="text" value="<s:property value="tc.customerZyyw"/>"/></td>
                   </tr>
					
                   <tr bgcolor="#FFFFFF">
				    <td align="right"></td>
				    <td><input name="Submit3" type="submit" class="right-button08" value="修改"/></td>
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