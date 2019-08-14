<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp内置对象out详解</title>
</head>
<body>
	<h3>jsp的内置对象out是JspWriter对象，response中也有对页面写入的
		操作，是response.getWriter(),PrintWriter对象</h3>

	<!-- 输出结果是CCC AAA BBB DDD -->
	<%="AAAA"%>
	<%out.print("BBBB");%>
	<%response.getWriter().print("CCC");%>
	<%out.print("DDDD");%>
</body>
</html>