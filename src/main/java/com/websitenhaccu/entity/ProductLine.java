package com.websitenhaccu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProductLines")
@IdClass(ProductLine_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brand_id")
	Brand brand;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	Category category;

	@Column(name = "line_name", columnDefinition = "NVARCHAR(MAX)")
	private String lineName;

	@Column(name = "tax")
	private float tax;

}
