package com.websitenhaccu.entity;

import java.sql.Date;
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
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@Column(name = "order_id")
	private String orderId;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "ship_address")
	private String shipAddress;

	@Column(name = "phone")
	private String phone;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "order")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<OrderDetail> details = new ArrayList<OrderDetail>();

}
