package com.websitenhaccu.entity;

import java.sql.Blob;
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
@Table(name = "SanPhams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
	@Id
	@Column(name = "san_pham_id")
	private String id;

	@Column(name = "ten_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenSanPham;

	@Column(name = "mo_ta", columnDefinition = "NTEXT")
	private String moTa;

	@Column(name = "hinh_anh")
	private Blob hinhAnh;

	@Column(name = "gia_nhap")
	private double giaNhap;

	@Column(name = "gia_ban")
	private double giaBan;

	@Column(name = "xuat_xu", columnDefinition = "NVARCHAR(MAX)")
	private String xuatXu;

	@Column(name = "trang_thai")
	private boolean trangThai;

	@Column(name = "bao_hanh")
	private int baoHanh;

	@Column(name = "nam_san_xuat")
	private int namSanXuat;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nha_cung_cap_id")
	private NhaCungCap nhaCungCap;

	@OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<BinhLuan> binhLuans;

	@OneToMany(mappedBy = "sanPham")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<ChiTietHoaDon> chiTietHoaDons;

//	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Product discount;

	@OneToMany(mappedBy = "sanPham")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<AttributeValue> listAttributeValues;

	@ManyToOne
	@JoinColumn(name = "danh_muc_id")
	private DanhMuc danhMuc;

}
