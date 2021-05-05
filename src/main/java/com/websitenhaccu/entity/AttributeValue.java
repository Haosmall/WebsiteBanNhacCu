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
@Table(name = "AttributeValues")
@IdClass(AttributeValue_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "attribute_id")
	private Attribute attribute;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "san_pham_id")
	private SanPham sanPham;

	@Column(name = "value", columnDefinition = "NVARCHAR(MAX)")
	private String value;

}
