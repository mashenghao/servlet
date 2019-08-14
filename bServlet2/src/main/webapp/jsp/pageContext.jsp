<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp内置对象--pageContext详解</title>
</head>
<body>
	<h2>1.存取值</h2>
	<%pageContext.setAttribute("aa", "aa-value");
		String a = (String)pageContext.getAttribute("aa");
	%>
	<%=a %>
	
	<h2>2.获取其他内置对象</h2>
	
</body>
</html>