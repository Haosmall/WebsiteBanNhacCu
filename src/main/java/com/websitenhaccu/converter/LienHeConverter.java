package com.websitenhaccu.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.websitenhaccu.constant.DiaChiConstant;
import com.websitenhaccu.dto.LienHeDTO;
import com.websitenhaccu.entity.LienHe;

@Component
public class LienHeConverter {

	public LienHe toLienHe(LienHeDTO lienHeDTO) {

		if (lienHeDTO == null)
			return null;

		String id = lienHeDTO.getId();

		String soDienThoai = lienHeDTO.getSoDienThoai();

		String email = lienHeDTO.getEmail();

		String diaChiDTO = lienHeDTO.getDiaChi();
		String phuongXa = lienHeDTO.getPhuongXa();
		String quanHuyen = lienHeDTO.getQuanHuyen();
		String tinhThanh = lienHeDTO.getTinhThanhPho();

		String diaChi = "";

		StringBuffer buffer = new StringBuffer(diaChiDTO);

//		Kiểm tra và lưu vào biến diaChi theo thứ tự cấp hành chính  <Số nhà, tên đường>, <Phường/ Xã/ Thị trấn>, <Quận/ Thị xã/ Huyện>, <Thành phố/ Tỉnh>
		if (phuongXa.contains(DiaChiConstant.PHUONG) || phuongXa.contains(DiaChiConstant.XA)
				|| phuongXa.contains(DiaChiConstant.THITRAN)) {
			buffer.append(", " + phuongXa);
		}
		if (quanHuyen.contains(DiaChiConstant.QUAN) || quanHuyen.contains(DiaChiConstant.HUYEN)
				|| quanHuyen.contains(DiaChiConstant.THIXA)) {
			buffer.append(", " + quanHuyen);
		}
		if (tinhThanh.contains(DiaChiConstant.TINH) || tinhThanh.contains(DiaChiConstant.THANHPHO)) {
			buffer.append(", " + tinhThanh);
		}

		String temp = buffer.toString();
		Optional<String> tempOptional = Optional.ofNullable(temp);

//		Kiểm tra xem địa chỉ có null không
		if (tempOptional.isPresent()) {
//			Xóa các kí tự "," dư ở đầu chuỗi
			while (temp.startsWith(", ")) {
				temp = temp.substring(2, temp.length());
			}
		}

		diaChi = temp;

		LienHe lienHe = new LienHe(id, diaChi, email, soDienThoai);
		return lienHe;
	}

	public LienHeDTO toLienHeDTO(LienHe lienHe) {

		if (lienHe == null)
			return null;

		String id = lienHe.getId();
		String soDienThoai = lienHe.getSoDienThoai();
		String email = lienHe.getEmail();

		String tinhThanhPho = "";
		String quanHuyen = "";
		String phuongXa = "";
		String diaChi = "";

//		Kiểm tra xem có địa chỉ nhà cung cấp không
		if (lienHe.getDiaChi() != null || lienHe.getDiaChi() != "") {
			String diaChiNCC = lienHe.getDiaChi();
			String[] temp = diaChiNCC.split(", ");
			StringBuffer buffer = new StringBuffer();

//			Kiểm tra xem địa chỉ có 1, hay nhiều thông tin
			if (temp.length > 1) {
//				Lưu thông tin địa chỉ theo cấp hành chính
				for (String string : temp) {
					if (string.contains(DiaChiConstant.TINH) || string.contains(DiaChiConstant.THANHPHO)) {
						tinhThanhPho = string;
					} else if (string.contains(DiaChiConstant.QUAN) || string.contains(DiaChiConstant.HUYEN)
							|| string.contains(DiaChiConstant.THIXA)) {
						quanHuyen = string;
					} else if (string.contains(DiaChiConstant.PHUONG) || string.contains(DiaChiConstant.XA)
							|| string.contains(DiaChiConstant.THITRAN)) {
						phuongXa = string;
					} else {
						buffer.append(string + ", ");
					}
				}
				String tmp = buffer.toString();

//				Kiểm tra xem có thông tin số nhà, tên đường không
				if (!tmp.equals("")) {
//					Xóa kí tự "," dư ở cuối chuỗi
					diaChi = tmp.substring(0, tmp.length() - 2);
				}

			} else {

				if (diaChiNCC.contains(DiaChiConstant.TINH) || diaChiNCC.contains(DiaChiConstant.THANHPHO)) {
					tinhThanhPho = diaChiNCC;
				} else if (diaChiNCC.contains(DiaChiConstant.QUAN) || diaChiNCC.contains(DiaChiConstant.HUYEN)
						|| diaChiNCC.contains(DiaChiConstant.THIXA)) {
					quanHuyen = diaChiNCC;
				} else if (diaChiNCC.contains(DiaChiConstant.PHUONG) || diaChiNCC.contains(DiaChiConstant.XA)
						|| diaChiNCC.contains(DiaChiConstant.THITRAN)) {
					phuongXa = diaChiNCC;
				} else {
					diaChi = diaChiNCC;
				}

			}
		}

		LienHeDTO lienHeDTO = new LienHeDTO(id, email, soDienThoai, tinhThanhPho, quanHuyen, phuongXa, diaChi);

		return lienHeDTO;
	}
}
