<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhà cung cấp</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="exampleInputEmail1">Tìm kiếm</label> <input type="text"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Nhập tên sản phẩm">
				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> 
					<a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/nha-cung-cap/them-nha-cung-cap'/>">Thêm
						nhà cung cấp</a>
				</div>
			</div>
		</div>

		<div class="row">

			<table class="table">

				<thead class="thead-light">
					<tr>
						<th>STT</th>
						<th>Mã nhà cung cấp</th>
						<th>Tên nhà cung cấp</th>
						<th>Số điện thoại</th>
						<th>website</th>
						<th>Địa chỉ</th>
						<th></th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${ listNhaCungCap }" var="nhaCungCap"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>${ nhaCungCap.maNhaCungCap }</td>
							<td>${ nhaCungCap.tenNhaCungCap }</td>
							<td>${ nhaCungCap.soDienThoai }</td>
							<td><a href="${ nhaCungCap.website }">${ nhaCungCap.website }</a></td>
							<td>${ nhaCungCap.diaChi }</td>
							<td>
								<%-- <a type="button" class="btn btn-primary table__btn" href="<c:url value='/admin/nha-cung-cap/xem-chi-tiet?id=${ nhaCungCap.maNhaCungCap }' />">Chi tiết</a>
								<a type="button" class="btn btn-warning table__btn" href="<c:url value='/admin/nha-cung-cap/cap-nhat-thong-tin-nha-cung-cap?id=${ nhaCungCap.maNhaCungCap }' />">Sửa</a>
								<a type="button" class="btn btn-danger table__btn" href="<c:url value='/admin/nha-cung-cap/xoa-nha-cung-cap?id=${ nhaCungCap.maNhaCungCap }' />">Xóa</a> --%>

								<input type="button" class="btn btn-primary table__btn"
								value="Chi tiết"
								onclick="location.href='<c:url value='/admin/nha-cung-cap/xem-chi-tiet?id=${ nhaCungCap.maNhaCungCap }' />'">

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='<c:url value='/admin/nha-cung-cap/cap-nhat-thong-tin-nha-cung-cap?id=${ nhaCungCap.maNhaCungCap }' />'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="location.href='<c:url value='/admin/nha-cung-cap/xoa-nha-cung-cap?id=${ nhaCungCap.maNhaCungCap }' />'">

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