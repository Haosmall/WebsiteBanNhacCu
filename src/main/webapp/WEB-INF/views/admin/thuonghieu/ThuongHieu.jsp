<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thương hiệu</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="exampleInputEmail1">Tìm kiếm</label> <input type="text"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Nhập tên thương hiệu">
				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> <a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/thuong-hieu/them-thuong-hieu'/>">Thêm
						thương hiệu</a>
				</div>
			</div>
		</div>

		<div class="row">

			<table class="table">

				<thead class="thead-light">
					<tr>
						<th>STT</th>
						<th>Mã thương hiệu</th>
						<th>Hình ảnh</th>
						<th>Tên thương hiệu</th>
						<th></th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${ listThuongHieu }" var="thuonghieu"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>${ thuonghieu.id }</td>
							<td><c:if test="${thuonghieu.hinhAnhBase64 != null}">
									<img src="data:image/jpg;base64,${thuonghieu.hinhAnhBase64}"
										width="120" height="80" />
								</c:if></td>
							<td>${ thuonghieu.tenThuongHieu }</td>
							<td><input type="button" class="btn btn-primary table__btn"
								value="Chi tiết"
								onclick="location.href='<c:url value='/admin/thuong-hieu/chi-tiet-thuong-hieu?id=${ thuonghieu.id }' />'">

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='<c:url value='/admin/thuong-hieu/cap-nhat-thuong-hieu?id=${ thuonghieu.id }' />'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="location.href='<c:url value='/admin/thuong-hieu/xoa-thuong-hieu?id=${ thuonghieu.id }' />'">

							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>



	</div>
	<!-- /.container-fluid -->
</body>
</html>