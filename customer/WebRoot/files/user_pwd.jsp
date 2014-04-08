<%@ include file="../power.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户密码修改</title>
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
  <form action="uppdatepwd.action" method="post"  name="form" onsubmit="return update_pwd()">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >密码修改</th>
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
					  	
					    <td nowrap align="right" width="15%">原密码:</td>
					    <td width="35%"><input id="oldpwd" name='oldpwd' type="password" class="text" style="width:154px" value=""/>
				        </td>
					    <td width="16%" align="right" nowrap="nowrap">新密码:</td>
					    <td width="34%"><input id="newpwd" class="text" type="password" name='newpwd' style="width:154px" value=""></td>
					  </tr>
				 <tr>
					    <td nowrap align="right" width="15%">重复新密码:</td>
					    <td width="35%"><input id="newpwd1" name='newpwd1' type="password" class="text" style="width:154px" value="" />
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
			<input type="submit" name="Submit" value="修改密码" class="button" />　
	       </TD>
		</TR>
		</TABLE>
</div>
</form>
</body>
</html>
