package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "QuanHuyens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuanHuyen {
	
	@Id
	@Column(name = "quan_huyen_id")
	private String id;
	
	@Column(name = "ten_quan_huyen", columnDefinition = "NVARCHAR(MAX)")
	private String tenQuanHuyen;
	
	@Column(name = "cap_hanh_chinh", columnDefinition = "NVARCHAR(MAX)")
	private String capHanhChinh;
	
	@Column(name = "tinh_thanh_id")
	private String maTinhThanh;
	

}
