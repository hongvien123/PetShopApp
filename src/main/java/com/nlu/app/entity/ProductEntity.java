package com.nlu.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	@Id //not null and primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
	@Column
	private Long id;
	@Column
	private String name; //ten sp
	@Column
	private Long amount; //so luong co trong kho
	@Column
	private Date date; //ngay nhap hang
	@Column
	private boolean status; //trang thai: con hang hay het hang
	@Column
	private Integer discount; //giam gia 
	@Column
	private Double price; //gia ban
	@Column
	private String image; //hinh anh
	@Column
	private Integer sold; //so luong da ban ra
	@Column
	private String category; //phan loai
	@Column
	private String object; //doi tuong su dung: cho meo hoac khac
	
	public ProductEntity() {
	}
	
	public ProductEntity(String name, double i) {
		super();
		this.name = name;
		this.price = i;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", amount=" + amount + ", date=" + date + ", status="
				+ status + ", discount=" + discount + ", price=" + price + ", image=" + image + ", sold=" + sold
				+ ", category=" + category + ", object=" + object + "]";
	}

	public ProductEntity(Long id, String name, Long amount, Date date, boolean status, Integer discount, Double price,
			String image, Integer sold, String category, String object) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.date = date;
		this.status = status;
		this.discount = discount;
		this.price = price;
		this.image = image;
		this.sold = sold;
		this.category = category;
		this.object = object;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}
	
	
}
