<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	if(session.getAttribute("user")==null){
		System.out.println("ffff");
		out.println("<script type='text/javascript'>");
		out.println("parent.location.href='login.jsp'</script>");
		return;
	}
 %>

