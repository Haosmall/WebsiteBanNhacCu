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
					<label for="exampleInputEmail1">&#160;</label> 
					<a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/san-pham/them-san-pham'/>">Thêm
						nhà sản phẩm</a>
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
					<tr>
						<td>1</td>
						<td>Kem bôi trơn</td>
						<td>Durex</td>
						<td>Châu Phi</td>
						<td>Durex</td>
						<td>C12</td>
						<td><button type="button" class="btn btn-primary table__btn">Chi
								tiết</button></td>
					</tr>

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