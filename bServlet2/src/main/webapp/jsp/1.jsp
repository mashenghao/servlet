<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>十行十列表格</title>
</head>
<body>
	<table border="1">
		<%
			for (int i = 0; i < 10; i++) {
		%>
		<tr>
			<%
				for (int j = 0; j < 10; j++) {
			%>
			<td>
				<%=i%>--<%=j%>
			</td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>