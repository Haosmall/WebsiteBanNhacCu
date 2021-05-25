package com.websitenhaccu.dto;

import com.websitenhaccu.entity.GioiTinh;
import com.websitenhaccu.entity.ROLE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungDTO {

	private String userId;

	private String fullName;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	private String passwordConf;
	
	private GioiTinh gender;
	
	private ROLE role;
	
	private boolean enabled;
	
	private String hinhAnhBase64;
	
	private String tinhThanhPho;

	private String quanHuyen;

	private String phuongXa;

	private String diaChi;


	public NguoiDungDTO(String userId) {
		super();
		this.userId = userId;

	}

	public NguoiDungDTO(String userId, String fullName, GioiTinh gender, String phone, String email, ROLE role,
			boolean enabled) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.role = role;
		this.enabled = enabled;
	}

}
