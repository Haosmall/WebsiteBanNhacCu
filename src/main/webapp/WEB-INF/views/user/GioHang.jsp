<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Giỏ Hàng</title>
<link rel="stylesheet"
	href='<c:url value = "/static/assets/css/Cart/Cart.css"/>'>

</head>

<body>

	<div class="container">

		<div class="alert alert-danger alert--block fade show fixed-top  "
			role="alert">

			<button type="button" class="close" data-dismiss="alert">&times;</button>
			Sản phẩm không đủ số lượng, hoặc nhập giá trị không hợp lệ
		</div>

		<h5>GIỎ HÀNG (${ map.size() } sản phẩm)</h5>
		<div class="wrapper_cart">
			<div class="cart">
				<c:forEach items="${ map }" var="chiTietHoaDon">
					<div class="element_cart">
						
						<!-- <input type="checkbox" class="form-check-input" value="check"> -->
						<div class="img_element">
							<img src="data:image/jpg;base64,${ chiTietHoaDon.key.mauSanPhamDTO.hinhAnhBase64 }" alt="">
						</div>
	
						<div class="name_a_delete">
							<span>${ chiTietHoaDon.value.tenSanPham }</span>
							<span>Màu: ${ chiTietHoaDon.key.mauSanPhamDTO.tenMau }</span>
							<button class="btn btn-danger delete--sp" >Xóa sản phẩm</button>
						</div>
	
						<span class="price"><fmt:formatNumber type = "number" value = "${ chiTietHoaDon.value.giaBan }" /></span>
	
						<div class="interact">
							<button class="minus">-</button>
							<input type="text" value="${ chiTietHoaDon.key.soLuong }" class="count"> <input
								type="hidden" value="${ chiTietHoaDon.key.mauSanPhamDTO.soLuong }" class="maxCount">
							<input type="hidden" value="${chiTietHoaDon.key.mauSanPhamDTO.maSanPham}" class="maSanPham">
							<input type="hidden" value="${chiTietHoaDon.key.mauSanPhamDTO.maMau}" class="maMau">
							<button class="plus" data-dismiss="alert">+</button>
						</div>
	
					</div>
				</c:forEach>

			</div>



			<div class="personel_info">

				<!-- Đã đăng nhập -->
				<sec:authorize access="isAuthenticated()">
					<div class="address">
						<div class="address_getProduct">
							<b>Địa chỉ nhận hàng</b> <a href="#" data-toggle="modal"
								data-target="#myModal">Thay đổi</a>
						</div>
						<p class="inf_per">${user.fullName }|${user.phone}</p>
						<p class="inf_ad">${user.diaChi }, ${user.phuongXa }, ${user.quanHuyen }, ${user.tinhThanhPho }</p>
						<input id = "idUser" type="hidden" value="${user.userId }"/>
						<input id = "diaChiGiaoHang" type="hidden" value="${user.diaChi }, ${user.phuongXa }, ${user.quanHuyen }, ${user.tinhThanhPho }"/>
	
					</div>
				</sec:authorize>

				<sec:authorize access="!isAuthenticated()">
					<div class="address">
						<div class="address_getProduct">
							<b>Đăng nhập tài khoản để đặt hàng</b>
						</div>
					</div>
				</sec:authorize>
				<hr>

				<div class="calculate">
					<span>Thành Tiền</span> <span id="totalPrice">8000000</span>

				</div>

				<button class="btn btn-danger">Tiến hàng đặt hàng</button>
			</div>

		</div>

	</div>


<!-- Đã đăng nhập -->
	<sec:authorize access="isAuthenticated()">
	<!-- The Modal -->
	<div class="modal fade" id="myModal" data-backdrop="static"
		data-keyboard="false">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Thay đổi địa chỉ nhận hàng</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<form action='' id="formSbm" method="post">
						<div class="form-group">
							<label for="tinh">Tỉnh/Thành Phố</label> 
							<select onblur="ktraTinh()" class="form-control" id="tinh">
								<option value='-1'>Tỉnh/Thành Phố</option>
							</select> 
							<span id="checkTinh" class="validate" value=""></span>
						</div>
						<input type="hidden" id="tinhThanhPho" value="${user.tinhThanhPho}" />

						<div class="form-group">
							<label for="huyen">Huyện/Quận</label> 
							<select onblur="ktraHuyen()" class="form-control" id="huyen">
								<option value='-1'>Huyện/Quận</option>
							</select> 
							<span id="checkQuan" class="validate"></span>

						</div>
						<input type="hidden" id="quanHuyen" value="${user.quanHuyen}" />

						<div class="form-group">
							<label for="xa">Xã/Phường</label> 
							<select class="form-control" onblur="ktraXa()" id="xa">
								<option value='-1'>Xã/Phường</option>
							</select> 
							<span id="checkXa" class="validate"></span>
						</div>
						<input type="hidden" id="phuongXa" value="${user.phuongXa}" />


						<div class="form-group">
							<label for="diaChi">Số nhà/tên đường</label> 
							<input onblur="ktraSoNha()" type="text" class="form-control"
								id="diaChi" placeholder="Số nhà tên đường"
								value="${user.diaChi}" /> 
								
								<span id="checkStreet"
								class="validate"></span>

						</div>




						<button type="submit" class="btn btn-primary btnSubmit">Thay
							đổi</button>
					</form>

				</div>




			</div>
		</div>


	</div>

	</sec:authorize>
	<div class="box_confirm">
		<div>Xác nhận thay thay đổi</div>
		<div>
			<button id="no">Hủy</button>
			<button id="yes">Đồng ý</button>
		</div>
	</div>


	<script src='<c:url value = "/static/assets/js/cart/Cart.js"/>'></script>
	<script
		src='<c:url value = "/static/assets/js/cart/CapNhatDiaChiMuaHang.js"/>'></script>

</body>
</html>