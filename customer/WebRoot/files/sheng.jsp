<%@ include file="../power.jsp" %>
<%@page import="com.starinno.portal.address.pojo.TbSheng"%>
<%@page import="com.starinno.portal.address.pojo.TbQu"%>
<%@page import="com.starinno.portal.address.pojo.TbShi"%>
<%@page import="com.starinno.portal.address.service.AddressService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.starinno.portal.personnel.pojo.TbPersonnel"%>
<%@page import="com.starinno.portal.personnel.service.PersonnelService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>省</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;}
#condit_table1 tr td{
		text-align:right;
		}
	#condit_table2 tr td{
		text-align:right;
		}
	#condit_table3 tr td{
		text-align:right;
		} 
-->
</style>
<!-- 级联 js-->
<script type="text/javascript" src="../js/validate1.js"></script>
<!-- 工具提示的js -->
<script type="text/javascript" src="../js/tool.js"></script>
<script type="text/javascript" src="../js/xiangmu.js"></script>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.getElementsByName("delid");
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.getElementsByName("delid");
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}


function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
</SCRIPT>

<body onload="on_load()">
<%
	if(session.getAttribute("operate_info")!=null){
				    out.println("<script>alert('"+session.getAttribute("operate_info")+"');</script>");
					session.removeAttribute("operate_info");
	}
	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
 %>
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    <form action="addsheng.action" method="post" onsubmit="return shengval()">
    <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="30">
                 </td>
                <td align="right"><span >
                 <input  type="text" name="shengname" id="shengname" value=""/>
                 <input  type="submit" class="right-button08" value="新增"/>
                  <input  type="button" class="right-button08" value="查看省" onclick="javascript:address_cksheng()"/>
                </span>
                 </td>
          	 </tr>
              <tr>
                <td height="40" class="font42" colspan="2"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" colspan="3" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align: center;"> 省列表 </td>
                  </tr>
                  <tr>
                  	<td width="10%" height="20" align="center" bgcolor="#EEEEEE">省id</td>
                    <td width="80%" height="20" align="center" bgcolor="#EEEEEE">省</td>
                    <td width="15%" height="20" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <%
                  	TbPersonnel tp=(TbPersonnel)session.getAttribute("user");
                  	String qxname=tp.getTbQx().getQxName();
                   %>
                <s:iterator id="s" value="shenglist">
                  <tr align="center">
                  	 <td height="20" bgcolor="#FFFFFF"><s:property value="#s.shengId"/></td>
                    <td height="20" bgcolor="#FFFFFF"><s:property value="#s.shengName"/></td>
                    <td bgcolor="#FFFFFF">
                    	<%
                    		if(qxname.equals("管理员")){
                    	%>
                    	【<a href="javascript:address_delete('dropsheng.action?shengid=<s:property value="#s.shengId"/>')" >删除</a>】                    		
                    	<%
                    		}else{
                    	out.println("删除");
                    		}
                    	 %>
                    	</td>
                  </tr>
                </s:iterator>
               
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      </form>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
        
          
          </td>
          
        </tr>
      </table></td>
  </tr>
</table>

</body>
</html>