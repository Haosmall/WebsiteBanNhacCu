package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.Attribute;

@Component
public class AttributeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Attribute.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		Attribute attribute = (Attribute) target;
		
		if(attribute.getAttributeName() == null) {
			errors.rejectValue("attributeName", null, "Tên thuộc tính không được bỏ trống");
		}
	}

}
