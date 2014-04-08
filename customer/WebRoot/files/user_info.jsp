<%@page import="com.starinno.portal.personnel.pojo.TbPersonnel"%>
<%@ include file="../power.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>资料信息修改</title>
<script type="text/javascript" src="../js/validate1.js"></script>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>
<body class="ContentBody">
<%
if(session.getAttribute("operate_info")!=null){
				    out.println("<script>alert('"+session.getAttribute("operate_info")+"');</script>");
					session.removeAttribute("operate_info");
}
%>
<span id="boxs"></span>
  <form action="uppdateziliao.action" method="post"  name="form" onsubmit="return update_ziliao()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >资料信息修改</th>
  </tr>
  <tr>
    <td class="CPanel">
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
				<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>个人资料信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					  	
					    <td nowrap align="right" width="15%">人员工号:</td>
					    <td width="35%"><input  name='gonghao' type="text" class="text" style="width:154px" value='<s:property value="#session.user.personnelId"/>' disabled="disabled"/>
				        </td>
					    <td width="16%" align="right" nowrap="nowrap">人员名字:</td>
					    <td width="34%"><input id="custname" class="text" name='custname' style="width:154px" value="<s:property value="#session.user.personnelName"/>"></td>
					  </tr>
				 <tr>
					    <td nowrap align="right" width="15%">人员电话:</td>
					    <td width="35%"><input id="custphone" name='custphone' type="text" class="text" style="width:154px" value="<s:property value="#session.user.personnelPhone"/>" />
				        </td>
 						<td width="16%" align="right" nowrap="nowrap">人员性别:</td>
					    <td width="34%">
						<select name="sex">
							<%if(((TbPersonnel)session.getAttribute("user")).getPersonnelSex().equals("男")){ %>
							<option value="男" selected="selected">男</option>
							<option value="女">女</option>
							<%}else{ %>
							<option value="男">男</option>
							<option value="女" selected="selected">女</option>
							<%} %>
						</select>
						</td>
					  </tr>
					   <tr>
					    <td nowrap align="right" width="15%">人员年龄:</td>
					    <td width="35%"><input id="age" name='age' type="text" class="text" style="width:154px" value="<s:property value="#session.user.personnelAge"/>" />
				        </td>
 					
					  </tr>
					  </table>
			
				</fieldset>			</TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="修改" class="button" />　
	       </TD>
		</TR>
		</TABLE>
</div>
</form>
</body>
</html>
