package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TinhThanhs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinhThanh {

	@Id
	@Column(name = "tinh_thanh_id")
	private String id;

	@Column(name = "ten_tinh_thanh", columnDefinition = "NVARCHAR(MAX)")
	private String tenTinhThanh;
	
	@Column(name = "cap_hanh_chinh", columnDefinition = "NVARCHAR(MAX)")
	private String capHanhChinh;

}
