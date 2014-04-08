<%@ include file="../power.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>查看</title>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			#tlist tr{
				height:30px;
				font-size: 20px;
				font: bold 20px arial,sans-serif;
			}
		</style>
	</head>
<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">       
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;<input name="Submit3" type="button" class="right-button08" value="后退->客户列表" onclick="location.href='findlist.action'"/></td>
			  <td width="100%" align="center" style="font: bold 20px arial,sans-serif;">客户信息详细查看</td>
			  </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
          <td>
           
			<table id="tlist" width="100%" border="1"  style="font-size:25px; ">
		       	
                  <tr bgcolor="#FFFFFF"  >
				    <td width="32%" align="right" style="padding-right:20px">客户名称:</td>
                    <td width="68%"><s:property value="tc.customerKhname"/></td>
                    </tr>
                  <tr bgcolor="#FFFFFF">
				    <td align="right" style="padding-right:20px">所属行业:</td>
				    <td><s:property value="tc.customerSshy"/></td>
                    </tr>
                  <tr bgcolor="#FFFFFF">
				    <td align="right" style="padding-right:20px">意向情况:</td>
				    <td><s:property value="tc.customerYxqk"/></td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right" style="padding-right:20px">联系人:</td>
				    <td><s:property value="tc.customerLxr"/></td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right" style="padding-right:20px">电话:</td>
				    <td><s:property value="tc.customerGphone"/></td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right" style="padding-right:20px">手机:</td>
				    <td><s:property value="tc.customerMphone"/></td>
                   </tr>
                   <tr bgcolor="#FFFFFF">
				    	<td align="right" style="padding-right:20px">地址:</td>
				    	<td><s:property value="tc.customerAddress"/></td>
                   </tr>
                    <tr bgcolor="#FFFFFF">
				    	<td align="right" style="padding-right:20px">所属省:</td>
				    	<td><s:property value="tc.tbQu.tbShi.tbSheng.shengName"/></td>
                   </tr>
                    <tr bgcolor="#FFFFFF">
				    	<td align="right" style="padding-right:20px" >所属市:</td>
				    	<td><s:property value="tc.tbQu.tbShi.shiName"/></td>
                   </tr>
                    <tr bgcolor="#FFFFFF">
				    	<td align="right" style="padding-right:20px">所属区:</td>
				    	<td><s:property value="tc.tbQu.quName"/></td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right" style="padding-right:20px">主营业务:</td>
				    <td><s:property value="tc.customerZyyw"/></td>
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

