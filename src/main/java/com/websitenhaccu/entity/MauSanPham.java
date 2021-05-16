package com.websitenhaccu.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Mau_SanPhams")
@IdClass(MauSanPham_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MauSanPham implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mau_id")
	private Mau mau;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "san_pham_id")
	private SanPham sanPham;

	@Column(name = "so_luong")
	private int soLuong;
	
	@Lob
	@Column(name = "hinh_anh")
	private Blob hinhAnh;

}
