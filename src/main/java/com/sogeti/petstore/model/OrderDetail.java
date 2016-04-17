package com.sogeti.petstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ORDER_DETAIL")
public class OrderDetail {

	
	@Id
    @Column(name="order_detail_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String orderDetailId;
	
	@Column(name="product_id")
	private String productId;

	@Column(name="quantity")
	private Integer quantity;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	@JsonBackReference
	private Order order;

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
}
