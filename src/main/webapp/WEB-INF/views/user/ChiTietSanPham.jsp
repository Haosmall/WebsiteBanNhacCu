<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<link rel="stylesheet" href="<c:url value="/static/assets/css/ProductDetail/ProductDetail.css"/>"/>
<link rel="stylesheet" href="<c:url value="/static/assets/css/main.css"/>"/>
</head>
<body>

	<div class="container wrapper--top">
			<div class="container body body_product">
				<div class="row main_info">
					<!--slider and image  -->
					<div class="col-4 slider">
						<div class="image">
						
							<c:choose>
	                           <c:when test="${ !empty sanPhamDTO.hinhAnhBase64 }">
	                            	<img src="data:image/jpg;base64,${ sanPhamDTO.hinhAnhBase64 }" alt="">
	                            </c:when>
	                            <c:otherwise>
	                                <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
	                            </c:otherwise>
	                        </c:choose>
						</div>

						<div class="container__slider">
							<div class="slider__image">
								<c:forEach items="${ mauSanPhamDTOs }" var="mauSanPhamDTO">
									<div class="slider__image__frame">
										<img
											src="data:image/jpg;base64,${ mauSanPhamDTO.hinhAnhBase64 }"
											class="slider__image__frame--detail"
											alt=""
										/>
									</div>
								</c:forEach>

							</div>
						</div>

						<i class="fas fa-chevron-right move arrow--right"></i>
						<i class="fas fa-chevron-left move arrow--left"></i>
					</div>

					<div class="col title__product">
						<div class="title">
							<span class="name__product"
								>${ sanPhamDTO.tenSanPham }</span
							>
							<span class="id--sanpham">Mã sản phẩm: </span><span class="id--sanpham" id='maSP'>${ sanPhamDTO.id }</span>
							<span>Thương hiệu: <b class="brand">${ sanPhamDTO.tenThuongHieu }</b></span>
							<div class="start-ratting">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<a href="">8 đánh giá</a>
							</div>

							<span
								>Giá bán:
								<b class="price__product"
									><fmt:formatNumber type = "number" value = "${ sanPhamDTO.giaBan }" /> VNĐ</b
								></span
							>
							<div class="select_color">
									<div class="color selected__color">
										<input type="hidden" value="${ mauSanPhamDTOs.get(0).maMau }">
										<span>${ mauSanPhamDTOs.get(0).tenMau }</span>
									</div>
								<c:forEach items="${ mauSanPhamDTOs }" var="mauSanPhamDTO">
									<c:if test="${ mauSanPhamDTOs.get(0).tenMau !=  mauSanPhamDTO.tenMau }">
										<div class="color">
											<input type="hidden" value="${ mauSanPhamDTO.maMau }">
											<span>${ mauSanPhamDTO.tenMau }</span>
										</div>
									</c:if>
								</c:forEach>
							</div>
						</div>

						<div class="interactive__general--info">
							<div class="interactive">
								<a href="">
									<button class="button--inter mua--ngay" id="btnMuaNgay">
										Mua ngay
									</button>
								</a>

								<a href="">
									<button
										class="button--inter themvao--giohang" id="btnThemVaoGioHang"
									>
										Thêm vào giỏ hàng
									</button>
								</a>
							</div>

							<div class="general--info">
								<table class="table table-striped">
									<tbody>
										<tr>
											<td>Loại nhạc cụ</td>
											<td>${ sanPhamDTO.tenLoaiSanPham }</td>
										</tr>
										<tr>
											<td>Dòng nhạc cụ</td>
											<td>${ sanPhamDTO.tenDongSanPham }</td>
										</tr>
										<tr>
											<td>Năm sản xuất</td>
											<td>${ sanPhamDTO.namSanXuat }</td>
										</tr>
										<tr>
											<td>Xuất xứ</td>
											<td>${ sanPhamDTO.xuatXu }</td>
										</tr>
										<tr>
											<td>Bảo hành</td>
											<td>${ sanPhamDTO.baoHanh } năm</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container info__specific">
			<div class="info">
				${ sanPhamDTO.moTa }
				<div id="gradientback"></div>
				<button
					class="btn btn-outline-danger"
					id="readmore"
					onclick="moreInfo()"
				>
					Xem thêm thông tin <i class="fas fa-caret-down"></i>
				</button>
			</div>
		</div>

		<!-- phần đánh giá -->
		
		<c:set value="0" var="namSao"/>
			<c:set value="0" var="bonSao"/>
			<c:set value="0" var="baSao"/>
			<c:set value="0" var="haiSao"/>
			<c:set value="0" var="motSao"/>
			
			<c:forEach items="${ binhLuans }" var="binhLuan">
				<c:choose>
					<c:when test="${ binhLuan.danhGia == 1 }">
						<c:set value="${ motSao += 1 }" var="motSao"/>
					</c:when>
					<c:when test="${ binhLuan.danhGia == 2 }">
						<c:set value="${ haiSao += 1 }" var="haiSao"/>
					</c:when>
					<c:when test="${ binhLuan.danhGia == 3 }">
						<c:set value="${ baSao += 1 }" var="baSao"/>
					</c:when>
					<c:when test="${ binhLuan.danhGia == 4 }">
						<c:set value="${ bonSao += 1 }" var="bonSao"/>
					</c:when>
					<c:when test="${ binhLuan.danhGia == 5 }">
						<c:set value="${ namSao += 1 }" var="namSao"/>
					</c:when>
				
				</c:choose>
			</c:forEach>

		<h5 class="container title_product_evaluate">
			${ binhLuans.size() } Đánh giá ${ sanPhamDTO.tenSanPham }
		</h5>
		<div class="container evaluate__sendratting">
			<div class="evaluate">
				<div class="block__star">
					<div class="average__star">
						<h4>Sao trung bình</h4>
						<p class="figure__average">
							
						</p>
					</div>

					<div class="stick"></div>

					<div class="user__ratting">
						<div class="user__ratting--sub">
							<span
								>5<span class="fa fa-star checked"></span
							></span>
							<div class="ratting rat"></div>
							<div class="ratting"></div>
							<div class="evaluate--adjust">
								<span class="amount_of_ratting_star">${ namSao }</span>

								<span class="amount_evaluate"> đánh giá</span>
							</div>
						</div>

						<div class="user__ratting--sub">
							<span
								>4<span class="fa fa-star checked"></span
							></span>
							<div class="ratting rat"></div>
							<div class="ratting"></div>
							<div class="evaluate--adjust">
								<span class="amount_of_ratting_star">${ bonSao }</span>

								<span class="amount_evaluate"> đánh giá</span>
							</div>
						</div>

						<div class="user__ratting--sub">
							<span
								>3<span class="fa fa-star checked"></span
							></span>
							<div class="ratting rat"></div>
							<div class="ratting"></div>
							<div class="evaluate--adjust">
								<span class="amount_of_ratting_star">${ baSao }</span>

								<span class="amount_evaluate"> đánh giá</span>
							</div>
						</div>

						<div class="user__ratting--sub">
							<span
								>2<span class="fa fa-star checked"></span
							></span>
							<div class="ratting rat"></div>
							<div class="ratting"></div>
							<div class="evaluate--adjust">
								<span class="amount_of_ratting_star">${ haiSao }</span>

								<span class="amount_evaluate"> đánh giá</span>
							</div>
						</div>

						<div class="user__ratting--sub">
							<span
								>1<span class="fa fa-star checked"></span
							></span>
							<div class="ratting rat"></div>
							<div class="ratting"></div>
							<div class="evaluate--adjust">
								<span class="amount_of_ratting_star">${ motSao }</span>

								<span class="amount_evaluate"> đánh giá</span>
							</div>
						</div>
					</div>

					<!-- <div class="stick"></div> -->

					<div class="button_evaluate" hidden>
						<button class="btn btn-danger sendEvaluate">
							Gửi đánh giá của bạn
						</button>
					</div>
				</div>
			</div>

		</div>

		<!-- comment đánh giá -->
		<div class="cmt__evaluate container">
			<c:forEach items="${ binhLuans }" var="binhLuan">
				<div class="user__cmt">
					<p>
						<b>${ binhLuan.nguoiDung.hoTen }</b><span> || Ngày <fmt:formatDate pattern = "dd-MM-yyyy"  value = "${ binhLuan.ngayBinhLuan }" /></span>
					</p>
					<p>
						<c:forEach begin="1" end="5" varStatus="loop">
						    <span class="fa fa-star <c:if test="${loop.index <= binhLuan.danhGia}">checked</c:if>"></span>
						    
						</c:forEach>
						&nbsp;
						<span>${ binhLuan.binhLuan }</span>
					</p>
				</div>
			</c:forEach>
		</div>

		<button
			class="btn btn-outline-danger btn-morecmt"
			onclick="getMoreComment()"
		>
			Xem thêm đánh giá&nbsp;<i class="fas fa-arrow-right"></i>
		</button>

		<script src="<c:url value="/static/assets/js/ProductDetail_page/UserRatting.js"/>"></script>
		<script src="<c:url value="/static/assets/js/ProductDetail_page/ProductDetail.js"/>"></script>
		<script src="<c:url value="/static/assets/js/ProductDetail_page/Comment.js"/>"></script>
		<script src="<c:url value="/static/assets/js/chi-tiet-san-pham.js"/>"></script>
	
</body>
</html>