package com.lifeisbeautiful.shareyourthoughts.api.mongo;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	private String id;

	@NotBlank
	@Size(min = 4, max = 200, message = "User name should be between 4 and 200 chars")
	private String userName;

	@NotBlank
	@Size(min = 4, max = 200, message = "Password should be between 4 and 200 chars")
	private String password;

	@Indexed(unique = true)
	@NotBlank
	@Email
	private String email;
	
	public User() {};
	public User(String id) {
		this.id = id;
	}
	
	//Getter Setter Start
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//Getter Setter Ends

}
