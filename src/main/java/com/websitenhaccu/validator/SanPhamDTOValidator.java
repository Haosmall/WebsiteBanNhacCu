package com.websitenhaccu.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.dto.SanPhamDTO;

@Component
public class SanPhamDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SanPhamDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (!supports(target.getClass())) {
			return;
		}

		SanPhamDTO sanPhamDTO = (SanPhamDTO) target;
		
		System.out.println("@@@@@@@@@@@@@@ class validate: "+ sanPhamDTO);
		
		if (sanPhamDTO.getTenSanPham().trim().equals("")) {
			errors.rejectValue("tenSanPham", null, "Tên sản phẩm không được bỏ trống");
		}
		if (sanPhamDTO.getXuatXu().trim().equals("")) {
			errors.rejectValue("xuatXu", null, "Xuất xứ không được bỏ trống");
		}
		if (sanPhamDTO.getNamSanXuat() <= 1700) {
			errors.rejectValue("namSanXuat", null, "Năm sản xuất không hợp lệ");
		}
		if (sanPhamDTO.getBaoHanh() == 0 || String.valueOf(sanPhamDTO.getBaoHanh()).trim().equals("")) {
			errors.rejectValue("baoHanh", null, "Bảo hành không được bỏ trống");
		}
		if (sanPhamDTO.getGiaNhap() == 0 || String.valueOf(sanPhamDTO.getGiaNhap()).trim().equals("")) {
			errors.rejectValue("giaNhap", null, "Giá nhập không được bỏ trống");
		}
		if (sanPhamDTO.getGiaBan() == 0 || String.valueOf(sanPhamDTO.getGiaBan()).trim().equals("")) {
			errors.rejectValue("giaBan", null, "Giá bán không được bỏ trống");
		}

		if (sanPhamDTO.getTongSoLuong() == 0 || String.valueOf(sanPhamDTO.getTongSoLuong()).trim().equals("")) {
			errors.rejectValue("tongSoLuong", null, "Số lượng không được bỏ trống");
		}
	}

}
