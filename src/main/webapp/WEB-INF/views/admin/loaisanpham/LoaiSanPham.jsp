<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách loại sản phẩm</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="txtSearch">Tìm kiếm</label> <input type="text"
						 oninput="typeSearch()" class="form-control" id="txtSearch"
						aria-describedby="emailHelp" placeholder="Nhập tên loại sản phẩm">
				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> 
					<a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/loai-san-pham/them-loai-san-pham'/>">Thêm
						loại sản phẩm</a>
				</div>
			</div>
		</div>

		<div class="row">

			<table class="table">

				<thead class="thead-light">
					<tr>
						<th>STT</th>
						<th>Mã loại sản phẩm</th>
						<th>Tên loại sản phẩm</th>
						<th></th>
					</tr>
				</thead>

				<tbody id="tableLoaiSanPham">

					<c:forEach items="${ listLoaiSanPham }" var="loaiSanPham"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>${ loaiSanPham.id }</td>
							<td>${ loaiSanPham.tenLoaiSanPham }</td>
							<td>

								<input type="button" class="btn btn-primary table__btn"
								value="Chi tiết"
								onclick="location.href='<c:url value='/admin/loai-san-pham/chi-tiet-loai-san-pham?id=${ loaiSanPham.id }' />'">

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='<c:url value='/admin/loai-san-pham/cap-nhat-loai-san-pham?id=${ loaiSanPham.id }' />'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="location.href='<c:url value='/admin/loai-san-pham/xoa-loai-san-pham?id=${ loaiSanPham.id }' />'">

							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>



	</div>
	<!-- /.container-fluid -->
	<script src='<c:url value = "/static/assets/js/loaisanpham.js"/>'></script>
</body>
</html>