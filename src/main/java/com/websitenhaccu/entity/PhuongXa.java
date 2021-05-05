package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int id;

	@Column(name = "ten_phuong_xa", columnDefinition = "NVARCHAR(MAX)")
	private String tenPhuongXa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "quan_huyen_id")
	private QuanHuyen quanHuyen;

}
