package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ChiTietHoaDons")
@IdClass(ChiTietHoaDon_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDon {
	
	@Id
    @ManyToOne
    @JoinColumn(name = "san_pham_id")
	private SanPham sanPham;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "hoa_don_id")
	private HoaDon hoaDon;
	
	@Column(name = "gia")
	private double gia;

	@Column(name = "so_luong")
	private int soLuong;
}
