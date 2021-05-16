<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết thương hiệu</title>
</head>
<body>


	<div class="container-fluid">
		
		<p>${ thuongHieu.id }</p>
		<p>${ thuongHieu.tenThuongHieu }</p>
		
		<a href="<c:url value='/admin/thuong-hieu/danh-sach-thuong-hieu' />">Quay lại</a>

	</div>
	<!-- /.container-fluid -->
	
</body>
</html>