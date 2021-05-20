<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách dòng sản phẩm</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="exampleInputEmail1">Tìm kiếm</label> <input type="text"
						oninput="searchType()" class="form-control" id="txtSearch"
						aria-describedby="emailHelp" placeholder="Nhập tên dòng sản phẩm">
				</div>

				<div class="form-group">
					<select class="form-control" id="cboLoaiSanPham"
						name="cboLoaiSanPham">

						<option value="">Loại sản phẩm</option>

						<c:forEach items="${ listLoaiSanPham }" var="loaiSanPham1">

							<option value="${loaiSanPham1.id}">${loaiSanPham1.tenLoaiSanPham}</option>

						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<select class="form-control"
							id="cboThuongHieu" name="cboThuongHieu">

							<option value="">Thương Hiệu</option>

							<c:forEach items="${ listThuongHieu }" var="thuongHieu">

								<c:if test="${thuongHieu.id == dongSanPham.thuongHieu.id}">
									<option value="${thuongHieu.id}" selected>${thuongHieu.tenThuongHieu}</option>
								</c:if>

								<c:if test="${thuongHieu.id != dongSanPham.thuongHieu.id}">
									<option value="${thuongHieu.id}">${thuongHieu.tenThuongHieu}</option>
								</c:if>

							</c:forEach>
						</select>
				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> <a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/dong-san-pham/them-dong-san-pham'/>">Thêm
						dòng sản phẩm</a>
				</div>
			</div>
		</div>

		<div class="row">

			<table class="table" id="">

				<thead class="thead-light">
					<tr>
						<th>STT</th>
						<th>Mã dòng sản phẩm</th>
						<th>Tên dòng sản phẩm</th>
						<th>Loại sản phẩm</th>
						<th>Thương hiệu</th>
						<th></th>
					</tr>
				</thead>

				<tbody id="tableDongSanPham">

					<c:forEach items="${ listDongSanPham }" var="dongSanPham"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>${ dongSanPham.id }</td>
							<td>${ dongSanPham.tenDongSanPham }</td>
							<td>${ dongSanPham.loaiSanPham.tenLoaiSanPham }</td>
							<td>${ dongSanPham.thuongHieu.tenThuongHieu }</td>
							<td><input type="button" class="btn btn-primary table__btn"
								value="Chi tiết"
								onclick="location.href='<c:url value='/admin/dong-san-pham/chi-tiet-dong-san-pham?id=${ dongSanPham.id }' />'">

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='<c:url value='/admin/dong-san-pham/cap-nhat-dong-san-pham?id=${ dongSanPham.id }' />'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="location.href='<c:url value='/admin/dong-san-pham/xoa-dong-san-pham?id=${ dongSanPham.id }' />'">

							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>



	</div>
	<!-- /.container-fluid -->

	<script src="<c:url value="/static/assets/js/dongsanpham.js"/>"></script>
</body>
</html>