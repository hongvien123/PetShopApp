package com.nlu.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
	@Id //not null and primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
	@Column
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	private User user;
	
	private int quantity;

	public CartItem() {}

	public CartItem(Long id, Product product, User user, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
