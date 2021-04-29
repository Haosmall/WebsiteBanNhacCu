package com.websitenhaccu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.entity.User;
import com.websitenhaccu.repository.UserRepository;
import com.websitenhaccu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDTO getByEmail(String email) {
		User user = userRepo.findByEmail(email);
		UserDTO dto = new UserDTO();
		dto.setUserId(user.getUserId());
		dto.setEmail(user.getEmail());
		dto.setRole(user.getRole());
		dto.setFirstName(user.getFirstName());
		return dto;
	}
}
