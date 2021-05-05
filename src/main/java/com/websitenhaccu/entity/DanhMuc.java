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
@Table(name = "DanhMucs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanhMuc {

	@Id
	@Column(name = "danh_muc_id")
	private String id;

	@Column(name = "ten_danh_muc", columnDefinition = "NVARCHAR")
	private String tenDanhMuc;

	@OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<SanPham> sanPhams;

	@OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<DongSanPham> dongSanPhams;
}
