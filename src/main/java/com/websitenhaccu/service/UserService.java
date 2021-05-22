package com.websitenhaccu.service;


import com.websitenhaccu.dto.UserDTO;

public interface UserService {
	public UserDTO getByEmail(String email);

	public boolean registrationVerifyUserByEmail(UserDTO userDTO, String host);
	
	public boolean verifyEmail(String email, String token);

	public UserDTO save(UserDTO userDTO);
	
	public boolean sendEmailForgotPassword(String email, String host);
	
	public boolean verifyPassword(String email, String token, String password);

	public String[] handleAddress(String diaChi);
	
	public boolean updateAddress(String userId);
}
