package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.Mau;

@Component
public class AttributeValidator implements Validator{

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
		
		if(mau.getTenMau() == null) {
			errors.rejectValue("attributeName", null, "Tên thuộc tính không được bỏ trống");
		}
	}

}
