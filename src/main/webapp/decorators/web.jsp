<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title /></title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" />

    <!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    <!-- Static style -->
    <link rel="stylesheet" href="<c:url value="/static/assets/css/index_page/index.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/footer.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/assets/css/header.css"/>">


</head>
<body>
	<!-- header -->
    <div class="container-fluid header">
        <div class="row header__item">

            <div class="col-2 offset-1">
                <a href="./test.html">LOGO</a>
            </div>


            <div class="col-3">
                <div class="input-group">
                    <input type=" text" class="form-control" placeholder="Tìm kiếm" aria-label="Recipient's username"
                        aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button type="button" class="btn btn-warning"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </div>


            <div class="col-2 offset-2">
                <button type="button" class="btn btn-outline-warning">Đăng ký</button>
                <button type="button" class="btn btn-outline-warning">Đăng nhập</button>
                <button type="button" class="btn btn-outline-warning"><a href='<c:url value="/logout"/>'>Đăng xuất</a></button>

            </div>

            <div class="col-1">
                <a href="#" class="cart__link">
                    <i class="fas fa-shopping-cart cart__logo"></i>
                    <span>Giỏ hàng</span>
                </a>
            </div>


        </div>
    </div>



    <!-- body of page -->
    <div class="body">
		
		<dec:body />
		
        <!-- footer -->
        <div class="container-fluid mt-3">
            <div class="row">
                <div class="footer">
                    <div class="logo">
                        <img src="<c:url value="/static/assets/img/logo_vinfast.png"/>" alt="">
                    </div>

                    <div class="infomation">
                        <h4>TRỢ GIÚP</h4>
                        <hr>
                        <p>Khiếu nại bồi thường</p>
                        <p>Hướng dẫn thanh toán</p>
                        <p>Hướng dẫn bồi thường</p>
                        <p>Câu hỏi thường gặp</p>
                    </div>

                    <div class="infomation">
                        <h4>LIÊN LẠC</h4>
                        <hr>
                        <p> Gọi mua hàng: 1800.2097 (8h00 - 22h00)</p>
                        <p> Gọi khiếu nại: 1800.2063 (8h00 - 21h30)</p>
                        <p>Gọi bảo hành: 1800.2064 (8h00 - 21h00)</p>
                    </div>

                    <div class="infomation">
                        <h4>CHÍNH SÁCH</h4>
                        <hr>
                        <p>Chính sách và quy định chung</p>
                        <p> Chính sách bảo mật thông tin </p>
                        <p>Chính sách bán hàng và chất lượng h.hóa</p>
                        <p>Chính sách Đổi - Trả hàng hóa</p>
                        <p>Chính sách vận chuyển, giao nhận h.hóa</p>
                        <p>Chính sách Bảo hành sản phẩm</p>
                        <p>Chính sách Hỗ trợ trả góp

                        </p>
                    </div>
                </div>
            </div>

        </div>




    </div>
	
</body>
</html>