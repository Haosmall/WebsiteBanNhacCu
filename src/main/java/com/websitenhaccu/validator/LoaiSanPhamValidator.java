package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.LoaiSanPham;

@Component
public class LoaiSanPhamValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return LoaiSanPham.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		LoaiSanPham loaiSanPham = (LoaiSanPham) target;
		
		if(loaiSanPham.getTenLoaiSanPham() == null) {
			errors.rejectValue("tenLoaiSanPham", null, "Tên loại sản phẩm không được bỏ trống");
		}
	}

}
