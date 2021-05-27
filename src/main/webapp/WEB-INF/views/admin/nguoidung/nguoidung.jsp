<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Người dùng</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<label for="txtSearch">Tìm kiếm tên</label> <input type="text"
						oninput="searchType()" class="form-control" id="txtSearch"
						aria-describedby="emailHelp" placeholder="Nhập tên người dùng"/>
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Số điện thoại</label> <input
						type="text" oninput="searchType()" class="form-control"
						id="txtSearchSdt" aria-describedby="emailHelp"
						placeholder="Nhập số điện thoại"/>
				</div>
				
				<div class="form-group">
					<label for="exampleInputEmail1">Email</label> <input
						type="text" oninput="searchType()" class="form-control"
						id="txtSearchEmail" aria-describedby="emailHelp"
						placeholder="Nhập email"/>
				</div>

			</div>

			<div class="col-lg-6"></div>
		</div>

		<div class="row">

			<table class="table" id="">

				<thead class="thead-light">
					<tr>
						<th>STT</th>
						<th>Tên người dùng</th>
						<th>Số điện thoại</th>
						<th>Email</th>
						<th>Địa chỉ</th>
						<th>Trạng thái</th>
						<th></th>
					</tr>
				</thead>

				<tbody id="tableNguoiDung">

					<c:forEach items="${ listKhachHang }" var="nguoiDung"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>${ nguoiDung.fullName }</td>
							<td>${ nguoiDung.phone }</td>
							<td>${ nguoiDung.email }</td>
							<td>${ nguoiDung.tinhThanhPho }</td>
							<td>
								Chưa cập nhật
							</td>
							<td><input type="button" class="btn btn-primary table__btn"
								value="Chi tiết"
								onclick="location.href='<c:url value='/admin/nguoi-dung/chi-tiet-nguoi-dung?id=${ nguoiDung.userId }' />'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="location.href='<c:url value='/admin/nguoi-dung/xoa-nguoi-dung?id=${ nguoiDung.userId }' />'">

							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>



	</div>
	<!-- /.container-fluid -->
	<input type="hidden" id="pageValue" value="${ page + 1}" />

	<div class="form-group row">

		<input class="col-3" type="button" class="form-control"
			id="btnPreviusPage" value="-" /> <input class="col-4" type="text"
			readonly class="form-control" id="viewPage"
			value="${page = page + 1}" /> <input class="col-3" type="button"
			class="form-control" id="btnNext" value="+" />
	</div>
	<script src="<c:url value="/static/assets/js/nguoidung.js"/>"></script>
</body>
</html>