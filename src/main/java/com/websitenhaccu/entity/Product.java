package com.websitenhaccu.entity;

import java.sql.Blob;
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
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@Column(name = "product_id")
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private Blob image;

	@Column(name = "import_price")
	private double importPrice;

	@Column(name = "selling_price")
	private double sellingPrice;

	@Column(name = "origin")
	private String origin;

	@Column(name = "status")
	private boolean status;

	@Column(name = "warranty")
	private int warranty;

	@Column(name = "manufacture")
	private int manuFacture;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "supplierID")
	private Supplier supplier;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Comment> comments;

	@OneToMany(mappedBy = "product")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<OrderDetail> orderDetails;

//	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Product discount;

	@OneToMany(mappedBy = "product")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<AttributeValue> listAttributeValues;

	@ManyToOne
	@JoinColumn(name = "categoriID")
	private Category category;

}
