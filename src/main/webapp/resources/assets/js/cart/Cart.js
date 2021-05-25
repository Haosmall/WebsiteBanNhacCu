const minus = $(".minus");
const add = $(".plus");
const count = $(".count");
const maxCount = $(".maxCount");
const alert = $(".alert");
const alert_block = $(".alert--block");
const totalPrice = $("#totalPrice");
const priceProduct = $(".price");
const checkBox = $(".form-check-input");

console.log(checkBox)





calculateTotalPrice = () => {
    var price = 0;
    count.each(function (index) {
//        if (checkBox.get(index).checked === true) {
            // console.log($(this).val());
            let amountTemp = Number.parseInt($(this).val());
            let priceTemp = Number.parseInt(priceProduct.get(index).textContent);
            let totalPriceTemp = amountTemp * priceTemp;
            price += totalPriceTemp;
//        }
    })

    totalPrice.html(price);
}


checkBox.each(function (index) {
    $(this).change(function () {
        calculateTotalPrice();
    })
})



$(document).ready(function () {
    calculateTotalPrice();
});


add.each(function (index) {

    $(this).click(function () {
        let currentVal = Number.parseInt(count.get(index).value);
        const max = Number.parseInt(maxCount.get(index).value);
        if (currentVal < max) {

            count.get(index).value = currentVal + 1;

        } else {
            alert.show();
            clearAlert();
        }

//        if (checkBox.get(index).checked === true) {

            calculateTotalPrice();
//        }
    });
});

minus.each(function (index) {

    $(this).click(function () {
        let currentVal = Number.parseInt(count.get(index).value);
        const min = 1;
        if (currentVal > min) {
            count.get(index).value = currentVal - 1;
            alert_block.css({ "display": "none" });

        }
//        if (checkBox.get(index).checked === true) {

            calculateTotalPrice();
//        }

    });
});


count.each(function (index) {
    $(this).blur(function () {
        let valueTemp = Number.parseInt($(this).val());
        console.log(isNaN(NaN));
        // nếu là số thì flase
        // là chuỗi thì true;
        // là nan thì true

        // console.log(isNaN()  === valueTemp);

        if (isNaN(valueTemp)) {

            // trường hợp này đúng
            $(this).val(1);
            alert.show();
            clearAlert();
        }

        const max = Number.parseInt(maxCount.get(index).value);
        // console.log(max);
        if (valueTemp > 0 && valueTemp <= max) {
            calculateTotalPrice();
            alert_block.css({ "display": "none" });
        } else {
            alert.show();
            clearAlert()
        }

    })
})


function clearAlert() {
    setTimeout(function () {
        alert_block.css({ "display": "none" });

    }, 3000)

}
xoaChiTietHoaDon = (maSanPham, maMau) =>{
	
	var apiFetch = "http://localhost:8080/WebsiteBanNhacCu/api/gio-hang/xoa-gio-hang?maSanPham=" + maSanPham + "&maMau=" + maMau;
	console.log(apiFetch);
	
	$.ajax({
	    url: apiFetch,
	    type: 'DELETE',
	    success: function(result) {
	    	
	    	window.location.href = "http://localhost:8080/WebsiteBanNhacCu/gio-hang";
	    	toastr.success("Đã xóa khỏi giỏ hàng");
	    },
	    error: function() {
			toastr.error('Không xóa được')
		},
	});
//	$.delete(apiFetch, function (data, status) {
//		setTimeout(function () {
//			if (status === 'success') {
//				if (data === 1) {
//					console.log(data + "đã thêm vào giỏ hàng");
//				}
//			}
//		}, 500);
//	});
}





// console.log(add);

