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




<body>

	<div class="container wrapper mt-3">

		<div class="row wrapper__title">
			<h2 class="col offset-2">Đàn Guitar Electric</h2>
		</div>

		<div class="row wrapper__listProduct">

			<!-- Left Side (tìm kiếm) -->
			<div class="col-2  wrapper__listProduct__leftSide">

				<div class="ratting-search">
					<div class="item__title">Đánh giá</div>
					<div class="list_start">

						<a href=""> <span class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span>Từ 5 sao</span>
						</a> <a href=""> <span class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span class="fa fa-star "></span>
							<span>Từ 4 sao</span>
						</a> <a href=""> <span class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span class="fa fa-star "></span>
							<span class="fa fa-star "></span> <span>Từ 3 sao</span>
						</a>

					</div>
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

				<div class="row top--bar">

					<div class="top--bar--left">
						<p>Chọn mức giá:</p>
						<div class="partion--price">
							<a href="">Dưới 3 triệu</a> <a href="">3 - 6 triệu</a> <a href="">Trên
								6 triệu</a>
						</div>
					</div>


					<div class="top--bar--right">
						<div class="input-group mb-3">
							<select class="custom-select" id="inputGroupSelect">
								<option selected>Sắp xếp theo giá</option>
								<option value="1"><a href="">Tăng dần</a></option>
								<option value="1"><a href="accbcc">Giảm dần</a></option>
							</select>
						</div>
					</div>


				</div>


				<div class="row">

					<div class="nav__list">
						<a href="" class="nav__list--index checked--popular ">Phổ biến</a>
						<div class="bar bar--popular active"></div>

						<a href="" class="nav__list--index checked--selling">Bán chạy</a>
						<div class="bar bar--selling"></div>

						<a href="" class="nav__list--index checked--new">Mới nhất</a>
						<div class="bar bar--new"></div>
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

					<div class="page">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</ul>
					</div>


				</div>


			</div>

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