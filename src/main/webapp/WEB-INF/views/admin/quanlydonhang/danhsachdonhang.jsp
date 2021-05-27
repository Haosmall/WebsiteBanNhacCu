<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách đơn hàng</title>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/DanhSachHoaDon_Admin/DanhSachHoaDon_Admin.css"/>'>
</head>

<body>

	<div class="container-fluid management">
		<div class="form-group row timkiem">
			<label for="maHoaDon" class="col-2 col-form-label">Tìm mã hóa
				đơn</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="maHoaDon" value="">
			</div>
		</div>

		<table class="table table-hover">


			<tbody>

				<tr>
					<th style="width: 3%">STT</th>
					<th style="width: 10%">Mã đơn hàng</th>
					<th style="width: 25%">
						<div class="test">
							<span>Ngày lập</span> <input class="form-control ngayLap"
								type="date" value="2011-08-19" id="example-date-input">
						</div>
					</th>
					<th style="width: 25%" class="sanPham">Sản phẩm</th>
					<th style="width: 12%">Tổng tiền</th>
					<th style="width: 14%">
						<select class="custom-select">
								<option selected>Trạng thái</option>
								<option value="1">Đang Thực hiện</option>
								<option value="1">Đang giao</option>
								<option value="2">Đã tiếp nhận</option>
								<option value="3">Đã hủy</option>
						</select>
					</th>
					<th style="width: 13%"></th>
				</tr>
				
				<c:forEach items="${ hoaDonDTOs }" var="hoaDonDTO" varStatus="counter">
					<tr>
						<td>${ counter.count }</td>
						<td>${ hoaDonDTO.id }</td>
						<td>
							<fmt:formatDate pattern = "dd-MM-yyyy"  value = "${ hoaDonDTO.ngayLapHD }" />
						</td>
						<td>
							<c:set var="tongTien" value="0"/>
							<c:forEach items="${ hoaDonDTO.chiTietHoaDonDTOs }" var="chiTietHoaDonDTO">
								<p> Sản phẩm: ${ chiTietHoaDonDTO.mauSanPhamDTO.tenSanPham } - Màu: ${ chiTietHoaDonDTO.mauSanPhamDTO.tenMau } - Số lượng: ${ chiTietHoaDonDTO.soLuong }</p>
							</c:forEach>
						</td>
						<td><fmt:formatNumber type = "number" value = "${ hoaDonDTO.tongTien }" /> VNĐ</td>
						<td>${ hoaDonDTO.trangThai }</td>
						<td><button class="btn btn-danger" onclick="chiTietDonHang('${ hoaDonDTO.id }')">Xem chi tiết</button></td>
					</tr>
				
				</c:forEach>

			</tbody>
		</table>

	</div>

<script type="text/javascript">
	function chiTietDonHang(id){
		window.location.href ="http://localhost:8080/WebsiteBanNhacCu/admin/quan-li-don-hang/chi-tiet-don-hang?maDonHang=" + id;
	}
</script>

</body>
</html>