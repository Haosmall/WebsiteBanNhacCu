$(document).ready(function () {
	
	
	new FroalaEditor("#edit");
	var maSP = $('#id').val();
	var url = "http://localhost:8080/WebsiteBanNhacCu/api/san-pham?id="+maSP;
	$.get(url, function (data, status) {
		if (status === "success") {
			$(".fr-element").html(data.moTa);
		}
	});

    const maLoaiSanPham = $('#maLoaiSanPham').val();
    const maThuongHieu = $('#maThuongHieu').val();

    const urlSP = "http://localhost:8080/WebsiteBanNhacCu/api/dong-san-pham?maLoaiSanPham="+maLoaiSanPham+"&maThuongHieu=" + maThuongHieu;
    console.log("urlSP: ", urlSP);

    $.get(urlSP, function (data, status) {


        if (status === "success") {
            console.log("province_id: ", data);
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

$("select").change(function () {
    let optionSelected = $(this).find("option:selected");
    let valueSelected = optionSelected.val();
    let textSelected = optionSelected.text();

    let id = $(this).attr("id");

    if (id === "maLoaiSanPham") {
        const maThuongHieu = $('#maThuongHieu').val();

        const urlSP = "http://localhost:8080/WebsiteBanNhacCu/api/dong-san-pham?maLoaiSanPham="+valueSelected+"&maThuongHieu="+maThuongHieu;
        ;

        $.get(urlSP, function (data, status) {
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

        const urlSP = "http://localhost:8080/WebsiteBanNhacCu/api/dong-san-pham?maLoaiSanPham="+maLoaiSanPham+"&maThuongHieu="+valueSelected;
        ;

        $.get(urlSP, function (data, status) {
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
