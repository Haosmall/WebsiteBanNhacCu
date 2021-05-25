<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đơn hàng</title>
<link rel="stylesheet" href='<c:url value ="/static/assets/css/ChiTietHoaDon_Admin/ChiTietHoaDon_Admin.css"/>'>
</head>

<body>
	<div class="container-fluid management">

		<div class="wrapper">

			<div class="side_right">
				<div class="address">
					<div class="address_user">

						<h5>Địa chỉ người nhận</h5>
						<p>
							Họ và tên: <b>Trần Hoàng Phúc</b>
						</p>
						<p>
							Địa chỉ: <span>110 Lý Thường Kiệt, Phường 07, Quận Gò Vấp,
								Hồ Chí Minh, Việt Nam</span>
						</p>
						<p>
							Số điện thoại: <span>0984107753</span>
						</p>
					</div>

					<div class="order_detail">
						<h5>Thông tin Hóa đơn</h5>
						<p>
							Mã hóa đơn: <b>A123456789</b>
						</p>
						<p>
							Ngày lập: <span>11-03-2021</span>
						</p>
					</div>
				</div>

				<div class="products_table">
					<table class="table table-hover">

						<tbody>

							<tr>
								<th scope="col" style="width: 5%">STT</th>
								<th scope="col" style="width: 55%">Sản phẩm</th>
								<th scope="col" style="width: 15%">Giá</th>
								<th scope="col" style="width: 10%">Số lượng</th>
								<th scope="col" style="width: 15%">Tạm tính</th>
							</tr>


							<tr>
								<td>1</td>
								<td class="product">
									<div class="product_img">
										<img src="https://kenh14cdn.com/thumb_w/660/2019/1/16/hoatran-7224-1547656903304112276009.jpg" alt="">
									</div>
									<div class="product_name">
										<p>7 Thói Quen Của Bạn Trẻaaâ Thành Đạt (Khổ Lớn) (Tái Bản
											20207 Thói Quen Của Bạn Trẻaaâ Thành Đạt (Khổ Lớn) (Tái Bản
											2020)7 Thói Quen Của Bạn Trẻaaâ Thành Đạt (Khổ Lớn) (Tái Bản
											2020)</p>
									</div>

								</td>
								<td class="price currentPrice">10000000000</td>
								<td class="ammout">2</td>
								<td class="price tempPrice">20000000000</td>
							</tr>



						</tbody>
					</table>


					<p class="totalPrice">
						Tổng thanh toán: <span class="price">0</span>
					</p>

					<hr>

					<h5>Cập nhật trạng thái đơn hàng</h5>

					<div>
						<form class="status_total--price" action="">

							<select class="custom-select">
								<option selected>Chọn trạng thái đơn hàng</option>
								<option value="1">Đang Thực hiện</option>
								<option value="1">Đang giao</option>
								<option value="2">Đã tiếp nhận</option>
								<option value="3">Đã hủy</option>
							</select>
							<button type="submit" class="btn btn-primary">Cập nhật</button>

						</form>
					</div>
				</div>

			</div>
		</div>
	</div>


	</div>



</body>
</html>