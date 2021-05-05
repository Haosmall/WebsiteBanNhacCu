package com.websitenhaccu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// lấy người dùng có user là có username
		NguoiDung nguoiDung = userRepository.findByEmail(username);

		if (nguoiDung == null)
			throw new UsernameNotFoundException("Tài khoản email không tồn tại");

		CustomUserDetails customUserDetails = new CustomUserDetails(nguoiDung);
		
		return customUserDetails;
	}

}
