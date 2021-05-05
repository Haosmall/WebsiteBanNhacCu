package com.websitenhaccu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DongSanPhams")
@IdClass(DongSanPham_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongSanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "thuong_hieu_id")
	ThuongHieu thuongHieu;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "danh_muc_id")
	DanhMuc danhMuc;

	@Column(name = "ten_dong_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenDongSanPham;

	@Column(name = "thue")
	private float thue;

}
