package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.DonViVanChuyen;

@Component
public class DonViVanChuyenValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DonViVanChuyen.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (!supports(target.getClass())) {
			return;
		}

		DonViVanChuyen donViVanChuyen = (DonViVanChuyen) target;

		if (donViVanChuyen.getTenDonViVanChuyen() == null
				|| donViVanChuyen.getTenDonViVanChuyen().trim().length() == 0) {
			errors.rejectValue("tenDonViVanChuyen", null, "Tên DV vận chuyển không được bỏ trống");

		}

		if (donViVanChuyen.getSoDienThoai() == null || donViVanChuyen.getSoDienThoai().trim().length() == 0) {
			errors.rejectValue("soDienThoai", null, "Số điện thoại không được bỏ trống");
		} else {

			if (!donViVanChuyen.getSoDienThoai().trim().matches("\\d{10}")) {
				errors.rejectValue("soDienThoai", null, "Số điện thoại không đúng định dạng");
			}

		}

	}

}
