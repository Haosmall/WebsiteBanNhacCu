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
	href="<c:url value="/static/assets/css/main.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/footer.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/header.css"/>">
<dec:head></dec:head>


<c:if test="${pageTitle != 'Trang chủ'}">


<link rel="stylesheet"
	href="<c:url value="/static/assets/css/menu/menu.css"/>">
</c:if>

</head>




</head>
<body>
	<!-- header -->
	<div class="overlay"></div>
	<div class="container-fluid header fixed-top">
		<div class="container">


			<div class="row header__item">






				<div class="col-1 menu_div" style="padding: 0">
					<i class="fas fa-list-alt" id="menu"
						style="padding: 0px; font-size: 50px; color: #fff"> </i>

					<c:if test="${ pageTitle != 'Trang chủ' }">

						<div class="container slider_caterogies">


							<div class="categories">

								<div class="category__adjust">

									<div class="category">
										<div class="item">
											<i class="fas fa-guitar category__icon"></i> <a
												class="category__name" href="">Guitar</a>
										</div>
										<div class="sub-category">
											<div class="category-detail">
												<div class="category__line">
													<a href=""><img src="../asset/image/yamaha_logo.png"
														alt=""></a>
													<p>
														<b>Đàn Guitar yamaha</b>
													</p>
													<hr>
													<p>Dòng sản phẩm 1</p>
													<p>Dòng sản phẩm 2</p>
													<p>Dòng sản phẩm 3</p>
													<p>Dòng sản phẩm 4</p>


												</div>
												<div class="category__line">4</div>
												<div class="category__line">4</div>
												<div class="category__line">4</div>
												<div class="category__line">4</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</div>



				<div class="col-2 ">
					<a href="<c:url value="/"/>"> <img alt="logo"
						src="<c:url value="/static/assets/img/logo_team.png"/>"
						style="object-fit: cover; background-position: center center; height: 72px; width: 80%;"></a>
				</div>


				<div class="col-4">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Tìm kiếm"
							aria-label="Recipient's username" aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button type="button" class="btn btn-warning">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="col text-center">
					<a href='<c:url value = "/gio-hang"/>' class="cart__link  "> <i
						class="fas fa-shopping-cart cart__logo"></i> <span>Giỏ hàng</span>
					</a>
				</div>
				<div class="col-3">

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
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-receipt fa-sm fa-fw mr-2 text-gray-400"></i> Đơn
									hàng của tôi
								</a>
								<!-- Role admin -->
								<sec:authorize access="hasRole('ADMIN')">

									<a class="dropdown-item" href="<c:url value="/admin/quan-ly"/>">
										<i class="fas fa-tools fa-sm fa-fw mr-2 text-gray-400"></i>
										Quản lý website

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
	</div>



	<!-- body of page -->
	<div class="body">


		<c:if
			test="${pageTitle == 'Trang chủ' and pageTitle != 'Đăng nhập'and pageTitle != 'Giỏ hàng'  and pageTitle != 'Đăng kí tài khoản' and pageTitle !=  'Quên mật khẩu' and pageTitle !=  'Đổi mật khẩu' and pageTitle != 'Chi tiết sản phẩm'}">

			

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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
</body>
</html>