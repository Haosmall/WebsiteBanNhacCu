package com.websitenhaccu.converter;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;

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
	public NguoiDung toUpdateUser(UserDTO userDTO, NguoiDung userOld, byte[] bytes) {
		
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
		
		Blob hinhAnh = null;
		try {
			hinhAnh = new SerialBlob(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		NguoiDung user = new NguoiDung(id, fullName, phone, email, gender, password, role, verifyCode, enabled);
		user.setHinhAnh(hinhAnh);
		
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
		
		Blob blob = user.getHinhAnh();
		int blobLength;
		byte[] bytes = null;
		String hinhAnhBase64 = "";
		Optional<Blob> optional = Optional.ofNullable(blob);
		try {
			if (optional.isPresent()) {
				blobLength = (int) blob.length();
				bytes = blob.getBytes(1, blobLength);
				hinhAnhBase64 = Base64.getEncoder().encodeToString(bytes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		UserDTO userDTO = new UserDTO(id, fullName, gender, phone, email, role, enabled);
		userDTO.setHinhAnhBase64(hinhAnhBase64);

		return userDTO;
	}
}
