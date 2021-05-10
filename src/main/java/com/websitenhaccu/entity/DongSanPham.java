package com.websitenhaccu.entity;

import java.io.Serializable;
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
@Table(name = "DongSanPhams")
//@IdClass(DongSanPham_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongSanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "dong_san_pham_id")
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "thuong_hieu_id")
	ThuongHieu thuongHieu;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loai_san_pham_id")
	LoaiSanPham loaiSanPham;

	@Column(name = "ten_dong_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenDongSanPham;

	@Column(name = "thue")
	private float thue;
	
	@OneToMany(mappedBy = "dongSanPham", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<SanPham> sanPhams;

}
