package com.websitenhaccu.validator;

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
			System.out.println("=======loi ten");
			errors.rejectValue("tenSanPham", null, "Tên sản phẩm không được bỏ trống");
		}
		if (sanPhamDTO.getXuatXu().trim().equals("")) {
			errors.rejectValue("xuatXu", null, "Xuất xứ không được bỏ trống");
		}
		if (sanPhamDTO.getNamSanXuat() == 0 || String.valueOf(sanPhamDTO.getNamSanXuat()).trim().equals("")) {
			errors.rejectValue("namSanXuat", null, "Năm sản xuất không được bỏ trống");
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
			errors.rejectValue("soLuong", null, "Số lượng không được bỏ trống");
		}
	}

}
