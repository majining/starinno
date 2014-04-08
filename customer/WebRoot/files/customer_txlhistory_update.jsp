<%@ include file="../power.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>修改</title>
		<script type="text/javascript" src="../js/validate1.js"></script>
		<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
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
<form name="fom" id="fom" method="post" action="uppdatetxl.action" onsubmit="return txlval()">
<input name="" type="hidden" value="<s:property value="lxid"/>"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">       
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;<input name="Submit3" type="button" class="right-button08" value="后退->联系记录列表" onclick="location.href='findtxlBycustId.action'"/></td>
			  <td width="100%" align="center" style="font: bold 20px arial,sans-serif;">客户联系记录修改</td>
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
				    <td width="16%" align="right">联系日期</td>
                    <td width="84%"><input name="date" id="date" type="text" value="<s:property value="date"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
                    </tr>
                  <tr bgcolor="#FFFFFF">
				    <td align="right">联系内容:</td>
				    <td>
				    <textarea id="lxcontent" rows="5" cols="50" name="lxcontent"><s:property value="lxcontent"/></textarea>
				    </td>
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

