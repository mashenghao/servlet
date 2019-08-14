<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1.jsp指令--page</title>
</head>
<body>
	<h2>你好ss</h2>
	<br> 1.page
	<br> 1. language ： 设置jsp文件嵌入的语言
	<br>2. extends ： 继承，指定jsp翻译成servlet继承的类
	<br>3. session： session="false" 关闭页面是否开启session
	<br>4. import
	<@page import="java.util.List"%>
	<br>5. pageEncoding : 设定jsp文件翻译成servlet的编码
	<br> 6. content-type： 设定服务器输出页面的编码（5 6 没有联系）

</body>
</html>