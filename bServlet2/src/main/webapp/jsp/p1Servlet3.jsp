<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp脚本元素</title>
</head>
<body>
	1.定义变量：(定义的被翻译成java代码后是成员变量)
	<%!int a = 10;%><br>
	2. 执行逻辑:
	<br>
	<%
		int b = 0;
		for (int i = 0; i < 10; i++) {
	%>
		<%=i%>
	<%
		System.out.println(i);
		}
	%><br> 
	3.结果输出：
	<%=a%>
</body>
</html>