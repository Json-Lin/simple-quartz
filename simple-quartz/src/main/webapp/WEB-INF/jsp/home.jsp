<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib uri="http://www.winxuan.com/tag/token" prefix="token"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p align="center">${msg}</p>
	<form action="/sub" method="post">
		<token:token></token:token>
		<table>
			<tr>
				<td><input type="text" value="123" name="a1"></td>
			</tr>
			<tr>
				<td><input type="text" value="123" name="a1"></td>
			</tr>
			<tr>
				<td><input type="text" value="123" name="a1"></td>
			</tr>
			<tr>
				<td><input type="text" value="123" name="a1"></td>
			</tr>
			<tr>
				<td><input type="text" value="123" name="a1"></td>
			</tr>
			<tr>
				<td><input type="text" value="123" name="a1"></td>
			</tr>
			<tr>
				<td><input type="text" value="123" name="a1"></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>