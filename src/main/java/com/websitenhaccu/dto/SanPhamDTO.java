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

	private NhaCungCap nhaCungCap;

	private List<GiamGia> giamGias;

	private List<MauSanPham> mauSanPhams;

	private DongSanPham dongSanPham;

	public SanPhamDTO(String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu, boolean trangThai,
			int baoHanh, int namSanXuat, NhaCungCap nhaCungCap, List<GiamGia> giamGias, List<MauSanPham> mauSanPhams,
			DongSanPham dongSanPham) {
		super();
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.xuatXu = xuatXu;
		this.trangThai = trangThai;
		this.baoHanh = baoHanh;
		this.namSanXuat = namSanXuat;
		this.nhaCungCap = nhaCungCap;
		this.giamGias = giamGias;
		this.mauSanPhams = mauSanPhams;
		this.dongSanPham = dongSanPham;
	}

	
}
