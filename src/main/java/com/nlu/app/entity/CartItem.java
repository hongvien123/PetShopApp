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
	
	@Column
	private Integer quantity;
	
	@Column
	private Double total;

	public CartItem() {}

	public CartItem(Long id, Product product, User user, Integer quantity) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}

	public CartItem(Product product) {
		super();
		this.product = product;
	}
	

	public CartItem(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public CartItem(Long id, Product product, User user, Integer quantity, Double total) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.total = total;
	}
	

	public CartItem(Product product, Integer quantity, Double total) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.total = total;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
