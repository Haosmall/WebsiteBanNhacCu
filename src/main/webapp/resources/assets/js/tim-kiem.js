let loais = [];
let thuongHieus = [];
let dongSanPhams = [];
let xuatXus = [];
let giaDau = 0;
let giaCuoi = 0;
let page = 1;
let sort = 1;

$(".loaiSanPham").click(() => {
	loais = [];
	const mang = document.getElementsByClassName("loaiSanPham");
	for (const x of mang) {
		if (x.checked) {
			loais.push(x.value);
		}
	}
});

$(".thuongHieu").click(() => {
	thuongHieus = [];
	const mang = document.getElementsByClassName("thuongHieu");
	for (const x of mang) {
		if (x.checked) {
			thuongHieus.push(x.value);
		}
	}
});

$(".dongSanPham").click(() => {
	dongSanPhams = [];
	const mang = document.getElementsByClassName("dongSanPham");
	for (const x of mang) {
		if (x.checked) {
			dongSanPhams.push(x.value);
		}
	}
});

$(".xuatXu").click(() => {
	xuatXus = [];
	const mang = document.getElementsByClassName("xuatXu");
	for (const x of mang) {
		if (x.checked) {
			xuatXus.push(x.value);
		}
	}
});

$("#inputGroupSelect").on("change", function () {
	sort = this.value;

	timKiem();
});

$("#giaDau").change(function(){
	  if($("#giaDau").val() != ""){
		  giaDau = $("#giaDau").val();
	  }else{
		  giaDau = 0;
	  }
	});

$("#giaCuoi").change(function(){
	if($("#giaCuoi").val() != ""){
		giaCuoi = $("#giaCuoi").val();
	}else{
		giaCuoi = 0;
	}
});

$("#btnApDung").click((e) => {
	page = 1;
	timKiem();
//	e.preventDefault();
});


function timKiem() {
	const dataTimKiem = {xuatXus , giaDau , giaCuoi , dongSanPhams , thuongHieus , loais , sort , page};
	
	const query = jQuery.param(dataTimKiem).replaceAll('%5B%5D', '');

	const url = `http://localhost:8080/WebsiteBanNhacCu/api/san-pham/tim-kiem?${query}`;

	$.get(url, function (data) {
		window.history.pushState("object or string", "Title", "http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham?page="+page);
		$(".product__list").html("");
		const formatter = new Intl.NumberFormat('en-US', {
			  style: 'currency',
			  currency: 'USD',
			  minimumFractionDigits: 2
			})

		for (var i = 0; i < data.length; i++) {
			$(".product__list").append(
				'<div class="product" onclick="chiTietSanPham(\'' + data[i].id + '\')">'
					+ '<div class="product__img">'
					+ '<img src="data:image/jpg;base64, '+ data[i].hinhAnhBase64 + '" alt="">'
					+'</div> <p class="product__name"> <b>'+ data[i].tenSanPham +'</b></p>'
					+'<div class="additional">'
					+'<p> Thương hiệu: <b>'+ data[i].tenThuongHieu +'</b></p>'
					+'<p> Xuất xứ: <b>'+ data[i].xuatXu +'</b></p>'
					+'</div><p class="money">'+ formatter.format(data[i].giaBan).replaceAll('$', '') +' VNĐ</p></div>'
			);
		}
	});
}