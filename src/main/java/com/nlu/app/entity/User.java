package com.nlu.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id //not null and primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
	@Column
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String image;
	@Column
	private String fistname;
	@Column
	private String lastname;
	@Column
	private String address;
	@Column
	private String email;
	@Column(name="phoneNumber")
	private String phoneNumber;
	@Column
	private boolean admin;
	
	public User() {
	}
	public User(Long id, String username, String password, String image, String fistname, String lastname,
			String address, String email, String phoneNumber, boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.image = image;
		this.fistname = fistname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.admin = admin;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFistname() {
		return fistname;
	}
	public void setFistname(String fistname) {
		this.fistname = fistname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public Long getId() {
		return id;
	}
	

}
