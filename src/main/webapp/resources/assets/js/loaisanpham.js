function typeSearch() {
	var searchText = document.getElementById("txtSearch").value;
	const url = `http://localhost:8080/WebsiteBanNhacCu/api/loai-san-pham/danh-sach?tenLoaiSanPham=${searchText}`;

	$.get(url, function (data, status) {
		$("#tableLoaiSanPham").html("");
		for (var i = 0; i < data.length; i++) {
			$("#tableLoaiSanPham").append(
				`<tr>
				<td>${ i+1 }</td>
				<td>${ data[i].id }</td>
				<td>${ data[i].tenLoaiSanPham }</td>
				<td>

					<input type="button" class="btn btn-primary table__btn"
					value="Chi tiết"
					onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/chi-tiet-loai-san-pham?id=${ data[i].id }'">

					<input type="button" class="btn btn-warning table__btn"
					value="Sửa"
					onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/cap-nhat-loai-san-pham?id=${ data[i].id }'">

					<input type="button" class="btn btn-danger table__btn"
					value="Xóa"
					onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/xoa-loai-san-pham?id=${ data[i].id }'">

				</td>
			</tr>`
			);
		}
	});
}
