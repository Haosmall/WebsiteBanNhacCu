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
@Table(name = "ThuongHieus")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class ThuongHieu {
	@Id
	@Column(name = "thuong_hieu_id")
	private String id;
	
	@Column(name = "ten_thuong_hieu", columnDefinition = "NVARCHAR(MAX)")
	private String tenThuongHieu;
	
	@OneToMany(mappedBy = "thuongHieu", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
    private List<DongSanPham> dongSanPhams;

}
