$(document).ready(function () {
	new FroalaEditor("#edit");
	var maSP = $('#id').val();
	var url = "http://localhost:8080/WebsiteBanNhacCu/api/san-pham?id="+maSP;
	$.get(url, function (data, status) {
		if (status === "success") {
			$(".fr-element").html(data.moTa);
		}
	});
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
