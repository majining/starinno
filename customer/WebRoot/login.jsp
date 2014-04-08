<%@page import="com.starinno.portal.quanxian.pojo.TbQx"%>
<%@page import="com.starinno.portal.quanxian.service.QxService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	session.removeAttribute("user");
	session.removeAttribute("custid");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>星创信息管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/validate1.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body>
<%
			if(session.getAttribute("login_info")!=null){
				    out.println("<script>alert('"+session.getAttribute("login_info")+"');</script>");
					session.removeAttribute("login_info");
			}
%>
<form action="login.action" method="post" onsubmit="return loginvalidate()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="images/top02.gif"><img src="images/top03.gif" width="776" height="147" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
        <td height="35" class="login-text02">请选择权限：</td>
        <td>
			<select style="width:240px;" id="qxid" name="qxid" onchange="findperbyquanxian()">
					<option value="-1">请选择类别</option>
						<%
				    		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
				    	 	QxService qs= (QxService)wac.getBean("qxservice");
				    	 	List<TbQx> qxlist=qs.findByList();
				    	 	for(TbQx qx:qxlist){
				    		 %>
			 				<option value="<%=qx.getQxId()%>"><%=qx.getQxName() %></option>
				 			<%
				 				}
				 			 %>
			</select>
		</td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">用户名称：<br /></td>
        <td width="69%">
        	<select style="width:240px;" id="perid" name="gonghao">
        		
        	</select>
        </td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密　码：<br /></td>
        <td><input name="pwd" type="password" size="33" id="pwd" /></td>
      </tr>
      <!-- 
      <tr>
        <td height="35" class="login-text02">验证图片：<br /></td>
        <td><img src="images/pic05.gif" width="109" height="40" /> <a href="#" class="login-text03">看不清楚，换张图片</a></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">请输入验证码：</td>
        <td><input name="textfield3" type="text" size="30" /></td>
      </tr>
      -->

      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="submit" class="right-button01" value="确认登陆"  />
          <input name="Submit232" type="reset" class="right-button02" value="重 置" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>