const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'register/api/email/tim-kiem'

function searchType() {
    var searchText = document.getElementById("txtSearch").value;
    var txtSearchSdt = document.getElementById("txtSearchSdt").value;
    var txtSearchEmail = document.getElementById("txtSearchEmail").value;

    var pageHidden = document.getElementById("pageValue");//gia tri hiden
    var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
    viewPage.value = 1; //gan lai  hien thi trang hien tai
    pageHidden.value = 1; //gan lai gia tri bien hidden

    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?hoTen=${searchText}&soDienThoai=${txtSearchSdt}&email=${txtSearchEmail}&page=0`;

    $.get(url, function (data, status) {
        $("#tableNguoiDung").html("");
        for (var i = 0; i < data.length; i++) {
            $("#tableNguoiDung").append(
                `<tr>
                <td>${i + 1}</td>
                <td>${data[i].fullName}</td>
                <td>${data[i].phone}</td>
                <td>${data[i].email}</td>
                <td>${data[i].tinhThanhPho}</td>
                <td>
                    Chưa cập nhật
                </td>
                <td><input type="button" class="btn btn-primary table__btn"
                    value="Chi tiết"
                    onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/chi-tiet-nguoi-dung?id=${data[i].userId}' ">

                    <input type="button" class="btn btn-danger table__btn"
                    value="Xóa"
                    onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/xoa-nguoi-dung?id=${data[i].userId}' ">

                </td>
            </tr>`
            );
        }
    });
}

document.getElementById("btnNext").onclick = function () {

    var searchText = document.getElementById("txtSearch").value;

    var pageHidden = document.getElementById("pageValue");//gia tri hiden
    var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

    var page = Number.parseInt(pageHidden.value);//tang gia tri
    if (Number.parseInt(pageHidden.value) == 0) {
        page = page + 2;
    }
    else {
        page = page + 1;
    }


    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?hoTen=${searchText}&soDienThoai=${txtSearchSdt}&email=${txtSearchEmail}&page=${page - 1}`;

    console.log(url)

    $.get(url, function (data, status) {

        if (data[0] != null) {
            console.log("data khac null")
            $("#tableNguoiDung").html("");
            for (var i = 0; i < data.length; i++) {
                $("#tableNguoiDung").append(
                    `<tr>
                    <td>${i + 1}</td>
                    <td>${data[i].fullName}</td>
                    <td>${data[i].phone}</td>
                    <td>${data[i].email}</td>
                    <td>${data[i].tinhThanhPho}</td>
                    <td>
                        Chưa cập nhật
                    </td>
                    <td><input type="button" class="btn btn-primary table__btn"
                        value="Chi tiết"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/chi-tiet-nguoi-dung?id=${data[i].userId}' ">
    
                        <input type="button" class="btn btn-danger table__btn"
                        value="Xóa"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/xoa-nguoi-dung?id=${data[i].userId}' ">
    
                    </td>
                </tr>`
                );
            }

            viewPage.value = page; //gan lai  hien thi trang hien tai
            pageHidden.value = page; //gan lai gia tri bien hidden
        }

    });

};

document.getElementById("btnPreviusPage").onclick = function () {



    var searchText = document.getElementById("txtSearch").value;

    var pageHidden = document.getElementById("pageValue");//gia tri hiden
    var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

    var page = Number.parseInt(pageHidden.value);//tang gia tri
    if (Number.parseInt(pageHidden.value) > 1) {
        page = page - 1;
    }

    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?hoTen=${searchText}&soDienThoai=${txtSearchSdt}&email=${txtSearchEmail}&page=${page - 1}`;
    console.log(url);

    $.get(url, function (data, status) {

        if (data[0] != null) {
            $("#tableNguoiDung").html("");
		for (var i = 0; i < data.length; i++) {
			$("#tableNguoiDung").append(
                `<tr>
                <td>${i + 1}</td>
                <td>${data[i].fullName}</td>
                <td>${data[i].phone}</td>
                <td>${data[i].email}</td>
                <td>${data[i].tinhThanhPho}</td>
                <td>
                    Chưa cập nhật
                </td>
                <td><input type="button" class="btn btn-primary table__btn"
                    value="Chi tiết"
                    onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/chi-tiet-nguoi-dung?id=${data[i].userId}' ">

                    <input type="button" class="btn btn-danger table__btn"
                    value="Xóa"
                    onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/xoa-nguoi-dung?id=${data[i].userId}' ">

                </td>
            </tr>`
            );
		}

            viewPage.value = page; //gan lai  hien thi trang hien tai
            pageHidden.value = page;//gan lai gia tri bien hidden
        }

    });

};
