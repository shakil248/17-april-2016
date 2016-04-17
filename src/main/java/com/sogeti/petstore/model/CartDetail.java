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
@Table(name="CART_DETAIL")
public class CartDetail extends BaseModel {
	
	
	@Id
    @Column(name="cart_detail_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cartDetailId;
	
	@Column(name="product_Id")
	private String productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_price")
	private String productPrice;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="sku")
	private String sku;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="cart_Id")
	@JsonBackReference
	private Cart cart;
	
	public String getCartDetailId() {
		return cartDetailId;
	}
	public void setCartDetailId(String cartDetailId) {
		this.cartDetailId = cartDetailId;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
}
