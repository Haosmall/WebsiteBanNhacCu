package com.websitenhaccu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.service.MauService;

@Component
public class MauValidator implements Validator{

	@Autowired
	private MauService mauService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Mau.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		Mau mau = (Mau) target;
		
		if(mau.getTenMau() == null || mau.getTenMau().trim() == "") {
			errors.rejectValue("tenMau", null, "Tên màu không được bỏ trống");
		}
		else if(mauService.getMauTheoTenMau(mau.getTenMau()) != null) {
			errors.rejectValue("tenMau", null, "Màu đã tồn tại");
		}
	}

}
