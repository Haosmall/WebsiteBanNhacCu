package com.websitenhaccu.service;


import com.websitenhaccu.dto.NguoiDungDTO;

public interface NguoiDungService {
	public NguoiDungDTO getByEmail(String email);

	public boolean registrationVerifyUserByEmail(NguoiDungDTO userDTO, String host);
	
	public boolean verifyEmail(String email, String token);

	public NguoiDungDTO save(NguoiDungDTO userDTO);
	
	public boolean sendEmailForgotPassword(String email, String host);
	
	public boolean verifyPassword(String email, String token, String password);

	public String[] handleAddress(String diaChi);
	
	public boolean updateAddress(String userId);
}
