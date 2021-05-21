<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>




<link rel="stylesheet" href='<c:url value = "/static/assets/css/Cart/Cart.scss"/>'>


<body>

	<div class="container">

		<div class="alert alert-danger alert--block fade show fixed-top  "
			role="alert">

			<button type="button" class="close" data-dismiss="alert">&times;</button>
			Sản phẩm không đủ số lượng, hoặc nhập giá trị không hợp lệ
		</div>

		<h5>GIỎ HÀNG (3 sản phẩm)</h5>
		<div class="wrapper_cart">
			<div class="cart">

				<div class="element_cart">

					<input type="checkbox" class="form-check-input" value="check">
					<div class="img_element">
						<img src="../asset/image/slider_1.jpg" alt="">
					</div>

					<div class="name_a_delete">
						<span>Bộ Dưỡng Chất Khoáng Phục Hồi Chuyên Sâu Mineral 89
							30ml Và Mặt Nạ Ngủ Aqualia 15ml</span>
						<button class="btn btn-danger delete--sp">Xóa sản phẩm</button>
					</div>

					<span class="price">20000000</span>

					<div class="interact">
						<button class="minus">-</button>
						<input type="text" value="1" class="count"> <input
							type="hidden" value="10" class="maxCount">
						<button class="plus" data-dismiss="alert">+</button>
					</div>

				</div>

				<div class="element_cart">

					<input type="checkbox" class="form-check-input" value="check">
					<div class="img_element">
						<img src="../asset/image/slider_1.jpg" alt="">
					</div>

					<div class="name_a_delete">
						<span>Bộ Dưỡng Chất Khoáng Phục Hồi Chuyên Sâu Mineral 89
							30ml Và Mặt Nạ Ngủ Aqualia 15ml</span>
						<button class="btn btn-danger delete--sp">Xóa sản phẩm</button>
					</div>

					<span class="price">20000000</span>

					<div class="interact">
						<button class="minus">-</button>
						<input type="text" value="3" class="count"> <input
							type="hidden" value="10" class="maxCount">
						<button class="plus">+</button>
					</div>

				</div>

				<div class="element_cart">

					<input type="checkbox" class="form-check-input" value="check">
					<div class="img_element">
						<img src="../asset/image/slider_1.jpg" alt="">
					</div>

					<div class="name_a_delete">
						<span>Bộ Dưỡng Chất Khoáng Phục Hồi Chuyên Sâu Mineral 89
							30ml Và Mặt Nạ Ngủ Aqualia 15ml</span>
						<button class="btn btn-danger delete--sp">Xóa sản phẩm</button>
					</div>

					<span class="price">20000000</span>

					<div class="interact">
						<button class="minus">-</button>
						<input type="text" value="2" class="count"> <input
							type="hidden" value="10" class="maxCount">
						<button class="plus">+</button>
					</div>

				</div>






			</div>



			<div class="personel_info">


				<div class="address">
					<div class="address_getProduct">
						<b>Địa chỉ nhận hàng</b> <a href="#" data-toggle="modal"
							data-target="#myModal">Thay đổi</a>
					</div>
					<p class="inf_per">Trần Hoàng Phúc | 0984107753</p>
					<p class="inf_ad">110 Lý Thường Kiệt, Phường 7, Gò Vấp, TP.HCM</p>
				</div>
				<hr>

				<div class="calculate">
					<span>Thành Tiền</span> <span id="totalPrice">8000000</span>

				</div>

				<button class="btn btn-danger">Tiến hàng đặt hàng</button>
			</div>

		</div>






	</div>



	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Thay đổi địa chỉ nhận hàng</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<form action="">
						<div class="form-group">
							<label for="tinh_thanhpho">Tỉnh/Thành Phố</label> <select
								class="form-control" id="tinh_thanhpho">
								<option value=-1>Tỉnh/Thành Phố</option>
							</select>
						</div>
					<%-- 	<form:hidden path="tinhThanhPho" /> --%>

						<div class="form-group">
							<label for="huyen_quan">Huyện/Quận</label> <select
								class="form-control" id="huyen_quan">
								<option value=-1>Huyện/Quận</option>
							</select>
						</div>
					<%-- 	<form:hidden path="quanHuyen" />< --%>

						<div class="form-group">
							<label for="xa_phuong">Xã/Phường</label> <select
								class="form-control" id="xa_phuong">
								<option value=-1>Xã/Phường</option>
							</select>
						</div>
					<%-- 	<form:hidden path="phuongXa" /> --%>

						<div class="form-group">
							<label for="sonha_tentruong">Số nhà/tên đường</label> <input
								type="text" class="form-control" id="sonha_tentruong"
								placeholder="Số nhà tên đường">
						</div>

						<button class="btn btn-primary">Thay đổi</button>
					</form>

				</div>




			</div>
		</div>
	</div>



	<script src="../asset/js/Address.js"></script>
	<script src="../asset/js/Cart/Cart.js"></script>


</body>
</html>