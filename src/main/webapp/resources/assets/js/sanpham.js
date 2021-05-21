const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'api/dong-san-pham/danh-sach-maloaisanpham-mathuonghieu'

$(document).ready(function() {

	new FroalaEditor("#edit");
	var maSP = $('#id').val();
	var url = "http://localhost:8080/WebsiteBanNhacCu/api/san-pham?id=" + maSP;
	$.get(url, function(data, status) {
		if (status === "success") {
			$(".fr-element").html(data.moTa);
		}
	});

	const maLoaiSanPham = $('#maLoaiSanPham').val();
	const maThuongHieu = $('#maThuongHieu').val();

	const url1 = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?maLoaiSanPham=${maLoaiSanPham}&maThuongHieu=${maThuongHieu}`;

	$.get(url1, function(data, status) {


		if (status === "success") {
			//reset cbb
			$("#maDongSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#maDongSanPham").append(
					'<option value="' +
					data[i].id +
					'">' +
					data[i].tenDongSanPham +
					"</option>"
				);
			}
		}

	});

});

$("select").change(function() {
	let optionSelected = $(this).find("option:selected");
	let valueSelected = optionSelected.val();

	let id = $(this).attr("id");

	if (id === "maLoaiSanPham") {
		const maThuongHieu = $('#maThuongHieu').val();

		const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?maLoaiSanPham=${valueSelected}&maThuongHieu=${maThuongHieu}`;
		;
		$.get(url, function(data, status) {
			const rs = data.results;

			$("#maDongSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#maDongSanPham").append(
					'<option value="' +
					data[i].id +
					'">' +
					data[i].tenDongSanPham +
					"</option>"
				);
			}
		});
	}

	if (id === "maThuongHieu") {
		const maLoaiSanPham = $('#maLoaiSanPham').val();

		const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?maLoaiSanPham=${maLoaiSanPham}&maThuongHieu=${valueSelected}`;
		;

		$.get(url, function(data, status) {
			const rs = data.results;

			$("#maDongSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#maDongSanPham").append(
					'<option value="' +
					data[i].id +
					'">' +
					data[i].tenDongSanPham +
					"</option>"
				);
			}
		});
	}
});


$("body").on("DOMSubtreeModified", ".fr-element", function () {
	var all = $(".fr-element")
		.map(function () {
			return this.innerHTML;
		})
		.get()
		.join();
	console.clear();
	//console.log(all);
	$("#moTa").val(all);
});


const API1 = 'api/san-pham/danh-sach-san-pham/loai/xuat-xu/thuong-hieu'

function typeSearch() {
	var searchText = document.getElementById("txtSearch").value;
	const maLoaiSanPham = $('#cboLoaiSanPham').val();
	const maThuongHieu = $('#cboThuongHieu').val();
	const xuatXu = $('#cboXuatXu').val();

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API1}?tenSanPham=${searchText}&xuatXu=${xuatXu}&maLoaiSanPham=${maLoaiSanPham}&maThuongHieu=${maThuongHieu}`;

    console.log(url)

	$.get(url, function (data, status) {
		console.log(data)

		$("#tableSanPham").html("");
		for (var i = 0; i < data.length; i++) {
			$("#tableSanPham").append(
				`<tr>
                <td>${ i + 1 }</td>
                <td>${ data[i].tenSanPham }</td>
                <td>${ data[i].maLoaiSanPham }</td>
                <td>${ data[i].xuatXu }</td>
                <td>${ data[i].maThuongHieu }</td>
                <td>chua cap nhat</td>
                <td><input type="button" class="btn btn-primary table__btn"
                    value="Chi tiết"
                    onclick="location.href='/${ CONTEXT_PATH }/admin/san-pham/xem-chi-tiet?id=${ data[i].id }'">

                    <input type="button" class="btn btn-warning table__btn"
                    value="Sửa"
                    onclick="location.href='/${ CONTEXT_PATH }/admin/san-pham/cap-nhat-san-pham?id=${ data[i].id }'">

                    <input type="button" class="btn btn-danger table__btn"
                    value="Xóa"
                    onclick="location.href='/${ CONTEXT_PATH }/admin/san-pham/xoa-san-pham?id=${ data[i].id }'">

                </td>
            </tr>`
			);
		}
	});
}

$("select").change(function () {

    let id = $(this).attr("id");

    if (id === "cboLoaiSanPham") {
        typeSearch();
    }

    else if (id === "cboThuongHieu") {
        typeSearch();
    }
    
    else if (id === "cboXuatXu") {
        typeSearch();
    }
});