const URL = "https://vapi.vnappmob.com/api/province";

var idTinh = "";
var idHuyen = "";

// get và load dữ liệu tỉnh
$(document).ready(function() {


	const url = "https://vapi.vnappmob.com/api/province/";


	$.get(url, function(data, status) {


		if (status === "success") {


			const rs = data.results;

			for (var i = 0; i < rs.length; i++) {
				$("#tinh").append(
					'<option value="' +
					rs[i].province_id +
					'">' +
					rs[i].province_name +
					"</option>"
				);
			}
		}

		// ====================Callback===================================
		setTimeout(function() {
			// Set selected Tỉnh
			$("#tinh option")
				.filter(function() {

					return $(this).text() == $("#tinhThanhPho").val();
				})
				.prop("selected", true);

			// Get id tỉnh
			var idTinh = $("#tinh").val();


			// Load Dữ liệu Huyện theo tỉnh
			let urlQuanHuyen = `${URL}/district/${idTinh}`;

			$.get(urlQuanHuyen, function(data, status) {
				const rs = data.results;

				$("#xa").html(
					"<option selected value='-1'>Chọn Xã/ Phường</option>"
				);

				for (var i = 0; i < rs.length; i++) {
					$("#huyen").append(
						'<option value="' +
						rs[i].district_id +
						'">' +
						rs[i].district_name +
						"</option>"
					);
				}
			});

			// Set selected Huyện
			setTimeout(function() {
				$("#huyen option")
					.filter(function() {
						return $(this).text() == $("#quanHuyen").val();
					})
					.prop("selected", true);

				// Get id huyện
				var idHuyen = $("#huyen").val();


				// Load Dữ liệu Xã theo Huyện
				let urlPhuongXa = `${URL}/ward/${idHuyen}`;
				$("#xa").html(
					"<option selected value='-1'>Chọn Xã/ Phường</option>"
				);

				$.get(urlPhuongXa, function(data, status) {
					const rs = data.results;


					for (var i = 0; i < rs.length; i++) {
						$("#xa").append(
							'<option value="' +
							rs[i].ward_id +
							'">' +
							rs[i].ward_name +
							"</option>"
						);
					}
				});

				setTimeout(function() {
					$("#xa option")
						.filter(function() {
							return (
								$(this).text() == $("#phuongXa").val()
							);
						})
						.prop("selected", true);

					// Get id xã
					var idXa = $("#xa").val();

				}, 200);
			}, 200);
		}, 200);

		// ================================
	});

	// $("#huyen").html("<option selected >Chọn Huyện/ Quận</option>");
	// $("#xa").html("<option selected >Chọn Xã/ Phường</option>");
	//		


});


// get và load dữ liệu huyện/ quận theo tỉnh/ thành phố
// và xã/ phường theo huyện/ quận
$("select").change(function() {
	let optionSelected = $(this).find("option:selected");
	let valueSelected = optionSelected.val();
	let textSelected = optionSelected.text();

	let id = $(this).attr("id");

	if (id === "tinh") {
		let urlQuanHuyen = `${URL}/district/${valueSelected}`;

		$.get(urlQuanHuyen, function(data, status) {
			const rs = data.results;

			$("#huyen").html(
				"<option selected value='-1'>Chọn Huyện/ Quận</option>"
			);
			$("#xa").html(
				"<option selected value='-1'>Chọn Xã/ Phường</option>"
			);

			for (var i = 0; i < rs.length; i++) {
				$("#huyen").append(
					'<option value="' +
					rs[i].district_id +
					'">' +
					rs[i].district_name +
					"</option>"
				);
			}
		});

		$("#tinhThanhPho").val(textSelected);
		$("#quanHuyen").val("");
		$("#phuongXa").val("");
	}

	if (id === "huyen") {
		let urlPhuongXa = `${URL}/ward/${valueSelected}`;
		$("#xa").html(
			"<option selected value='-1'>Chọn Xã/ Phường</option>"
		);

		$.get(urlPhuongXa, function(data, status) {
			const rs = data.results;

			for (var i = 0; i < rs.length; i++) {
				$("#xa").append(
					'<option value="' +
					rs[i].ward_id +
					'">' +
					rs[i].ward_name +
					"</option>"
				);
			}
		});
		$("#quanHuyen").val(textSelected);
		$("#phuongXa").val("");
	}
	if (id === "xa") {
		$("#phuongXa").val(textSelected);
	}
});



const sonha_tentruong = document.getElementById("sonha_tentruong");
const checkStreet = document.getElementById('checkStreet');

ktraSoNha = () => {
	if (sonha_tentruong.value == -1) {
		checkStreet.innerHTML = "(*) Số nhà/tên đường trống";
		return false;
	} else {
		checkStreet.innerHTML = "";
		return true;
	}
}


const tinh = document.getElementById("tinh");
const checkTinh = document.getElementById('checkTinh');


ktraTinh = () => {
	if (tinh.value == -1) {
		checkTinh.innerHTML = "(*) Tỉnh/Thành Phố trống";
		return false;
	} else {
		checkTinh.innerHTML = "";
		return true;
	}
}


const huyen = document.getElementById("huyen");
const checkQuan = document.getElementById('checkQuan');

ktraHuyen = () => {
	if (huyen.value == -1) {
		checkQuan.innerHTML = "(*) Quận/Huyện trống";
		return false;
	} else {
		checkQuan.innerHTML = "";
		return true;
	}
}


const xa = document.getElementById("xa");
const checkXa = document.getElementById('checkXa');

ktraXa = () => {
	if (xa.value == -1) {
		checkXa.innerHTML = "(*) Xã/Phường trống";
		return false;
	} else {
		checkXa.innerHTML = "";
		return true;
	}
}


const formSbm = $("#formSbm");
const bntYes = $("#yes");
const bntNo = $("#no");
const box_confirm = $(".box_confirm");


console.log(box_confirm);
console.log($('#myModal'));

var trigger = 0;


const HOST_NAME = window.location.hostname;;
const PAGE_PATH = window.location.pathname;
const PORT = window.location.port;
const api = "/api/diachi?";
const idUser = $("#idUser").val();
document.querySelector(".btnSubmit").addEventListener("click", function(event) {


	if (ktraTinh() && ktraHuyen() && ktraXa() && ktraSoNha()) {
		trigger++
		event.preventDefault();
		box_confirm.css({ "visibility": "visible", "opacity": "1", "transform": "translateY(0)" });


		bntYes.click(function(e) {


			let thanhPho = $("#tinh option:selected").text();
			let huyen = $("#huyen option:selected").text();
			let xa = $("#xa option:selected").text();
			let sonha_tentruong = $("#sonha_tentruong").val();
			

			let apiCall = `http://${HOST_NAME}:${PORT}${PAGE_PATH}${api}id=${idUser}thanhPho=${thanhPho}&huyen=${huyen}&xa=${xa}&soNha=${sonha_tentruong}`;

			console.log(apiCall);

			$.post(apiCall, function(data, status) {


			})


			e.preventDefault();





		})

		bntNo.click(function() {
			box_confirm.css({ "visibility": "hidden", "opacity": "0", "transform": "translateY(-30px)" });
		})
	} else {
		event.preventDefault();
	}

});










$(".close").click(function() {
	box_confirm.css({ "visibility": "hidden", "opacity": "0", "transform": "translateY(-30px)" });
})


$('#myModal').modal({ backdrop: 'static', keyboard: false });




