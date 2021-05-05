package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NhaCungCaps")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class NhaCungCap {

	@Id
	@Column(name = "nha_cung_cap_id")
	private String id;

	@Column(name = "ten_nha_cung_cap", columnDefinition = "NVARCHAR(MAX)")
	private String tenNhaCungCap;

	@Column(name = "dia_chi", columnDefinition = "NVARCHAR(MAX)")
	private String diaChi;
	
	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	@Column(name = "website")
	private String website;



}
