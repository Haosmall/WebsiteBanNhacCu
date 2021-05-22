package com.websitenhaccu.dto;

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
	
	private String tenNhaCungCap;

	private String maDongSanPham;
	
	private String tenDongSanPham;
	
	private String maLoaiSanPham;
	
	private String tenLoaiSanPham;
	
	private String maThuongHieu;
	
	private String tenThuongHieu;
	
	private String hinhAnhBase64;
	
	public SanPhamDTO(String id, String tenSanPham, String moTa) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
	}

	/**
	 * @param id
	 * @param tenSanPham
	 * @param xuatXu
	 * @param maLoaiSanPham
	 * @param maThuongHieu
	 */
	public SanPhamDTO(String id, String tenSanPham, String xuatXu, String loaiSanPham, String thuongHieu) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.xuatXu = xuatXu;
		this.maLoaiSanPham = loaiSanPham;
		this.maThuongHieu = thuongHieu;
	}
	
	
	
	
}
