<%@ include file="../power.jsp" %>
<%@page import="com.starinno.portal.address.pojo.TbQu"%>
<%@page import="com.starinno.portal.address.pojo.TbShi"%>
<%@page import="com.starinno.portal.address.service.AddressService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.starinno.portal.personnel.pojo.TbPersonnel"%>
<%@page import="com.starinno.portal.personnel.service.PersonnelService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/mypagetag" prefix="p" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>客户管理列表</title>
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
<script type="text/javascript" src="../js/Address.js"></script>
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
<form name="fom" id="fom" method="post" action="findByCondition.action">
  <tr>
    <td>
<!-- 复杂查询form表单 -->
<div style="background-color: #daecf6">
		  <table width="1086" border="0" id="condit_table1">
		  	<tr>
		  		<td width="35" height="20"><img src="../images/ico07.gif" width="20" height="18" /></td>
		  		<td width="236"> 业务员:
                <select style="width: 154px;" name="caozuoyuan">
		 <s:if test="#session.user.tbQx.qxName=='普通人员'">
		 		<option value="<s:property value="#session.user.personnelId"/>"><s:property value="#session.user.personnelName"/></option>
		 </s:if>
		 <s:else>
			 		<option value="-1">请选择</option>
		 		<%
		 			PersonnelService ps= (PersonnelService)wac.getBean("personnelservice");
		 				 				 			List<TbPersonnel> list= ps.findByAll();
		 				 				 			//caozuoyuan  是获取的valuestack里面de
		 				 				 		 	for(TbPersonnel tp:list){
		 				 				 		 		if(tp.getPersonnelId().equals(request.getAttribute("caozuoyuan"))){
		 				 				 		 			out.println("<option value='"+tp.getPersonnelId()+"' selected='selected'>"+tp.getPersonnelName()+"</option>");
		 				 				 		 			continue;
		 				 				 		 		}
		 		%>
				 	<option  value="<%=tp.getPersonnelId()%>"><%=tp.getPersonnelName()%></option>
					<%
						}
					%>			 	
		 </s:else>
			 </select>
                </td>
		  		<td width="268">客户名称:<input name="customername" type="text" value="<s:property value="customername"/>"/></td>
		  		<td width="257">所属行业:<input name="suoshuhangye" type="text" value="<s:property value="suoshuhangye"/>"/></td>
		  		<td width="256">意向情况:<input name="yixiangqingkuang" type="text" value="<s:property value="yixiangqingkuang"/>"/></td>
		  		
		  	</tr>
		  </table>
		   <table width="1088" border="0" id="condit_table2">
		  	<tr>
		  		<td width="35" height="20"></td>
                <td width="236">联系人:<input name="txlname" type="text" value="<s:property value="txlname"/>"/></td>
		  		<td width="268"> 电话:<input name="gphone" type="text" value="<s:property value="gphone"/>"/></td>
		  		<td width="257">手机:<input name="mphone" type="text" value="<s:property value="mphone"/>" /></td>
		  		<td width="256">地址:<input name="address" type="text" value="<s:property value="address"/>"/></td>
		  		
		  	</tr>
