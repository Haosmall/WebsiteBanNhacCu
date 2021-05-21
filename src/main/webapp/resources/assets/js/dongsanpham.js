const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'api/dong-san-pham/danh-sach'

function searchType() {
	var searchText = document.getElementById("txtSearch").value;
	var cboLoaiSanPham = document.getElementById("cboLoaiSanPham").value;
	var cboThuongHieu = document.getElementById("cboThuongHieu").value;
	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenDongSanPham=${searchText}&maLoaiSanPham=${cboLoaiSanPham}&maThuongHieu=${cboThuongHieu}`;

	$.get(url, function (data, status) {
		$("#tableDongSanPham").html("");
		for (var i = 0; i < data.length; i++) {
			$("#tableDongSanPham").append(
				`<tr>
							<td>${i+1}</td>
							<td>${data[i].id}</td>
							<td>${data[i].tenDongSanPham}</td>
							<td>${data[i].loaiSanPham}</td>
							<td>${data[i].thuongHieu}</td>
							<td><input type="button" class="btn btn-primary table__btn"
								value="Chi tiết"
								onclick="location.href='/WebsiteBanNhacCu/admin/dong-san-pham/chi-tiet-dong-san-pham?id=${data[i].id}'">

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='/WebsiteBanNhacCu/admin/dong-san-pham/cap-nhat-dong-san-pham?id=${data[i].id}'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="location.href='/WebsiteBanNhacCu/admin/dong-san-pham/xoa-dong-san-pham?id=${data[i].id}'">

							</td>
						</tr>`
			);
		}
	});
}

$("select").change(function () {
    let optionSelected = $(this).find("option:selected");
    let valueSelected = optionSelected.val();

    let id = $(this).attr("id");

    if (id === "cboLoaiSanPham") {
        searchType();
    }

    if (id === "cboThuongHieu") {
        searchType();
    }
});