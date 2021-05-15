package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.AttributeValue;

@Component
public class AttributeValueValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return AttributeValue.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		AttributeValue attributeValue = (AttributeValue) target;
		
		if(attributeValue.getValue().length() == 0) {
			errors.rejectValue("value", null, "Giá trị thuộc tính không được bỏ trống");
		}
	}

}
