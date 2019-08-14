<%@page import="cn.mh.p2.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/bServlet2/P2Cookie3?no=1"><img alt="" src="./img/1.jpg"></a>
	<a href="/bServlet2/P2Cookie3?no=2"><img alt="" src="./img/2.jpg"></a>
	<a href="/bServlet2/P2Cookie3?no=3"><img alt="" src="./img/3.jpg"></a>
	<a href="/bServlet2/P2Cookie3?no=4"><img alt="" src="./img/4.jpg"></a>
	<a href="/bServlet2/P2Cookie3?no=5"><img alt="" src="./img/5.jpg"></a>
	<a href="/bServlet2/P2Cookie3?no=6"><img alt="" src="./img/6.jpg"></a>
	<br>

	<hr>

	<%
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtil.getCookie(cookies, "items");
		if (cookie != null) {
			String[] nos = cookie.getValue().split(",");
			for (int i = 0; i < nos.length; i++) {
	%>
			<img alt="" src="./img/<%=nos[i]%>.jpg">
	<%
		}
		}
	%>
</body>
</html>