package com.websitenhaccu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDonDTO {
	
	private String maHoaDon;
	
	private String maSanPham;
	
	private String tenSanPham;
	
	private MauSanPhamDTO mauSanPhamDTO;

	private int soLuong;
}
