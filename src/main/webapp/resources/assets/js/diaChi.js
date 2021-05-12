const URL = "https://vapi.vnappmob.com/api/province";

var idTinh = "";
var idHuyen = "";

// get và load dữ liệu tỉnh
$(document).ready(function () {
	
	
		const url = "https://vapi.vnappmob.com/api/province/";
		console.log("url: ", url);
		
		$.get(url, function (data, status) {
			
			
			if (status === "success") {
				console.log("province_id: ", data.results);

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
			setTimeout(function () {
				// Set selected Tỉnh
				$("#tinh option")
					.filter(function () {
						return $(this).text() == $("#tinhThanhPho").val();
					})
					.prop("selected", true);

				// Get id tỉnh
				var idTinh = $("#tinh").val();
				console.log("Tỉnh: " + $("#tinhThanhPho").val());
				console.log("id tỉnh: " + idTinh);

				// Load Dữ liệu Huyện theo tỉnh
				let urlQuanHuyen = `${URL}/district/${idTinh}`;

				$.get(urlQuanHuyen, function (data, status) {
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
				setTimeout(function () {
					$("#huyen option")
						.filter(function () {
							return $(this).text() == $("#quanHuyen").val();
						})
						.prop("selected", true);

					// Get id huyện
					var idHuyen = $("#huyen").val();
					console.log("Huyện: " + $("#quanHuyen").val());
					console.log("id huyện: " + idHuyen);

					// Load Dữ liệu Xã theo Huyện
					let urlPhuongXa = `${URL}/ward/${idHuyen}`;
					$("#xa").html(
						"<option selected value='-1'>Chọn Xã/ Phường</option>"
					);

					$.get(urlPhuongXa, function (data, status) {
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

					setTimeout(function () {
						$("#xa option")
							.filter(function () {
								return (
									$(this).text() == $("#phuongXa").val()
								);
							})
							.prop("selected", true);

						// Get id xã
						var idXa = $("#xa").val();
						console.log("Xã: " + $("#phuongXa").val());
						console.log("id Xã: " + idXa);
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
$("select").change(function () {
	let optionSelected = $(this).find("option:selected");
	let valueSelected = optionSelected.val();
	let textSelected = optionSelected.text();

	let id = $(this).attr("id");

	if (id === "tinh") {
		let urlQuanHuyen = `${URL}/district/${valueSelected}`;

		$.get(urlQuanHuyen, function (data, status) {
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

		$.get(urlPhuongXa, function (data, status) {
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