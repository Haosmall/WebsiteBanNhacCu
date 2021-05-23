validatePassword = () => {
	const password = document.getElementById("password").value;
	let checkPassword = document.getElementById("checkPassword");

	if (password == "") {
		checkPassword.innerHTML = "(*) Mật khẩu trống";
		return false;
	} else {
		checkPassword.innerHTML = "";
		return true;
	}
}

validatePasswordCf = () => {
	const passwordcfg = document.getElementById("passwordConf").value;
	let checkPasswordcfg = document.getElementById("checkPasswordCf");
	const password = document.getElementById("password").value

	if (password == "") {
		checkPasswordcfg.innerHTML = "(*) Mật khẩu xác nhận trống";
		return false;
	} else if (passwordcfg !== password) {
		checkPasswordcfg.innerHTML = "(*) Mật xác nhận không khớp ";
		return false;
	}
	else {
		checkPasswordcfg.innerHTML = "";
		return true;
	}
}


validateFullname = () => {
	const fullname = document.getElementById("fullName").value;
	let checkFullName = document.getElementById("checkFullName");

	if (fullname == "") {
		checkFullName.innerHTML = "(*) Họ tên trống";
		return false;
	} else {
		checkFullName.innerHTML = "";
		return true;
	}
}

validateSdt = () => {
	const sdt = document.getElementById("phone").value;
	let stdCheck = document.getElementById("checkPhone");
	regex = /^\d{10}$/;

	if (regex.test(sdt) == false) {
		stdCheck.innerHTML = "(*) Số điện thoại không hợp lệ";
		return false;
	} else {
		stdCheck.innerHTML = "";

		return true;
	}

}



const HOST_NAME = window.location.hostname;;
const PAGE_PATH = window.location.pathname;
const PORT = window.location.port;
const api = "/api/email?email=";
const regexEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;


validateEmail = () => {
	let email = document.getElementById("email").value;
	let apiFetch = "http://" + HOST_NAME + ":" + PORT + PAGE_PATH + api + email;

	let checkEmail = document.getElementById("checkEmail");

	var result;
	$.get(apiFetch, function(data, status) {

		setTimeout(function() {
			console.log("check data", data);
			if (status == "success") {
				if (data === 1) {

					checkEmail.innerHTML = "(*) Email đã tồn tại";
					result = false;
					console.log(result);

				} else {
					if (!regexEmail.test(email)) {
						checkEmail.innerHTML = "(*) Email không hợp lệ";
						result = false;
					} else {
						checkEmail.innerHTML = "";
						result = true;
					}
				}
			}

			console.log(result);
			return result;
		}, 200);
	});





}





const button_submit = $("#btnSubmit");
const form = $("#formRegister");

button_submit.click(function(event) {


	setTimeout(function() {


		if (validateFullname() && validateEmail() && validateSdt() && validatePassword() && validatePasswordCf()) {
			form.submit();
		}
		else {
			console.log("failed");
			event.preventDefault();
		}
	}, 200)
});
