package com.websitenhaccu.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.websitenhaccu.converter.NguoiDungConverter;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.entity.ROLE;
import com.websitenhaccu.repository.NguoiDungRepository;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.EmailSender;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	NguoiDungRepository nguoiDungRepository;

	@Autowired
	NguoiDungConverter nguoiDungConverter;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public NguoiDungDTO getByEmail(String email) {
		NguoiDung user = nguoiDungRepository.findByEmail(email);
		System.out.println(user);

		if (user != null) {
			NguoiDungDTO dto = nguoiDungConverter.toNguoiDungDTO(user);
//			NguoiDungDTO dto = new NguoiDungDTO();
//			dto.setUserId(user.getId());
//			dto.setEmail(user.getEmail());
//			dto.setRole(user.getRole());
//			dto.setFullName(user.getHoTen());
//			dto.setAddress(user.getDiaChi());
//			dto.setPhone(user.getSoDienThoai());
			return dto;
		} else {
			return null;
		}

	}

	@Override
	public boolean registrationVerifyUserByEmail(NguoiDungDTO userDTO, String host) {
		boolean result = false;

		try {
			String verifyCode = RandomStringUtils.randomAlphanumeric(20);
			userDTO.setRole(ROLE.ROLE_USER);

			String id = save(userDTO).getUserId();

			NguoiDung user = nguoiDungRepository.findById(id).get();

			user.setMaXacNhan(verifyCode);

			nguoiDungRepository.save(user);

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
		NguoiDung user = nguoiDungRepository.findByEmail(email);
		System.out.println("Verify email: " + user);

		if (user == null) {
			return false;
		}
		if (user.getMaXacNhan().equals(token)) {
			user.setTrangThai(true);
			nguoiDungRepository.save(user);
			return true;
		}

		return false;
	}

	@Override
	public NguoiDungDTO save(NguoiDungDTO userDTO) {
		if (userDTO == null)
			return null;
//		NguoiDung userOld = nguoiDungRepository.findById(userDTO.getUserId()).get();
		NguoiDung userOld = new NguoiDung();

		NguoiDung user = nguoiDungRepository.save(nguoiDungConverter.toNguoiDung(userDTO, userOld));

		NguoiDungDTO userDTO2 = nguoiDungConverter.toNguoiDungDTO(user);
		return userDTO2;

	}

	@Override
	public boolean sendEmailForgotPassword(String email, String host) {
		NguoiDung user = nguoiDungRepository.findByEmailAndTrangThai(email, true);

		if (user == null)
			return false;

		String randomVerifyCode = RandomStringUtils.randomAlphanumeric(20);
		user.setMaXacNhan(randomVerifyCode);

		nguoiDungRepository.save(user);

		String content = host + "/WebsiteBanNhacCu/forgot-password/enter-password?email=" + email + "&token="
				+ randomVerifyCode;
		emailSender.sendEmail(email, "Forgot password", content);

		return true;
	}

	@Override
	public boolean verifyPassword(String email, String token, String password) {
		NguoiDung user = nguoiDungRepository.findByEmailAndTrangThai(email, true);

		if (user == null)
			return false;

		if (user.getMaXacNhan().equals(token)) {
			user.setPassword(passwordEncoder.encode(password));

			nguoiDungRepository.save(user);

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
		NguoiDung nguoiDung = nguoiDungRepository.findById(userId).get();
		return nguoiDung == null ? false : true;
	}

	@Override
	public NguoiDung getNguoiDungTheoEmail(String email) {
		
		return nguoiDungRepository.findByEmail(email);
	}

}
