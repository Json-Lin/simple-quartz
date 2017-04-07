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
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="提交">
		<c:if test="${true==isSuc}"><script type="text/javascript">alert("上传成功")</script></c:if>
		<c:if test="${false==isSuc}"><script type="text/javascript">alert("${msg}")</script></c:if>
	</form>
</body>
</html>