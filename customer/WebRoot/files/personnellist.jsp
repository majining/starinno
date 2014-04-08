<%@ include file="../power.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="/mypagetag" prefix="p"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>业务员管理</title>
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
<!-- 工具提示的js -->
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

<body onload="on_load()">
<%
if(session.getAttribute("operate_info")!=null){
				    out.println("<script>alert('"+session.getAttribute("operate_info")+"');</script>");
					session.removeAttribute("operate_info");
}
%>

<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
     
     
      <tr>
        <td height="62" background="../images/nav04.gif">
		  <!-- background="../images/nav04.gif" -->
  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21"></td>
			  <td width="100%" align="center" style="font: bold 20px arial,sans-serif;">员工记录</td>
			  </tr>
          </table>

        </td>
      </tr>
      
      
    </table>
    </td>
  </tr>
  <tr>
    <td>
    <form name="fom" id="fom" method="post" action="" >
    <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="30"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
                 </td>
                <td align="right"><span >
                 <input name="Submit2" type="button" class="right-button08" value="新建人员" onclick="location.href='personnel_create.jsp'"/>
            
                 </span></td>
          	 </tr>
              <tr>
                <td height="40" class="font42" colspan="2"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" colspan="9" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align: center;"> 人员列表 </td>
                  </tr>
                  <tr>
                    <td width="5%" align="center" bgcolor="#EEEEEE">选择</td>
                     <td width="12%" height="20" align="center" bgcolor="#EEEEEE">人员id</td>
                    <td width="12%" height="20" align="center" bgcolor="#EEEEEE">人员名字</td>
                    <td width="5%" align="center" bgcolor="#EEEEEE">人员电话</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">人员性别</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">人员权限</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">人员年龄</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">创建时间</td>
                    <td width="26%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <s:iterator id="tp" value="listtp">
                  <tr align="center">
                    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid" value="<s:property value="#tp.personnelId"/>"/></td>
                    <td height="20" bgcolor="#FFFFFF"><s:property value="#tp.personnelId"/></td>
                    <td  bgcolor="#FFFFFF"><s:property value="#tp.personnelName"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#tp.personnelPhone"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#tp.personnelSex"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#tp.tbQx.qxName"/></td>
                      <td bgcolor="#FFFFFF"><s:property value="#tp.personnelAge"/></td>
                      <td bgcolor="#FFFFFF"><s:property value="#tp.personnelCreatetime"/></td>
                  <td bgcolor="#FFFFFF">【<a href="findperobj?gonghao=<s:property value="#tp.personnelId"/>">修改</a>】【|<a href="javascript:isdeleteper('<s:property value="#tp.personnelId"/>')">删除</a>】</td>
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
      </table></td>
  </tr>
</table>


</body>
</html>
