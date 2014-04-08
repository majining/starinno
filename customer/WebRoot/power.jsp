<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	if(session.getAttribute("user")==null){
		response.sendRedirect("../login.jsp");
		return;
	}
 %>

