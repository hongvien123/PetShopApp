package com.nlu.app.entity;

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
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
	@Id //not null and primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
	@Column
	private Long id;
	@Column
	private String name; //ten loai sp
	@Column
	private String description;
	public CategoryEntity(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public CategoryEntity(String name) {
		super();
		
		this.name = name;
	}
	public CategoryEntity() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	

}