</table>
		   <table border="0" id="condit_table3">
		  	<tr>
            	<td width="34" height="20"></td>
          	  <td width="239">主营业务:<input name="zyyw" type="text" value="<s:property value="zyyw"/>"/></td>
		  		<td width="269">省:
                <select style="width: 170px;" onchange="loadshi()" id="sheng" name="shengid">
			 <option value="-1">请选择</option>
			 	<s:iterator id="sheng" value="shenglist">
			 		<s:if test="#sheng.shengId==shengid">
			 		<option value="<s:property value="#sheng.shengId"/>" selected="selected"><s:property value="#sheng.shengName"/></option>	
			 		</s:if>
			 		<s:else>
			 		<option value="<s:property value="#sheng.shengId"/>"><s:property value="#sheng.shengName"/></option>			 		
			 		</s:else>
			 	</s:iterator>
			 </select>
                </td>
		  	
		  		<td width="255">市:
	  		    <select style="width: 170px;" id="shi" onchange="loadqu()" name="shiid">
			 		<%
			 			String shiid= (String)request.getAttribute("shiid");
			 			 			 			if(!shiid.equals("-1")){
			 			 			 				AddressService as=(AddressService)wac.getBean("addressservice");
			 			 			 				TbShi ts= as.findByShiId(shiid);
			 		%>
			 		<option value="<%=ts.getShiId()%>"><%=ts.getShiName()%> </option>
			 		<%
			 			}
			 		%>
			 		 
			 </select>
                </td>
		  		<td width="254">区:
	  		    <select style="width: 170px; " id="qu" name="quid">
			 		<%
			 			String quid= (String)request.getAttribute("quid");
			 			 			 			if(!quid.equals("-1")){
			 			 			 				AddressService as=(AddressService)wac.getBean("addressservice");
			 			 			 				TbQu tq= as.findById(quid);
			 		%>
			 		<option value="<%=tq.getQuId()%>"><%=tq.getQuName()%> </option>
			 		<%
			 			}
			 		 %>
			 </select>
                </td>
		  	</tr>
</table>
 <table border="0">
		  	<tr>
            	<td width="34" height="25"></td>
          	    <td width="239" align="center"><input name="Submit" type="submit" class="right-button07"  value="立即筛选" /></td>
		  		<td width="269"></td>
		  		<td width="255"></td>
		  		<td width="254" ></td>
		  	</tr>
</table>
</div>
<!-- 复杂查询form表单结束 -->
    </td>
  </tr>
  </form>  
  <tr>
    <td>
    <!-- 删除的表单form -->
    <form action="deletecust.action" method="post" onsubmit="return isdelete()">
    <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="30"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
                 </td>
                <td align="right"><span >
                 <input name="Submit2" type="button" class="right-button08" value="新建客户" onclick="location.href='customer_create.jsp'"/>
                 <input name="Submit2" type="submit" class="right-button08" value="删除客户"/>
               </span>
                 </td>
          	 </tr>
              <tr>
                <td height="40" class="font42" colspan="2"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" colspan="8" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align: center;"> 客户列表 </td>
                  </tr>
                  <tr>
                    <td width="5%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="15%" height="20" align="center" bgcolor="#EEEEEE">客户名称</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">联系人</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">固定电话</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">主营业务</td>
                    <td width="15%" align="center" bgcolor="#EEEEEE">地区</td>
                     <td width="7%" align="center" bgcolor="#EEEEEE">业务员</td>
                    <td width="25%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <s:iterator id="customer" value="list">
                  <tr align="center">
                    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="<s:property value="#customer.customerId"/>"/></td>
                    <td height="20" bgcolor="#FFFFFF"><s:property value="#customer.customerKhname"/> </td>
                    <td bgcolor="#FFFFFF"><s:property value="#customer.customerLxr"/> </td>
                    <td bgcolor="#FFFFFF"><s:property value="#customer.customerGphone"/> </td>
                    <td bgcolor="#FFFFFF"><s:property value="#customer.customerZyyw"/> </td>
                    <td bgcolor="#FFFFFF"><s:property value="#customer.customerAddress"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#customer.tbPersonnel.personnelName"/></td>
                    <td bgcolor="#FFFFFF">【<a href="getcust.action?custid=<s:property value="#customer.customerId"/>">详情</a>】【<a href="findtxlBycustId.action?custid=<s:property value="#customer.customerId"/>">联系记录</a>】【<a href="getcustforupdate.action?custid=<s:property value="#customer.customerId"/>">修改</a>】</td>
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
          
          <!-- 分页控制 -->
         <p:writetags name="pageobj"></p:writetags>
          <!-- 结束 -->
          
          
          </td>
          
        </tr>
      </table></td>
  </tr>
</table>

</body>
</html>