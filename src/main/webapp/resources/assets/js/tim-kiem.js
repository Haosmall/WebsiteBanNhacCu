let loais = [];
let thuongHieus = [];
let dongSanPhams = [];
let xuatXus = [];
let giaDau = 0;
let giaCuoi = 0;
let page = 1;
let sort = 1;
let SearchTenSanPham = '';

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

$("#giaDau").change(function () {
	if ($("#giaDau").val() != "") {
		giaDau = $("#giaDau").val();
	} else {
		giaDau = 0;
	}
});

$("#giaCuoi").change(function () {
	if ($("#giaCuoi").val() != "") {
		giaCuoi = $("#giaCuoi").val();
	} else {
		giaCuoi = 0;
	}
});

$("#btnApDung").click((e) => {
	page = 1;
	timKiem("http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham?page=" + page);
	//	e.preventDefault();
});


function timKiem(callUrl) {
	const dataTimKiem = { SearchTenSanPham, xuatXus, giaDau, giaCuoi, dongSanPhams, thuongHieus, loais, sort, page };

	const query = jQuery.param(dataTimKiem).replaceAll('%5B%5D', '');

	const url = `http://localhost:8080/WebsiteBanNhacCu/api/san-pham/tim-kiem?${query}`;
	console.log("url: " + url);

	$.get(url, function (data) {
		// window.history.pushState("object or string", "Title", "http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham?page=" + page);
		if (data.length > 0) {
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
					+ '<img src="data:image/jpg;base64, ' + data[i].hinhAnhBase64 + '" alt="">'
					+ '</div> <p class="product__name"> <b>' + data[i].tenSanPham + '</b></p>'
					+ '<div class="additional">'
					+ '<p> Thương hiệu: <b>' + data[i].tenThuongHieu + '</b></p>'
					+ '<p> Xuất xứ: <b>' + data[i].xuatXu + '</b></p>'
					+ '</div><p class="money">' + formatter.format(data[i].giaBan).replaceAll('$', '') + ' VNĐ</p></div>'
				);
			}
			var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
			viewPage.value = page; //gan lai  hien thi trang hien tai
			flagPageBefore = page;
			console.log("TRUE---------page " + page + "=====bfire: " + flagPageBefore);
			window.history.pushState("object or string", "Title", callUrl);
		}
		else {
			console.log("page " + page + "=====bfire: " + flagPageBefore);
			page = flagPageBefore;
		}
	});
}
let flagPageBefore;

function redirectNext() {
	const PAGE_PATH = window.location.pathname;
	if (PAGE_PATH.includes("LSP") && !PAGE_PATH.includes("TH")) {
		var maLoai = PAGE_PATH.split("/")[3].split("?")[0];
		loais.push(maLoai);

		SearchTenSanPham = '';
		thuongHieus = [];
		dongSanPhams = [];
		xuatXus = [];

		flagPageBefore = page;
		page++;
		timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/${maLoai}?page=` + page);
	}
	else if (PAGE_PATH.includes("TH") && !PAGE_PATH.includes("LSP")) {
		var maTH = PAGE_PATH.split("/")[3].split("?")[0];
		thuongHieus.push(maTH);

		SearchTenSanPham = '';
		loais = [];
		dongSanPhams = [];
		xuatXus = [];

		flagPageBefore = page;
		page++;
		timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/${maTH}?page=` + page);
	}
	else if (PAGE_PATH.includes("DSP")) {
		var maDong = PAGE_PATH.split("/")[3].split("?")[0];
		dongSanPhams.push(maDong);

		SearchTenSanPham = '';
		loais = [];
		thuongHieus = [];
		xuatXus = [];

		flagPageBefore = page;
		page++;
		timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/${maDong}?page=` + page);
	}
	else if (PAGE_PATH.includes("LSP") && PAGE_PATH.includes("TH")) {
		var maLoai = PAGE_PATH.split("/")[3];
		var maTH = PAGE_PATH.split("/")[4].split("?")[0];

		console.log("maloai " + maLoai + "--------maTH " + maTH);

		loais.push(maLoai);
		thuongHieus.push(maTH);

		SearchTenSanPham = '';
		dongSanPhams = [];
		xuatXus = [];

		flagPageBefore = page;
		page++;
		timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/${maLoai}/${maTH}?page=` + page);
	}
	else if (PAGE_PATH.includes("tim-kiem-san-pham")) {

		console.log("file path: "+PAGE_PATH);
		SearchTenSanPham = window.location.href.split("=")[1].split("&")[0];

		loais = [];
		thuongHieus = [];
		dongSanPhams = [];
		xuatXus = [];

		flagPageBefore = page;
		page++;
		timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/tim-kiem-san-pham?tenSanPham=${SearchTenSanPham}&page=` + page);
	}
}

function redirectPrevius() {
	const PAGE_PATH = window.location.pathname;
	if (PAGE_PATH.includes("LSP") && !PAGE_PATH.includes("TH")) {
		if (page > 1) {
			var maLoai = PAGE_PATH.split("/")[3].split("?")[0];
			loais.push(maLoai);

			SearchTenSanPham = '';
			thuongHieus = [];
			dongSanPhams = [];
			xuatXus = [];

			flagPageBefore = page;
			page--;
			timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/${maLoai}?page=` + page);
		}
	}
	else if (PAGE_PATH.includes("TH") && !PAGE_PATH.includes("LSP")) {
		if (page > 1) {
			var maTH = PAGE_PATH.split("/")[3].split("?")[0];
			thuongHieus.push(maTH);

			SearchTenSanPham = '';
			loais = [];
			dongSanPhams = [];
			xuatXus = [];

			flagPageBefore = page;
			page--;
			timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/${maTH}?page=` + page);
		}
	}
	else if (PAGE_PATH.includes("DSP")) {
		if (page > 1) {
			var maDong = PAGE_PATH.split("/")[3].split("?")[0];
			dongSanPhams.push(maDong);

			SearchTenSanPham = '';
			loais = [];
			thuongHieus = [];
			xuatXus = [];

			flagPageBefore = page;
			page--;
			timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/${maDong}?page=` + page);
		}
	}
	else if (PAGE_PATH.includes("LSP") && PAGE_PATH.includes("TH")) {
		if (page > 1) {
			var maLoai = PAGE_PATH.split("/")[3];
			var maTH = PAGE_PATH.split("/")[4].split("?")[0];

			console.log("maloai " + maLoai + "--------maTH " + maTH);

			loais.push(maLoai);
			thuongHieus.push(maTH);

			SearchTenSanPham = '';
			dongSanPhams = [];
			xuatXus = [];

			flagPageBefore = page;
			page--;
			timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/${maLoai}/${maTH}?page=` + page);
		}
	}
	else if (PAGE_PATH.includes("tim-kiem-san-pham")) {
		if (page > 1) {

			SearchTenSanPham = window.location.href.split("=")[1].split("&")[0];

			loais = [];
			thuongHieus = [];
			dongSanPhams = [];
			xuatXus = [];

			flagPageBefore = page;
			page--;
			timKiem(`http://localhost:8080/WebsiteBanNhacCu/danh-sach-san-pham/tim-kiem-san-pham?tenSanPham=${SearchTenSanPham}&page=` + page);
		}
	}
}

$('#tenSanPham').change(
	function () {
		SearchTenSanPham = $('#tenSanPham').val();

	}
);