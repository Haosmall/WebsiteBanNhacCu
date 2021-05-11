<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <p>${ user.userId }</p>
	<p>${ user.email }</p>
	<p>${ user.role }</p> --%>

	<%-- <select name="maTinh">
		<option value="Chọn Tỉnh/ thành phố">Chọn Tỉnh/ thành phố</option>
		<c:forEach items="${ listTinh }" var="tinh">

			<option value="${ tinh.id }">${ tinh.tenTinh }</option>
		</c:forEach>
	</select> --%>
	<form:form modelAttribute="tinh">
		<form:select path="maTinh">
			<form:option value="" label="-- Chọn Tỉnh/ Thành phố"></form:option>
			<form:options items="${ listTinh }" />
		</form:select>
	</form:form>

	<form:form modelAttribute="huyen">
		<form:select path="maHuyen">
			<form:option value="" label="-- Chọn Huyện/ Quận"></form:option>
			<form:options items="${ listHuyen }" />
		</form:select>
	</form:form>

	<form:form modelAttribute="xa">
		<form:select path="maXa">
			<form:option value="" label="-- Chọn Xã/ Phường"></form:option>
			<form:options items="${ listXa }" />
		</form:select>
	</form:form>
</body>
</html>