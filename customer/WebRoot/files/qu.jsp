<%@ include file="../power.jsp" %>
<%@page import="com.starinno.portal.address.pojo.TbSheng"%>
<%@page import="com.starinno.portal.address.pojo.TbQu"%>
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
<title>区</title>
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
<script type="text/javascript" src="../js/tool.js"></script>
<script type="text/javascript" src="../js/Address.js"></script>
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
	AddressService as= (AddressService)wac.getBean("addressservice");
    //查询省
    List<TbSheng> list= as.findBySheng();
    //查询区
   // List<TbQu> qulist=as.findAllQu();
%>
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    <form action="addqu.action" method="post" onsubmit="return quval()">
    <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="30">
                 </td>
                <td align="right"><span >
               		 <!-- 加载省 -->
              		  <select id="sheng"  onchange="loadshi()">
              		  		<option value="-1">请选择省:</option>
				    	<%
				    	 	for(TbSheng ts:list){
				    		 %>
			 				<option value="<%=ts.getShengId()%>"><%=ts.getShengName() %></option>
			 			<%
			 				}
			 			 %>
				    	</select>
				    	<!-- 加载市 -->
				    	<select  id="shi" name="shiid" onchange="loadqu()">
				    		<option value="-1">请选择市:</option>
				    	</select>
				    	<!-- 加载市区-->
				    	<!-- 加载区 -->
				    	<select   id="qu" style="display: none">
				    		<option value="-1">请选择区:</option>
				    	</select>
				    	
                 <input  type="text" name="quname" id="quname" value=""/>
                 <input  type="submit" class="right-button08" value="新增"/>
                 <input  type="button" class="right-button08" value="查看区"  onclick="javascript:address_ckqu()"/>             
                </span>
                 </td>
          	 </tr>
              <tr>
                <td height="40" class="font42" colspan="2"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" colspan="5" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align: center;"> 区列表 </td>
                  </tr>
                  <tr>
                  	 <td width="10%" height="20" align="center" bgcolor="#EEEEEE">区id</td>
                  	 <td width="25%" height="20" align="center" bgcolor="#EEEEEE">所属省</td>
                  	 <td width="25%" height="20" align="center" bgcolor="#EEEEEE">所属市</td>
                    <td width="25%" height="20" align="center" bgcolor="#EEEEEE">区</td>
                    <td width="30%" height="20" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                   <%
                  	TbPersonnel tp=(TbPersonnel)session.getAttribute("user");
                  	String qxname=tp.getTbQx().getQxName();
                   %>
 				<s:iterator id="q" value="qulist">
                  <tr align="center">
                  	 <td height="20" bgcolor="#FFFFFF"><s:property value="#q.quId"/></td>
                  	 <td height="20" bgcolor="#FFFFFF"><s:property value="#q.tbShi.tbSheng.shengName"/></td>
                  	 <td height="20" bgcolor="#FFFFFF"><s:property value="#q.tbShi.shiName"/></td>
                    <td height="20" bgcolor="#FFFFFF"><s:property value="#q.quName"/></td>
                    <td bgcolor="#FFFFFF">
                     <%
                    		if(qxname.equals("管理员")){
                    	%>
                    	【<a href="javascript:address_delete('dropqu.action?quid=<s:property value='#q.quId'/>')">删除</a>】             		
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