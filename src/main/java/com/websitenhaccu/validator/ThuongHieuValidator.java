package com.websitenhaccu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.ThuongHieuService;

@Component
public class ThuongHieuValidator implements Validator{
	
	@Autowired
	private ThuongHieuService thuongHieuService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ThuongHieu.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		ThuongHieu thuongHieu = (ThuongHieu) target;
		System.out.println(thuongHieu);
		
		if(thuongHieu.getTenThuongHieu() == null || thuongHieu.getTenThuongHieu().trim() == "") {
			System.out.println("loi ten");
			errors.rejectValue("tenThuongHieu", null, "Tên thương hiệu không được bỏ trống");
		}
		else if(thuongHieuService.getThuonghieuBangTenThuonghieu(thuongHieu.getTenThuongHieu()) != null) {
			System.out.println("loi ten");
			errors.rejectValue("tenThuongHieu", null, "Tên thương hiệu này đã tồn tại");
		}
	}

}
