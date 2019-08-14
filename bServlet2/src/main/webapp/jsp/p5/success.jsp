<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.mh.Introspector.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>javaBean标签封装数据</title>
</head>
<body>
	<h1>1. 传统方式</h1>
	<%
		request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			User u = new User(name, pwd);
	%>
	<%=u.getName()%>
	<h1>2. jsp标签</h1>
	<jsp:useBean id="u2" class="cn.mh.Introspector.User"></jsp:useBean>
	<jsp:setProperty property="name" name="u2"/>
	<jsp:setProperty property="pwd" name="u2"/>
	
	<jsp:setProperty property="*" name="u2"/>
		
	<jsp:getProperty property="name" name="u2"/>
</body>
</html>