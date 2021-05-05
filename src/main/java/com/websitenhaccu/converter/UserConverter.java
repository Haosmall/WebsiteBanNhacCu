package com.websitenhaccu.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.entity.GioiTinh;
import com.websitenhaccu.entity.ROLE;
import com.websitenhaccu.entity.NguoiDung;

@Component
public class UserConverter {
	@Autowired
	private PasswordEncoder passwordEncoder;

	public NguoiDung toUser(UserDTO userDTO, NguoiDung userOld) {

		if (userDTO == null)
			return null;

		String id = userDTO.getUserId();
		String email = userDTO.getEmail();
		String fullName = userDTO.getFullName();
		GioiTinh gender = userDTO.getGender();
		String phone = userDTO.getPhone();

		ROLE role = userDTO.getRole() == null ? userOld.getRole() : userDTO.getRole();
		String password = passwordEncoder.encode(userDTO.getPassword());
		boolean enabled = userDTO.isEnabled();
		String verifyCode = userOld.getMaXacNhan();

		NguoiDung user = new NguoiDung(id, fullName, phone, email, gender, password, role, verifyCode, enabled);

		return user;
	}

	public UserDTO toUserDTO(NguoiDung user) {

		if (user == null)
			return null;

		String id = user.getId();
		String email = user.getEmail();
		String fullName = user.getHoTen();
		GioiTinh gender = user.getGioiTinh();
		String phone = user.getSoDienThoai();

		ROLE role = user.getRole();
		boolean enabled = user.isTrangThai();
		UserDTO userDTO = new UserDTO(id, fullName, gender, phone, email, role, enabled);

		return userDTO;
	}
}
