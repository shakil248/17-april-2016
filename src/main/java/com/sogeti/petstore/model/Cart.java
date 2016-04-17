package com.sogeti.petstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="CART")
public class Cart extends BaseModel{
	
	@Id
    @Column(name="cart_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cartId;
	
	@Column(name="email_Id")
	private String emailId;
		
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="cart_Id")
	@JsonManagedReference
	private List<CartDetail> cartDetails;
	
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
