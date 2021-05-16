package com.websitenhaccu.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.websitenhaccu.entity.DongSanPham;

@Component
public class ThuongHieuDTO {
	private String id;
	private String tenThuongHieu;
	private String hinhAnhBase64;
	private List<DongSanPham> dongSanPhams;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the tenThuongHieu
	 */
	public String getTenThuongHieu() {
		return tenThuongHieu;
	}

	/**
	 * @param tenThuongHieu the tenThuongHieu to set
	 */
	public void setTenThuongHieu(String tenThuongHieu) {
		this.tenThuongHieu = tenThuongHieu;
	}

	/**
	 * @return the hinhAnhBase64
	 */
	public String getHinhAnhBase64() {
		return hinhAnhBase64;
	}

	/**
	 * @param hinhAnhBase64 the hinhAnhBase64 to set
	 */
	public void setHinhAnhBase64(String hinhAnhBase64) {
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	/**
	 * @return the dongSanPhams
	 */
	public List<DongSanPham> getDongSanPhams() {
		return dongSanPhams;
	}

	/**
	 * @param dongSanPhams the dongSanPhams to set
	 */
	public void setDongSanPhams(List<DongSanPham> dongSanPhams) {
		this.dongSanPhams = dongSanPhams;
	}
	
	

	/**
	 * @param id
	 * @param tenThuongHieu
	 */
	public ThuongHieuDTO(String id, String tenThuongHieu) {
		super();
		this.id = id;
		this.tenThuongHieu = tenThuongHieu;
	}

	/**
	 * @param id
	 * @param tenThuongHieu
	 * @param hinhAnhBase64
	 */
	public ThuongHieuDTO(String id, String tenThuongHieu, String hinhAnhBase64) {
		super();
		this.id = id;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	/**
	 * 
	 */
	public ThuongHieuDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ThuongHieuDTO [id=" + id + ", tenThuongHieu=" + tenThuongHieu + ", hinhAnhBase64=" + hinhAnhBase64
				+ "]";
	}

}
