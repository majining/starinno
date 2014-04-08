<%@ include file="../power.jsp" %>
<%@page import="com.starinno.portal.quanxian.pojo.TbQx"%>
<%@page import="com.starinno.portal.quanxian.service.QxService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>创建业务员</title>
		<script type="text/javascript" src="../js/validate1.js"></script>
		<link href="../css/css.css" rel="stylesheet" type="text/css" />
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>
<body>
<%
if(session.getAttribute("operate_info")!=null){
				    out.println("<script>alert('"+session.getAttribute("operate_info")+"');</script>");
					session.removeAttribute("operate_info");
	}
WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
 %>
<form name="fom" id="fom" method="post" action="addperobj.action" onsubmit="return perval()">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">       
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;<input name="Submit3" type="button" class="right-button08" value="后退->客户列表" onclick="location.href='findperlist.action'"/></td>
			  <td width="100%" align="center" style="font: bold 20px arial,sans-serif;">客户信息创建</td>
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
		       	
             
                  <tr bgcolor="#FFFFFF">
				    <td align="right">人员姓名:</td>
				    <td><input id="custname" name="custname" type="text" value=""/></td>
                    </tr>
                    <tr bgcolor="#FFFFFF">
				    <td align="right">人员密码:</td>
				    <td><input id="pwd" name="pwd" type="text" value=""/></td>
                    </tr>
                  <tr bgcolor="#FFFFFF">
				    <td align="right">人员电话:</td>
				    <td>
				    <input id="custphone" name="custphone" type="text" value=""/>
				    </td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">人员性别:</td>
				    <td>
					<select name="sex" id="sex">
						<option value="-1">请选择</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
					</td>
                   </tr>
					<tr bgcolor="#FFFFFF" >
				    <td align="right">人员权限:</td>
				    <td>
				    <select name="qxid" id="qxid">
				    	<option value="-1">请选择</option>
				    <%
			 		    QxService ps= (QxService)wac.getBean("qxservice");
			 			List<TbQx> list= ps.findByList();
			 		 	for(TbQx tq:list){
				 		 %>
					 	<option value="<%=tq.getQxId()%>"><%=tq.getQxName()%></option>
						<%
						}
					 %>	
						
					</select>
				    </td>
                   </tr>
					<tr bgcolor="#FFFFFF">
				    <td align="right">人员年龄:</td>
				    <td><input id="age" name="age" type="text" value=""/></td>
                   </tr>
                   
                   <tr bgcolor="#FFFFFF">
				    <td align="right"></td>
				    <td><input name="Submit3" type="submit" class="right-button08" value="添加"/></td>
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

