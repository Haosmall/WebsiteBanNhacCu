const tempPrice = $(".tempPrice");
const priceInner = $("#priceInner");
const amounts = $(".ammout");
const currentPrice = $(".currentPrice");


//amounts.each(function (index, element) {
//    let amount = Number.parseInt(element.textContent);
//    let priceWithProduct = Number.parseInt(currentPrice.get(index).textContent.replaceAll(",", ""));
//
//    console.log(amount, priceWithProduct)
//    tempPrice.get(index).innerHTML = amount * priceWithProduct;
//
//
//})
//
//
//
//var totalPrice = 0;
//
//tempPrice.each(function (index, element) {
//    let temp = Number.parseInt(element.textContent);
//    totalPrice += temp;
//
//});
//
//priceInner.text(totalPrice);



const start = $(".start-ratting span");

console.log(start);

start.click(function (e) {
    console.log($(this).index())
    let loop = $(this).index() + 1;

    start.removeClass("checked")


    for (let index = 0; index < loop; index++) {
        start.get(index).classList.add("checked");
    }
});

muaLai = (id) => {
	window.location.href = "http://localhost:8080/WebsiteBanNhacCu/san-pham?id=" + id;
}
huyDonHang = (id) => {
	var r = confirm("Bạn có muốn hủy đơn hàng?");
	if(r == true){
		window.location.href = "http://localhost:8080/WebsiteBanNhacCu/quan-ly-don-hang/huy-don-hang?id=" + id;
	}
}



