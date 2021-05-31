<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle}</title>
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/Product_page/ProductPage.css"/>">


<style type="text/css">
.partition_price {
	margin-top: 10px;
	height: 110px;
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	display: flex;
	height: 110px;
}

.partition_price--layout {
	display: flex;
	justify-content: space-between;
}

.partition_price--layout input {
	width: 75px;
	border-radius: 3px;
	border: 1px solid #e6e6e6;
	outline: none;
}

.partition_price button {
	font-weight: 500;
	color: #fff;
	background-color: orange;
	outline: none;
	border: 1px solid orange;
	border-radius: 3px;
}
</style>


</head>

<body>


	<div class="container wrapper mt-3">

		<div class="row wrapper__title pt-3">
			<h2 class="col offset-2">Đàn Guitar Electric</h2>
		</div>

		<div class="row wrapper__listProduct">

			<!-- Left Side (tìm kiếm) -->
			<div class="col-2  wrapper__listProduct__leftSide">


				<div class="partition_price">
					<b>Khoảng giá</b>
					<div class="partition_price--layout">
						<input placeholder="Từ " /> <span>-</span> <input
							placeholder="đến " />

					</div>
					<button>Áp dụng</button>

				</div>




				<div class="boxSearch">
					<div class="item__title">Loại nhạc cụ</div>

					<div class="itemSearch">
						<c:forEach items="${ loaiSanPhams }" var="loaiSanPham">
							<input type="checkbox" value="${ loaiSanPham.id }"
								onchange="console.log(1233123)" />
							<span>${ loaiSanPham.tenLoaiSanPham }</span>
							<br>
						</c:forEach>
					</div>
				</div>

				<div class="boxSearch">
					<div class="item__title">Thương hiệu</div>

					<div class="itemSearch">
						<c:forEach items="${ thuongHieus }" var="thuongHieu">
							<input type="checkbox" value="${ thuongHieu.id }"
								onchange="console.log(1233123)" />
							<span>${ thuongHieu.tenThuongHieu }</span>
							<br>
						</c:forEach>
					</div>
				</div>

				<div class="boxSearch">
					<div class="item__title">Dòng nhạc cụ</div>

					<div class="itemSearch">
						<c:forEach items="${ dongSanPhams }" var="dongSanPham">
							<input type="checkbox" value="${ dongSanPham.id }"
								onchange="console.log(1233123)" />
							<span>${ dongSanPham.tenDongSanPham }</span>
							<br>
						</c:forEach>
					</div>
				</div>

				<div class="boxSearch">
					<div class="item__title">Xuất xứ</div>

					<div class="itemSearch">
						<c:forEach items="${ xuatXus }" var="xuatXu">
							<input type="checkbox" value="${ xuatXu }"
								onchange="console.log(1233123)" />
							<span>${ xuatXu }</span>
							<br>
						</c:forEach>
					</div>
				</div>





			</div>


			<!-- Right side (ds sản phẩm) -->

			<div class="col-10 wrapper__listProduct__rightSide">



				<div class="row">

					<div class="nav__list">
						<a href="" class="nav__list--index checked--popular ">Tất cả</a>
						<div class="bar bar--popular active"></div>

						<a href="" class="nav__list--index checked--selling">Bán chạy</a>
						<div class="bar bar--selling"></div>

						<div class="" style="position: absolute; right: 0;">
							<div class="input-group ">
								<select class="custom-select" id="inputGroupSelect">
									<option selected>Sắp xếp theo giá</option>
									<option value="1"><a href="">Tăng dần</a></option>
									<option value="1"><a href="accbcc">Giảm dần</a></option>
								</select>
							</div>
						</div>



					</div>

					<div class="product__list">

						<c:forEach items="${ sanPhamDTOs }" var="sanPhamDTO">
							<div class="product"
								onclick="location.href = '/WebsiteBanNhacCu/san-pham?id=${ sanPhamDTO.id }'">
								<div class="product__img">
									<c:choose>
										<c:when test="${ !empty sanPhamDTO.hinhAnhBase64 }">
											<img
												src="data:image/jpg;base64,${ sanPhamDTO.hinhAnhBase64 }"
												alt="">
										</c:when>
										<c:otherwise>
											<img src="<c:url value='/static/assets/img/slider_2.jpg'/>"
												alt="">
										</c:otherwise>
									</c:choose>
								</div>
								<p class="product__name">
									<b>${ sanPhamDTO.tenSanPham }</b>
								</p>

								<div class="additional">
									<p>
										Thương hiệu: <b>${ sanPhamDTO.tenThuongHieu }</b>
									</p>
									<p>
										Xuất xứ: <b>${ sanPhamDTO.xuatXu }</b>
									</p>
								</div>

								<p class="money">
									<fmt:formatNumber type="currency"
										value="${ sanPhamDTO.giaBan }" currencySymbol="" />
									VNĐ
								</p>
								<div class="start-ratting">
									<span class="fa fa-star checked"></span> <span
										class="fa fa-star checked"></span> <span
										class="fa fa-star checked"></span> <span
										class="fa fa-star checked"></span> <span class="fa fa-star"></span>
								</div>
							</div>
						</c:forEach>

					</div>




				</div>


			</div>

		</div>
		<div class="page d-flex justify-content-center">
			<ul class="pagination ">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</div>


	</div>

	<script>
		const overlay = $(".overlay");
		const menu_div = $(".menu_div");

		menu_div.mouseenter(function(e) {
			overlay.css({
				"display" : "block"
			});
		})

		menu_div.mouseleave(function(e) {
			overlay.css({
				"display" : "none"
			});
		})
	</script>
</body>
</html>