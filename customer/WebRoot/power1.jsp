<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	if(session.getAttribute("user")==null){
		
		session.setAttribute("login_info","系统检测到长时间没有登录,请重新登陆!");
		response.sendRedirect("login.jsp");
		return;
	}
 %>

