package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.ThuongHieu;

@Component
public class ThuongHieuValidator implements Validator{

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
		
		if(thuongHieu.getTenThuongHieu() == null) {
			errors.rejectValue("tenThuongHieu", null, "Tên thương hiệu không được bỏ trống");
		}
	}

}
