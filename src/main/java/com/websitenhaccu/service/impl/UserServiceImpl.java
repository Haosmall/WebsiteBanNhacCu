package com.websitenhaccu.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.websitenhaccu.converter.UserConverter;
import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.entity.ROLE;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.repository.UserRepository;
import com.websitenhaccu.service.UserService;
import com.websitenhaccu.util.EmailSender;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserConverter userConverter;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDTO getByEmail(String email) {
		NguoiDung user = userRepo.findByEmail(email);
		System.out.println(user);

		if (user != null) {
			UserDTO dto = new UserDTO();
			dto.setUserId(user.getId());
			dto.setEmail(user.getEmail());
			dto.setRole(user.getRole());
			dto.setFullName(user.getHoTen());
			dto.setAddress(user.getDiaChi());
			dto.setPhone(user.getSoDienThoai());
			return dto;
		} else {
			return null;
		}

	}

	@Override
	public boolean registrationVerifyUserByEmail(UserDTO userDTO, String host) {
		boolean result = false;

		try {
			String verifyCode = RandomStringUtils.randomAlphanumeric(20);
			userDTO.setRole(ROLE.ROLE_USER);

			String id = save(userDTO).getUserId();

			NguoiDung user = userRepo.findById(id).get();

			user.setMaXacNhan(verifyCode);

			userRepo.save(user);

			String verificationLink = host + "/WebsiteBanNhacCu/verify-email?email=" + userDTO.getEmail() + "&token="
					+ verifyCode;

			emailSender.sendEmail(userDTO.getEmail(), "Verify email", verificationLink);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean verifyEmail(String email, String token) {
		NguoiDung user = userRepo.findByEmail(email);
		System.out.println("Verify email: " + user);

		if (user == null) {
			return false;
		}
		if (user.getMaXacNhan().equals(token)) {
			user.setTrangThai(true);
			userRepo.save(user);
			return true;
		}

		return false;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		if (userDTO == null)
			return null;
//		User userOld = userRepo.findById(userDTO.getUserId()).get();
		NguoiDung userOld = new NguoiDung();

		NguoiDung user = userRepo.save(userConverter.toUser(userDTO, userOld));

		UserDTO userDTO2 = userConverter.toUserDTO(user);
		return userDTO2;

	}

	@Override
	public boolean sendEmailForgotPassword(String email, String host) {
		NguoiDung user = userRepo.findByEmailAndTrangThai(email, true);

		if (user == null)
			return false;

		String randomVerifyCode = RandomStringUtils.randomAlphanumeric(20);
		user.setMaXacNhan(randomVerifyCode);

		userRepo.save(user);

		String content = host + "/WebsiteBanNhacCu/forgot-password/enter-password?email=" + email + "&token="
				+ randomVerifyCode;
		emailSender.sendEmail(email, "Forgot password", content);

		return true;
	}

	@Override
	public boolean verifyPassword(String email, String token, String password) {
		NguoiDung user = userRepo.findByEmailAndTrangThai(email, true);

		if (user == null)
			return false;

		if (user.getMaXacNhan().equals(token)) {
			user.setPassword(passwordEncoder.encode(password));

			userRepo.save(user);

			return true;
		}

		return false;
	}

	@Override
	public String[] handleAddress(String diaChi) {
		String[] temp = diaChi.split(", ");
		return temp;
	}

	@Override
	public boolean updateAddress(String userId) {
		NguoiDung nguoiDung = userRepo.findById(userId).get();
		return nguoiDung == null ? false : true;
	}

}
