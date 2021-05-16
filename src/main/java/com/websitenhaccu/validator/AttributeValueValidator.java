package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.MauSanPham;

@Component
public class AttributeValueValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return MauSanPham.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		MauSanPham mauSanPham = (MauSanPham) target;
		
//		if(mauSanPham.getSoLuong() < 1) {
//			errors.rejectValue("value", null, "Giá trị thuộc tính không được bỏ trống");
//		}
	}

}
