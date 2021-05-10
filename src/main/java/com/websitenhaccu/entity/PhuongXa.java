package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PhuongXas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhuongXa {

	@Id
	@Column(name = "phuong_xa_id")
	private String id;

	@Column(name = "ten_phuong_xa", columnDefinition = "NVARCHAR(MAX)")
	private String tenPhuongXa;

	@Column(name = "cap_hanh_chinh", columnDefinition = "NVARCHAR(MAX)")
	private String capHanhChinh;

	@Column(name = "quan_huyen_id")
	private String maQuanHuyen;

}
