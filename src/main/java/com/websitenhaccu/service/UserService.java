package com.websitenhaccu.service;

import com.websitenhaccu.dto.UserDTO;

public interface UserService {
	public UserDTO getByEmail(String email);
}
