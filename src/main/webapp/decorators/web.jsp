<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title /></title>

<%-- <c:set var="pageTitle" value="<dec:title />" /> --%>

<link rel="stylesheet" href="<c:url value="/static/style.css"/>">

<link rel="icon" href="<c:url value="/static/assets/img/logo.png"/>"
	type="image/x-icon">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- font awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" />

<!-- jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<!-- Static style -->
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/index_page/index.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/main.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/footer.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/header.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/index_page/Slider.css"/>">

<dec:head></dec:head>

</head>
<body>
	<!-- header -->
	<div class="container-fluid header">
		<div class="row header__item">

			<div class="col-2 offset-1">
				<a href="<c:url value="/"/>"> <img alt="logo"
					src="<c:url value="/static/assets/img/logo.png"/>" width="60px"
					height="60px"></a>
			</div>


			<div class="col-3">
				<div class="input-group">
					<input type=" text" class="form-control" placeholder="Tìm kiếm"
						aria-label="Recipient's username" aria-describedby="basic-addon2">
					<div class="input-group-append">
						<button type="button" class="btn btn-warning">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</div>

			<div class="col-1">
				<a href='<c:url value = "/gio-hang"/>' class="cart__link"> <i
					class="fas fa-shopping-cart cart__logo"></i> <span>Giỏ hàng</span>
				</a>
			</div>

			<div class="col-2 offset-2">

				<!-- Đã đăng nhập -->
				<sec:authorize access="isAuthenticated()">
					<!-- Role user -->
					<%-- <button type="button" class="btn btn-outline-warning"
						onclick="location.href='<c:url value="/logout"/>'">Đăng
						xuất</button> --%>

					<!-- Nav Item - User Information -->
					<div class="nav-item dropdown no-arrow">
						<a class="nav-link dropdown-toggle cart__link" href="#"
							id="userDropdown" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> <span>${ user.fullName }</span> 
							
							
							<img class="img-profile rounded-circle"
									src="
										<c:choose> 
											<c:when test="${ empty user.hinhAnhBase64}">
												<c:url value='/static/assets/img/undraw_profile.svg'/>
											</c:when>
										  	<c:otherwise>
										  		data:image/jpg;base64,${ user.hinhAnhBase64 }
										  	</c:otherwise>
										</c:choose>
									"
									width="50px" height="50px">
						</a>
						<!-- Dropdown - User Information -->
						<div
							class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
							aria-labelledby="userDropdown">
							<a class="dropdown-item" href="#"> <i
								class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Thông
								tin người dùng
							</a>
							<a class="dropdown-item" href="#"> <i
								class="fas fa-receipt fa-sm fa-fw mr-2 text-gray-400"></i> Đơn hàng của tôi
							</a>
							<!-- Role admin -->
							<sec:authorize access="hasRole('ADMIN')">
								<a class="dropdown-item"
									href="<c:url value="/admin/quan-ly"/>"> <i
									class="fas fa-tools fa-sm fa-fw mr-2 text-gray-400"></i> Quản lý
									website
								</a>
							</sec:authorize>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href='<c:url value="/logout"/>'> <i
								class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
								Đăng xuất
							</a>
						</div>
					</div>

					<%-- <!-- Role admin -->
					<sec:authorize access="hasRole('ADMIN')">
						<button type="button" class="btn btn-outline-warning"
							onclick="location.href='<c:url value="/admin/trang-chu"/>'">Quản
							lý</button>
					</sec:authorize> --%>

				</sec:authorize>

				<!-- Chưa đăng nhập -->
				<sec:authorize access="!isAuthenticated()">
					<button type="button" class="btn btn-outline-warning"
						onclick="location.href='<c:url value="/register"/>'">Đăng
						ký</button>
					<button type="button" class="btn btn-outline-warning"
						onclick="location.href='<c:url value="/login"/>'">Đăng
						nhập</button>
				</sec:authorize>

			</div>

		</div>
	</div>



	<!-- body of page -->
	<div class="body">


		<c:if
			test="${ pageTitle != 'Đăng nhập'and pageTitle != 'Giỏ hàng'  and pageTitle != 'Đăng kí tài khoản' and pageTitle !=  'Quên mật khẩu' and pageTitle !=  'Đổi mật khẩu' and pageTitle != 'Chi tiết sản phẩm'}">

			<!-- Slider and  category -->
			<div class="container slider_caterogies">

				<div class="row">

					<!-- category -->
					<div class="col-2 pl-0 pr-0 ">


						<!-- categories -->
						<div class="categories">

							<div class="category__adjust">
								<div class="item">
									<i class="fas fa-guitar category__icon"></i> 
									<a class="category__name">Danh mục sản phẩm</a>
								</div>
								
								<c:forEach items="${ map }" var="loaiSP">

									<div class="category">
										<div class="item">
											<i class="fas fa-guitar category__icon"></i> <a
												class="category__name"
												href="<c:url value="/danh-sach-san-pham/${ loaiSP.key.id }?page=1"/>">${ loaiSP.key.tenLoaiSanPham }</a>
										</div>

										<div class="sub-category">
											<div class="category-detail">
												<c:forEach items="${ loaiSP.value }" var="thuongHieu">
													<div class="category__line">
														<a
															href="<c:url value="/danh-sach-san-pham/${ loaiSP.key.id }/${ thuongHieu.id }?page=1"/>"><img
															src="data:image/jpg;base64,${thuongHieu.hinhAnhBase64}"
															alt="${ thuongHieu.tenThuongHieu }"></a>

														<p
															onclick="location.href='<c:url value="/danh-sach-san-pham/${ loaiSP.key.id }/${ thuongHieu.id }?page=1"/>'">
															<b>${ thuongHieu.tenThuongHieu }</b>
														</p>
														<hr>
														<c:forEach items="${ dongSanPhams }" var="dongSP">
															<c:if test="${ dongSP.thuongHieu.id eq thuongHieu.id }">
																<c:if test="${ dongSP.loaiSanPham.id eq loaiSP.key.id }">

																	<p
																		onclick="location.href='<c:url value="/danh-sach-san-pham/${ dongSP.id }?page=1"/>'">${ dongSP.tenDongSanPham }</p>

																</c:if>
															</c:if>
														</c:forEach>
													</div>
												</c:forEach>

											</div>
										</div>
									</div>
								</c:forEach>
								
								<div class="category">
										<div class="item">
											<i class="fas fa-guitar category__icon"></i> <a
												class="category__name"
												href="<c:url value="/danh-sach-san-pham/tat-ca?page=1"/>">Tất cả sản phẩm</a>
										</div>
									</div>
							</div>

						</div>
					</div>



					<!-- slider -->
					<div class="col-7 slider ml-2">
						<div class="row">
							<div id="demo" class="carousel slide" data-ride="carousel">

								<!-- Indicators -->
								<ul class="carousel-indicators">
									<li data-target="#demo" data-slide-to="0" class="active"></li>
									<li data-target="#demo" data-slide-to="1"></li>
									<li data-target="#demo" data-slide-to="2"></li>
								</ul>

								<!-- The slideshow -->
								<div class="carousel-inner">
									<div class="carousel-item active">
										<img src="<c:url value='/static/assets/img/slider_1.jpg'/>"
											alt="Los Angeles" width="100%" height="400">
										<div class="carousel-caption">
											<h3>Los Angeles</h3>
											<p>We had such a great time in LA!</p>
										</div>
									</div>
									<div class="carousel-item">
										<img src="<c:url value='/static/assets/img/slider_2.jpg'/>"
											alt="Chicago" width="100%" height="400">
										<div class="carousel-caption">
											<h3>Los Angeles</h3>
											<p>We had such a great time in LA!</p>
										</div>
									</div>
									<div class="carousel-item">
										<img src="<c:url value='/static/assets/img/slider_3.jpg'/>"
											alt="New York" width="100%" height="400">
										<div class="carousel-caption">
											<h3>Los Angeles</h3>
											<p>We had such a great time in LA!</p>
										</div>
									</div>
								</div>

								<!-- Left and right controls -->
								<a class="carousel-control-prev" href="#demo" data-slide="prev">
									<span class="carousel-control-prev-icon"></span>
								</a> <a class="carousel-control-next" href="#demo" data-slide="next">
									<span class="carousel-control-next-icon"></span>
								</a>
							</div>
						</div>
					</div>

					<!-- side -->
					<div class="col ml-2 sider">
						<div class="row">
							<img src="<c:url value='/static/assets/img/slider_1.jpg'/>"
								alt="">
						</div>

						<div class="row">
							<img src="<c:url value='/static/assets/img/slider_2.jpg'/>"
								alt="">
						</div>

						<div class="row">
							<img src="<c:url value='/static/assets/img/slider_3.jpg'/>"
								alt="">
						</div>
					</div>



				</div>
			</div>

		</c:if>
		<dec:body />

		<!-- footer -->
		<div class="container-fluid mt-3">
			<div class="row">
				<div class="footer">
					<div class="logo">
						<img src="<c:url value="/static/assets/img/logo.png"/>" alt="">
					</div>

					<div class="infomation">
						<h4>TRỢ GIÚP</h4>
						<hr>
						<p>Khiếu nại bồi thường</p>
						<p>Hướng dẫn thanh toán</p>
						<p>Hướng dẫn bồi thường</p>
						<p>Câu hỏi thường gặp</p>
					</div>

					<sql:setDataSource var="snapshot" user="sa" password="sapassword"
						driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
						url="jdbc:sqlserver://localhost:1433;databaseName=NhacCu" />
					<sql:query var="result" dataSource="${ snapshot }">SELECT * FROM LienHes;</sql:query>


					<div class="infomation">
						<h4>LIÊN LẠC</h4>
						<hr>
						<c:forEach var="lienHe" items="${ result.rows }">
							<p>Email: ${ lienHe.email }</p>
							<p>Số điện thoại: ${ lienHe.so_dien_thoai }</p>
							<p>Địa chỉ: ${ lienHe.dia_chi }</p>
						</c:forEach>
					</div>

					<div class="infomation">
						<h4>CHÍNH SÁCH</h4>
						<hr>
						<p>Chính sách và quy định chung</p>
						<p>Chính sách bảo mật thông tin</p>
						<p>Chính sách bán hàng và chất lượng h.hóa</p>
						<p>Chính sách Đổi - Trả hàng hóa</p>
						<p>Chính sách vận chuyển, giao nhận h.hóa</p>
						<p>Chính sách Bảo hành sản phẩm</p>
						<p>Chính sách Hỗ trợ trả góp</p>
					</div>
				</div>
			</div>

		</div>




	</div>
	<script src="<c:url value="/static/assets/js/test.js"/>"></script>
	<script src="<c:url value="/static/assets/js/index_page/Slider.js"/>"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
</body>
</html>