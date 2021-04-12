package com.websitenhaccu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OrderDetails")
@IdClass(OrderDetail_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
	
	@Id
    @ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "order_id")
	private Order order;
	
	private double price;
	
	private int quantity;
}
