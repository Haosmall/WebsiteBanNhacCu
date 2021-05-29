<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/index_page/Slider.css"/>">
	
	
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/index_page/index.css"/>">

</head>
<body>

		
		<!-- Slider and  category -->
			<div class="container slider_caterogies">

				<div class="row">

					<!-- category -->
					<div class="col-2 pl-0 pr-0 ">


						<!-- categories -->
						<div class="categories">

							<div class="category__adjust">
								<div class="item">

									<i class="fas fa-bars category__icon"></i> <a
										class="category__name">Danh mục sản phẩm</a>
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
											href="<c:url value="/danh-sach-san-pham/tat-ca?page=1"/>">Tất
											cả sản phẩm</a>
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
										<a href="${ quangCaoDTOs.get(0).link }">
											<img src="data:image/jpg;base64,${ quangCaoDTOs.get(0).hinhAnhBase64 }"
											alt="" width="100%" height="400">
										</a>
										<!-- <div class="carousel-caption">
											<h3>LA</h3>
											<p>We had such a great time in LA!</p>
										</div> -->
									</div>
									<div class="carousel-item">
										<a href="${ quangCaoDTOs.get(1).link }">
											<img src="data:image/jpg;base64,${ quangCaoDTOs.get(1).hinhAnhBase64 }"
												alt="Chicago" width="100%" height="400">
										</a>
										<!-- <div class="carousel-caption">
											<h3>Los Angeles</h3>
											<p>We had such a great time in LA!</p>
										</div> -->
									</div>
									<div class="carousel-item">
										<a href="${ quangCaoDTOs.get(2).link }">
											<img src="data:image/jpg;base64,${ quangCaoDTOs.get(2).hinhAnhBase64 }"
											alt="New York" width="100%" height="400">
										</a>
										<!-- <div class="carousel-caption">
											<h3>Los Angeles</h3>
											<p>We had such a great time in LA!</p>
										</div> -->
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
								<img src="data:image/jpg;base64,${ quangCaoDTOs.get(3).hinhAnhBase64 }" alt="">
						</div>

						<div class="row">
						
							<img src="data:image/jpg;base64,${ quangCaoDTOs.get(4).hinhAnhBase64 }"
								alt="">
						</div>

						<div class="row">
							<img src="data:image/jpg;base64,${ quangCaoDTOs.get(5).hinhAnhBase64 }"
								alt="">
						</div>
					</div>



				</div>
			</div>
		

        <!-- Sản phẩm nổi bật -->
        <div class="container  mt-3 best_sell_product">

            <!-- Chổ này load lên 5 10 hoặc 15 sản phẩm cho nó full dòng -->
            <h2 class="product__title ">SẢN PHẨM NỔI BẬT</h2>



            <div class="row pl-0 pr-0 list__product--sell">
                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" style="object:fit-contain;backgr" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>


            </div>





        </div>

        <!-- Row logo -->
        <div class="container mt-3 mb-3 container__brand">
            <div class="row list__brand">
                <a href=""><img class="brand--img" src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt=""></a>
                <a href=""><img class="brand--img" src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt=""></a>
                <a href=""><img class="brand--img" src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt=""></a>
                <a href=""><img class="brand--img" src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt=""></a>

            </div>
        </div>


        <!-- Sản phẩm bán chạy -->

        <div class="container mt-2 best_sell_product">

            <!-- Chổ này load lên 5 10 hoặc 15 sản phẩm cho nó full dòng -->
            <h2 class="product__title">SẢN PHẨM BÁN CHẠY</h2>



            <div class="row pl-0 pr-0 list__product--sell">
                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>

                <div class="product">
                    <div class="product__img">
                        <img src="<c:url value='/static/assets/img/slider_2.jpg'/>" alt="">
                    </div>
                    <p class="product__name"><b>Đàn guitar rexona yamaha</b></p>

                    <div class="additional">
                        <p>Thương hiệu: <b>Small</b></p>
                        <p>Xuất xứ: <b>Ý</b></p>
                    </div>

                    <p class="money">123000000 VND</p>
                    <div class="start-ratting">
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star checked"></span>
                        <span class="fa fa-star"></span>
                    </div>
                </div>



            </div>
		
		<!-- Slider đàn sản phẩm tùy chọn(Đàn trống) -->
		<div class="container mt-3 product__options highlight">

            <div class="row">
                <h2 class="product__title__slider">Trống</h2>
                <div class="product__list--wrapper">
                    <div class="product__option__list" style="transform: translateX(-1140px);">

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>


                    </div>
                    <i class="fas fa-chevron-right move arrow"></i>
                    <i class="fas fa-chevron-left move arrow--left" style="opacity: 0.5;"></i>

                </div>



            </div>

        </div>
        
        <!-- ------------------------ -->
		
		<div class="container mt-3 mb-2 product__options highlight">

            <div class="row">
                <h2 class="product__title__slider">KÈN</h2>
                <div class="product__list--wrapper">
                    <div class="product__option__list">

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>

                        <div class="option__item">
                            <div class="option__item__img">
                                <img src="<c:url value='/static/assets/img/yamaha_logo.png'/>" alt="">
                            </div>
                            <p class="option__item__name"><b>Đàn guitar rexona yamaha</b></p>

                            <div class="option__item__additional">
                                <p>Thương hiệu: <b>Small</b></p>
                                <p>Xuất xứ: <b>Ý</b></p>
                            </div>
                            <p class="option__item__money">123000000 VND</p>
                        </div>


                    </div>
                    <i class="fas fa-chevron-right move arrow"></i>
                    <i class="fas fa-chevron-left move arrow--left"></i>

                </div>

            </div>

        </div>


        </div>
</body>
</html>