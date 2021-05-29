<%@page import="com.websitenhaccu.util.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản của tôi</title>
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/main.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/ThongTinCaNhan/ThongTinCaNhan.css"/>" />

</head>
<body>

	<div class="wrapper">
        <div class="side_left">
            <a class="side_link" href="">
                <div class="item account active ">
                    <i class="fas fa-user-alt"></i>
                    <span>Thông tin tài khoản</span>
                </div>
            </a>

            <a class="side_link" href=".html">
                <div class="item shipments">
                    <i class="fas fa-clipboard-list"></i>
                    <span>Quản lý đơn hàng</span>
                </div>
            </a>
<%-- href="<c:url value="/tai-khoan/thong-tin-tai-khoan"></c:url>" --%>
            <!-- <button type='button' class="side_link"  onclick="doiMatKhau();">
                <div class="item shipments">
                    <i class="fas fa-key"></i>
                    <span>Đổi mật khẩu</span>
                </div>
            </button> -->
        </div>
        <div class="side_right">
        	<button class="btn btn-warning btnSubmit" type="button" onclick="doiMatKhau()">Đổi mật khẩu</button>
            <form:form method="POST" modelAttribute="user">
            	<form:hidden path="userId"/>
                <div class="form-group row">
                    <label for="fullName" class="col-sm-2 col-form-label">Họ và tên</label>
                    <div class="col-sm-10">
                        <%-- <form:input type="text" class="form-control" path="fullName"  /> --%>
                        <form:input type="text" class="form-control" path="fullName"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="soDienThoai" class="col-sm-2 col-form-label">Số điện thoại</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" path="phone" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <form:input type="text" readonly="true" class="form-control" path="email" />
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Địa chỉ</label>
                    <div class="col-sm-10">
                        <select class=" sel_diaChi custom-select col-3" id="tinh">
                            <option selected value="-1">Chọn Tỉnh/ Thành phố</option>
                        </select>
						<form:hidden path="tinhThanhPho"/>
						
                        <select class=" sel_diaChi custom-select col-3" id="huyen">
                            <option selected value="-1">Chọn Huyện/ Quận</option>
                        </select>
                        <form:hidden path="quanHuyen"/>

                        <select class=" sel_diaChi custom-select col-3" id="xa">
                            <option selected value="-1">Chọn Xã/ Phường</option>
                        </select>
                        <form:hidden path="phuongXa"/>

                        <form:input placeholder="Số nhà/tên đường" type="text" class="form-control mt-3" path="diaChi" />
                        <span class="checkDiaChi"></span>
                    </div>

                </div>


                <!-- <div class="form-group row">

                    <div class="col-sm-10 offset-2">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="doiMatKhau">
                            <label class="custom-control-label" for="doiMatKhau">Đổi mật khẩu</label>
                        </div>
                    </div>
                </div>


                <div class="form_doiMatKhau">
                    <div class="form-group row">
                        <label for="fullName" class="col-sm-2 col-form-label">Mật khẩu cũ</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control addAtribute" id="oldpw"
                                placeholder="Nhập mật khẩu cũ">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="fullName" class="col-sm-2 col-form-label">Mật khẩu mới</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control addAtribute" id="newpw"
                                placeholder="Nhập mật khẩu mới">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="fullName" class="col-sm-2 col-form-label">Nhập lại</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control addAtribute" id="confirmpw"
                                placeholder="Nhập lại mật khẩu mới">
                        </div>
                    </div>
                </div> -->

                <button class="btn btn-warning btnSubmit" type="submit">Cập nhật</button>
            </form:form>
            
        </div>
    </div>


	<script src="<c:url value="/static/assets/js/ThongTinCaNhan/ThongTinCaNhan.js"/>"></script>
	<script src="<c:url value="/static/assets/js/diaChi.js"/>"></script>
</body>
</html>