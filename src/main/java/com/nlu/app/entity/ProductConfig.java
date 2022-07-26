package com.nlu.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productConfig")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfig {
	@Id //not null and primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
	@Column
	private Long id;
	@Column
	private String image1; //hinh anh 1
	@Column
	private String image2; //hinh anh 2
	@Column
	private String image3; //hinh anh 3
	@Column
	private String image4; //hinh anh 4
	@Column
	private String description; 
	@Column
	private String infomation; 
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Product product; // biến product này sẽ trùng  với giá trị  mappedBy trong Class Product 

	public ProductConfig() {}

	public ProductConfig(Long id, String image1, String image2, String image3, String image4, String description,
			String infomation, Product product) {
		super();
		this.id = id;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.description = description;
		this.infomation = infomation;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInfomation() {
		return infomation;
	}

	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
