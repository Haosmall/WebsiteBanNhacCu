package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LienHes")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class LienHe {
	
	@Id
	@Column(name = "lien_he_id")
	private String id;
	
	@Column(name = "dia_chi", columnDefinition = "NVARCHAR(MAX)")
	private String diaChi;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "so_dien_thoai")
	private String soDienThoai;

}
