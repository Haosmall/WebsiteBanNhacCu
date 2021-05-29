<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách quảng cáo</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<!-- <div class="form-group">
					<label for="txtSearch">Tìm kiếm</label> <input type="text"
						 oninput="typeSearch()" class="form-control" id="txtSearch"
						aria-describedby="emailHelp" placeholder="Nhập tên màu">
				</div> -->
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> 
					<a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/quang-cao/them-quang-cao'/>">Thêm quảng cáo</a>
				</div>
			</div>
		</div>

		<div class="row">

			<table class="table">

				<thead class="thead-light">
					<tr>
						<th>STT</th>
						<th>Ảnh</th>
						<th>Ngày thêm</th>
						<th>Link</th>
						<th></th>
					</tr>
				</thead>

				<tbody id="tableLoaiSanPham">

					<c:forEach items="${ quangCaoDTOs }" var="quangCaoDTO"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>
								<img alt="" src="data:image/jpg;base64,${ quangCaoDTO.hinhAnhBase64 }">
							</td>
							<td><fmt:formatDate pattern = "dd-MM-yyyy"  value = "${ quangCaoDTO.ngayThem }" /></td>
							<td>
								<a href="${ quangCaoDTO.link }">${ quangCaoDTO.link }</a>
							</td>
							<td>

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='<c:url value='/admin/quang-cao/cap-nhat-quang-cao?id=${ quangCaoDTO.id }' />'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="location.href='<c:url value='/admin/quang-cao/xoa-quang-cao?id=${ quangCaoDTO.id }' />'">

							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>



	</div>
	<!-- /.container-fluid -->
	<script src='<c:url value = "/static/assets/js/mau.js"/>'></script>
</body>
</html>