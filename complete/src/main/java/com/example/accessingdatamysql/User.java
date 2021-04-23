package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.net.InetAddress;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@ConfigurationProperties
@Entity // This tells Hibernate to make a table out of this class
@Validated
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer id;
	
	@NotEmpty(message = "Name may not be empty") 
	private String name;
	
	@NotEmpty(message = "Email may not be empty") 
	@Email(message = "Email should be valid")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public DTOuser daoToDto() {
		DTOuser u = new DTOuser();
    		u.setId(id);
    		u.setName(name);
    		u.setEmail(email);
    		return u;
	}

}
