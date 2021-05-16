<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${formTitle}</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>

			<div class="col-lg-6">
				<h1 style="text-align: center;">${formTitle}</h1>
				<form:form action="" method="POST" modelAttribute="thuongHieu">

					<div class="form-group">
						<label>Tên thương hiệu:</label>
						<form:input path="tenThuongHieu" class="form-control"/>
						<form:errors path="tenThuongHieu" cssClass="error" ></form:errors>
					</div>

					<button type="submit" class="btn btn-success">${formButton}</button>
					<button type="reset" class="btn btn-danger">Hủy</button>

				</form:form>

			</div>

			<div class="col-lg-3"></div>
		</div>
		
		<a href="<c:url value='/admin/thuong-hieu/danh-sach-thuong-hieu' />">Quay lại</a>




	</div>
	<!-- /.container-fluid -->
</body>
</html>