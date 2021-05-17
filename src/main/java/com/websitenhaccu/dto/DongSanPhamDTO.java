package com.websitenhaccu.dto;

import java.util.List;

import com.websitenhaccu.entity.SanPham;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class DongSanPhamDTO {
	
	private String id;

	String maThuongHieu;

	String maLoaiSanPham;

	private String tenDongSanPham;

	private float thue;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<SanPham> sanPhams;
	
	
}
