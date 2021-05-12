package com.websitenhaccu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "LoaiSanPhams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiSanPham {

	@Id
	@Column(name = "loai_san_pham_id")
	private String id;

	@Column(name = "ten_loai_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenLoaiSanPham;

//	@OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY)
//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	private List<SanPham> sanPhams;

	@OneToMany(mappedBy = "loaiSanPham", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<DongSanPham> dongSanPhams;
}
