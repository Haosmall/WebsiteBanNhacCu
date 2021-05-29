package com.websitenhaccu.dto;

import java.util.List;

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
	
	private List<MauSanPhamDTO> listMauSanPhamDTOs;
	
	private int tongSoLuong;
	
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

	/**
	 * @param id
	 * @param tenSanPham
	 * @param moTa
	 * @param giaNhap
	 * @param giaBan
	 * @param xuatXu
	 * @param trangThai
	 * @param baoHanh
	 * @param namSanXuat
	 * @param maNhaCungCap
	 * @param tenNhaCungCap
	 * @param maDongSanPham
	 * @param tenDongSanPham
	 * @param maLoaiSanPham
	 * @param tenLoaiSanPham
	 * @param maThuongHieu
	 * @param tenThuongHieu
	 * @param hinhAnhBase64
	 */
	public SanPhamDTO(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat, String maNhaCungCap, String tenNhaCungCap,
			String maDongSanPham, String tenDongSanPham, String maLoaiSanPham, String tenLoaiSanPham,
			String maThuongHieu, String tenThuongHieu, String hinhAnhBase64) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.xuatXu = xuatXu;
		this.trangThai = trangThai;
		this.baoHanh = baoHanh;
		this.namSanXuat = namSanXuat;
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.maDongSanPham = maDongSanPham;
		this.tenDongSanPham = tenDongSanPham;
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	/**
	 * @param id
	 * @param tenSanPham
	 * @param xuatXu
	 * @param tenLoaiSanPham
	 * @param tenThuongHieu
	 * @param hinhAnhBase64
	 */
	public SanPhamDTO(String id, String tenSanPham, String xuatXu, String tenLoaiSanPham, String tenThuongHieu,
			int tongSoLuong) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.xuatXu = xuatXu;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.tenThuongHieu = tenThuongHieu;
		this.tongSoLuong = tongSoLuong;
	}

	/**
	 * @param id
	 * @param tenSanPham
	 * @param moTa
	 * @param giaNhap
	 * @param giaBan
	 * @param xuatXu
	 * @param trangThai
	 * @param baoHanh
	 * @param namSanXuat
	 * @param maNhaCungCap
	 * @param tenNhaCungCap
	 * @param maDongSanPham
	 * @param tenDongSanPham
	 * @param maLoaiSanPham
	 * @param tenLoaiSanPham
	 * @param maThuongHieu
	 * @param tenThuongHieu
	 * @param hinhAnhBase64
	 * @param listMauSanPhamDTOs
	 */
	public SanPhamDTO(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat, String maNhaCungCap, String tenNhaCungCap,
			String maDongSanPham, String tenDongSanPham, String maLoaiSanPham, String tenLoaiSanPham,
			String maThuongHieu, String tenThuongHieu, String hinhAnhBase64, List<MauSanPhamDTO> listMauSanPhamDTOs) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.xuatXu = xuatXu;
		this.trangThai = trangThai;
		this.baoHanh = baoHanh;
		this.namSanXuat = namSanXuat;
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.maDongSanPham = maDongSanPham;
		this.tenDongSanPham = tenDongSanPham;
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
		this.listMauSanPhamDTOs = listMauSanPhamDTOs;
	}
	
}
