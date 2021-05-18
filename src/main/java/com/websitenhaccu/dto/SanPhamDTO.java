package com.websitenhaccu.dto;

import java.util.List;

import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.GiamGia;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.NhaCungCap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDTO {

	private String id;

	private String tenSanPham;

	private String moTa;

	private double giaNhap;

	private double giaBan;

	private String xuatXu;

	private boolean trangThai;

	private int baoHanh;

	private int namSanXuat;

	private String maNhaCungCap;

	private List<GiamGia> giamGias;

	private List<MauSanPhamDTO> mauSanPhamDTOs;

	private String maDongSanPham;
	
	private String maLoaiSanPham;
	
	private String maThuongHieu;

	public SanPhamDTO(String id, String tenSanPham, String moTa) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
	}
	
	
	
	
}
