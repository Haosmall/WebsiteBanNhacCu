package com.websitenhaccu.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "HoaDons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

	@Id
	@Column(name = "hoa_don_id")
	private String id;

	@Column(name = "ngay_lap_hd")
	private Date ngayLapHD;

	@Column(name = "dia_chi_giao_hang", columnDefinition = "NVARCHAR(MAX)")
	private String diaChiGiaoHang;

	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	@Column(name = "trang_thai")
	private String trangThai;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nguoi_dung_id")
	private NguoiDung nguoiDung;

	@OneToMany(mappedBy = "hoaDon")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();

}
