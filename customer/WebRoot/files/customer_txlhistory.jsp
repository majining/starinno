<%@ include file="../power.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/mypagetag" prefix="p" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>客户管理联系记录</title>
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
-->
</style>
<script type="text/javascript" src="../js/tool.js"></script>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/xiangmu.js"></script>
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="sendxiaoxi.htm";
   document.getElementById("fom").submit();
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
<%
				if(session.getAttribute("operate_info")!=null){
				    out.println("<script>alert('"+session.getAttribute("operate_info")+"');</script>");
					session.removeAttribute("operate_info");
}
%>
<body onload="on_load()">

<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
     
     
      <tr>
        <td height="62" background="../images/nav04.gif">
		  <!-- background="../images/nav04.gif" -->
		  
		  
 <table  border="0" width="100%"  cellpadding="0" cellspacing="0" >
		  <tr>
			  <td width="21">&nbsp;<input name="Submit3" type="button" class="right-button08" value="后退->客户列表" onclick="location.href='findlist.action'"/></td>
			  <td width="200%" align="center" style="font: bold 20px arial,sans-serif; text-align: center;">客户联系记录</td>
		  </tr>
 </table>
 

        
        </td>
      </tr>
      
      
    </table>
    </td>
  </tr>
  <tr>
    <td>
    <form name="fom" id="fom" method="post" action="deletetxl.action" onsubmit="return isdelete()">
    <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="30"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
                 </td>
                <td align="right">
                <span >
                <input name="Submit2" type="button" class="right-button08" onclick="location.href='customer_txlhistory_create.jsp'" value="新建记录"/>
                <input name="Submit3" type="submit" class="right-button08" value="删除所选记录"/>
               
                 </span>
                 </td>
          	 </tr>
              <tr>
                <td height="40" class="font42" colspan="2"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" colspan="5" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align: center;"> 联系记录 </td>
                  </tr>
                  <tr>
                    <td width="5%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="12%" height="20" align="center" bgcolor="#EEEEEE">联系人</td>
                    <td width="5%" align="center" bgcolor="#EEEEEE">联系时间</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">联系内容</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <s:iterator id="custlxr" value="list">
                  <tr align="center">
                    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="<s:property value="#custlxr.customertxlId"/>"/></td>
                    <td height="20" bgcolor="#FFFFFF"><s:property value="#custlxr.tbCustomerinfo.customerLxr"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#custlxr.customertxlLxtime"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#custlxr.customertxlLxcontent"/></td>
                    <td bgcolor="#FFFFFF">【<a href="gettxl.action?lxid=<s:property value="#custlxr.customertxlId"/>">修改</a>】</td>
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
          
        	<p:writetags name="mypage"></p:writetags>
          
          </td>
        </tr>
      </table>
      
      
      </td>
  </tr>
</table>


<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="file:///F|/项目管理相关资料/项目管理系统页面/images/loadon.gif" />
</div>

</body>
</html>
