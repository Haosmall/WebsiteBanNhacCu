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
@Table(name = "Districts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
	
	@Id
	@Column(name = "district_id")
	private int districtId;
	
	@Column(name = "district_name")
	private String districtName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "province_id")
	private Province province;
	
	
	@OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Ward> wards = new ArrayList<Ward>();

}
