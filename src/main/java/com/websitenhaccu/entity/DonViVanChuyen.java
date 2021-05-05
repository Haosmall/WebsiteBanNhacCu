package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DonViVanChuyens")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class DonViVanChuyen {
	
	@Id
	@Column(name = "don_vi_van_chuyen_id")
	private String id;
	
	@Column(name = "so_dien_thoai")
	private String soDienThoai;
	
	@Column(name = "ten_don_vi_van_chuyen", columnDefinition = "NVARCHAR(MAX)")
	private String tenDonViVanChuyen;

}
