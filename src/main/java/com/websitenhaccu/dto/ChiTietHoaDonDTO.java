package com.websitenhaccu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDonDTO {
	
	private String maHoaDon;
	
	private MauSanPhamDTO mauSanPhamDTO;
//	private String maSanPham;
//	private String maSanPham;

	private int soLuong;
}
