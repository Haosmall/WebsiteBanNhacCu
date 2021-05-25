$('#btnThemVaoGioHang').click(function(e){
	
	
//	$.ajax({
//		url: apiFetch,
//		type: 'GET',
//		success: function() {
//			
//			console.log("đã thêm vào giỏ hàng");
//			
//		},
//		error: function() {
//			console.log("Khoong thanh cong");
//		},
//
//	});
	themSanPham();
	e.preventDefault();
});
$('#btnMuaNgay').click(function(e){
	
	themSanPham();
	e.preventDefault();
	setTimeout(function () {
		window.location.href = "http://localhost:8080/WebsiteBanNhacCu/gio-hang";
	}, 300);
});

themSanPham = () =>{
	var maMau = $(".selected__color input").val();
	var maSanPham = $("#maSP").text();
	console.log(maSanPham);
	var apiFetch = "http://localhost:8080/WebsiteBanNhacCu/api/gio-hang/them-vao-gio-hang?maSanPham=" + maSanPham + "&maMau=" + maMau;
	console.log(apiFetch);

	$.get(apiFetch, function (data, status) {
		setTimeout(function () {
			if (status === 'success') {
				if (data === 1) {
					console.log("Đã thêm vào giỏ hàng");
					toastr.success("Đã thêm vào giỏ hàng");
				}
			}
		}, 500);
	});
}