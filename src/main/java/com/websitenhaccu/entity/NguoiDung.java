package com.websitenhaccu.entity;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.websitenhaccu.util.MyGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "NguoiDungs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDung {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nguoiDung_generator")
//	@GenericGenerator(name = "nhaCungCap_generator", strategy = "com.websitenhaccu.util.MyGenerator", parameters = {
//			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
//			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "ND"),
//			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d") })
	@Column(name = "nguoi_dung_id")
	private String id;

	@Column(name = "ho_ten", columnDefinition = "NVARCHAR(MAX)")
	private String hoTen;

	@Column(name = "email")
	private String email;
	
	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	@Column(name = "ngay_sinh")
	private Date ngaySinh;

	@Column(name = "dia_chi", columnDefinition = "NVARCHAR(MAX)")
	private String diaChi;

	@Enumerated
	@Column(name = "gioi_tinh")
	private GioiTinh gioiTinh;

	@Lob
	@Column(name = "hinh_anh")
	private Blob hinhAnh;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private ROLE role;

	@Column(name = "ma_xac_nhan")
	private String maXacNhan;

	@Column(name = "trang_thai")
	private boolean trangThai;

	@OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<HoaDon> hoaDons;

	@OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<BinhLuan> binhLuans;

	public NguoiDung(String id, String hoTen,String soDienThoai, String email, GioiTinh gioiTinh, String password, ROLE role, String maXacNhan,
			boolean trangThai) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.password = password;
		this.role = role;
		this.maXacNhan = maXacNhan;
		this.trangThai = trangThai;
	}
	
	

}
