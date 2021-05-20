function typeSearch() {
	var searchText = document.getElementById("txtSearch").value;
	const url = `http://localhost:8080/WebsiteBanNhacCu/api/thuong-hieu/danh-sach?tenThuongHieu=${searchText}`;

	$.get(url, function (data, status) {
		console.log(data)
		$("#tableThuongHieu").html("");
		for (var i = 0; i < data.length; i++) {
			$("#tableThuongHieu").append(
				`<tr>
				<td>${ i+1 }</td>
				<td>${ data[i].id }</td>
				<td><c:if test="${data[i].hinhAnhBase64 != null}">
						<img src="data:image/jpg;base64,${data[i].hinhAnhBase64}"
							width="120" height="80" />
					</c:if></td>
				<td>${ data[i].tenThuongHieu }</td>
				<td><input type="button" class="btn btn-primary table__btn"
					value="Chi tiết"
					onclick="location.href='/WebsiteBanNhacCu/admin/thuong-hieu/chi-tiet-thuong-hieu?id=${ data[i].id }'">

					<input type="button" class="btn btn-warning table__btn"
					value="Sửa"
					onclick="location.href='/WebsiteBanNhacCu/admin/thuong-hieu/cap-nhat-thuong-hieu?id=${ data[i].id }'">

					<input type="button" class="btn btn-danger table__btn"
					value="Xóa"
					onclick="location.href='/WebsiteBanNhacCu/admin/thuong-hieu/xoa-thuong-hieu?id=${ data[i].id }'">

				</td>
			</tr>`
			);
		}
	});
}
