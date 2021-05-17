<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="exampleInputEmail1">Tìm kiếm</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Nhập tên sản phẩm">

				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> <a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/san-pham/them-san-pham'/>">Thêm nhà
						sản phẩm</a>
				</div>
			</div>

		</div>


		<div class="row">

			<table class="table">

				<thead class="thead-light">
					<tr>
						<th>STT</th>
						<th>Tên sản phẩm</th>
						<th><select class="form-control"
							id="exampleFormControlSelect1">
								<option>Loại sản phẩm</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select></th>
						<th><select class="form-control"
							id="exampleFormControlSelect1">
								<option>Xuất Xứ</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select></th>
						<th><select class="form-control"
							id="exampleFormControlSelect1">
								<option>Thương Hiệu</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select></th>
						<th>Số lượng</th>
						<th></th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${ listSanPham }" var="sanPham"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>${ sanPham.tenSanPham }</td>
							<td>${ sanPham.dongSanPham.loaiSanPham.tenLoaiSanPham }</td>
							<td>${ sanPham.xuatXu }</td>
							<td>${ sanPham.dongSanPham.thuongHieu.tenThuongHieu }</td>
							<td></td>
							<td>
								<%-- <a type="button" class="btn btn-primary table__btn" href="<c:url value='/admin/nha-cung-cap/xem-chi-tiet?id=${ nhaCungCap.maNhaCungCap }' />">Chi tiết</a>
								<a type="button" class="btn btn-warning table__btn" href="<c:url value='/admin/nha-cung-cap/cap-nhat-thong-tin-nha-cung-cap?id=${ nhaCungCap.maNhaCungCap }' />">Sửa</a>
								<a type="button" class="btn btn-danger table__btn" href="<c:url value='/admin/nha-cung-cap/xoa-nha-cung-cap?id=${ nhaCungCap.maNhaCungCap }' />">Xóa</a> --%>

								<input type="button" class="btn btn-primary table__btn"
								value="Chi tiết"
								onclick="location.href='<c:url value='/admin/san-pham/xem-chi-tiet?id=${ sanPham.id }' />'">

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='<c:url value='/admin/san-pham/cap-nhat-thong-tin-san-pham?id=${ sanPham.id }' />'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="location.href='<c:url value='/admin/san-pham/xoa-san-pham?id=${ sanPham.id }' />'">

							</td>
					</c:forEach>

				</tbody>
			</table>

		</div>



	</div>
	<!-- /.container-fluid -->
	Admin page
	<br>
	<p>${ user.userId }</p>
	<p>${ user.email }</p>
	<p>${ user.role }</p>
</body>
</html>