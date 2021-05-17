package com.websitenhaccu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class MauSanPhamDTO {
	private int maMau;

	private String maSanPham;

	private int soLuong;
	
	private String hinhAnhBase64;


}
