package com.websitenhaccu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Brands")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Brand {
	@Id
	@Column(name = "brand_id")
	private String brandID;
	
	@Column(name = "brand_name", columnDefinition = "NVARCHAR")
	private String brandName;
	
	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
    private List<ProductLine> productLines;

}
