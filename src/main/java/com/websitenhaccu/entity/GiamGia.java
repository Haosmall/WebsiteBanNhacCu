package com.websitenhaccu.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GiamGias")
public class GiamGia {
	
	@Id
	@Column(name = "giam_gia_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "phan_tram_giam_gia")
	private double phanTramGiamGia;
	
	@Column(name = "ngay-bat-dau")
	private Date ngayBatDau;
	
	@Column(name = "ngay_ket_thuc")
	private Date ngayKetThuc;
	
	@ManyToOne
	@JoinColumn(name = "san_pham_id")
	private SanPham sanPham;

	public GiamGia(double phanTramGiamGia, Date ngayBatDau, Date ngayKetThuc, SanPham sanPham) {
		super();
		this.phanTramGiamGia = phanTramGiamGia;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.sanPham = sanPham;
	}
	
}
