const capNhat = $("#btnCapNhat");


$(document).ready(function () {
    
});

$("#btnCapNhat").click(function(){
	
	let maDonHang = $("#maHoaDon").val();
	let optionSelected = $('#trangThai').find("option:selected");
	let trangThai = optionSelected.val();
	capNhatTrangThai(maDonHang, trangThai);
	
})


capNhatTrangThai = (maDonHang, trangThai) => {
	
	$.ajax({
	    url: apiFetch = "http://localhost:8080/WebsiteBanNhacCu/api/hoa-don/cap-nhat-trang-thai?maDonHang=" + maDonHang + "&trangThai=" + trangThai,
	    type: 'GET',
	    success: function(result) {
	    		alert("Cập nhật trạng thái thành công");
	    },
	    error: function() {
	    		alert('Cập nhật trạng thái không thành công');
		},
	});
}

