package com.websitenhaccu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "QuanHuyens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuanHuyen {
	
	@Id
	@Column(name = "quan_huyen_id")
	private int id;
	
	@Column(name = "ten_quan_huyen", columnDefinition = "NVARCHAR(MAX)")
	private String tenQuanHuyen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tinh_thanh_id")
	private TinhThanh tinhThanh;
	
	@OneToMany(mappedBy = "quanHuyen", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<PhuongXa> phuongXas = new ArrayList<PhuongXa>();

}
