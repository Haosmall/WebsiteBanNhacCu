<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${ nguoiDung.id }"/>
	<c:out value="${ nguoiDung.hoTen }"/>
	<c:out value="${ nguoiDung.soDienThoai }"/>
	<c:out value="${ nguoiDung.email }"/>
	
</body>
</html>