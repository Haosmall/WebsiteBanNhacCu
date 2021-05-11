<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm nhà cung cấp</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>

			<div class="col-lg-6">
				<h1 style="text-align: center;">Thêm Nhà cung cấp</h1>
				<form:form action="" method="POST" modelAttribute="nhaCungCap">

					<div class="form-group">
						<label>Tên nhà cung cấp:</label>
						<form:input path="tenNhaCungCap" class="form-control" />
						<form:errors path="tenNhaCungCap" cssClass="error" ></form:errors>
					</div>
					
					<div class="form-group">
						<label>Email:</label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>Số điện thoại:</label>
						<form:input path="soDienThoai" class="form-control" />
						<form:errors path="soDienThoai" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>website:</label>
						<form:input path="website" class="form-control" type="url"/>
						<form:errors path="website" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>Địa chỉ:</label>
						<form:input path="diaChi" class="form-control" />
						<form:errors path="diaChi" cssClass="error"></form:errors>
					</div>

					<button type="submit" class="btn btn-success">Thêm</button>
					<button type="reset" class="btn btn-danger">Hủy</button>

				</form:form>

			</div>

			<div class="col-lg-3"></div>
		</div>
		
		<a href="<c:url value='/admin/nha-cung-cap/danh-sach-nha-cung-cap' />">Quay lại</a>




	</div>
	<!-- /.container-fluid -->
</body>
</html>