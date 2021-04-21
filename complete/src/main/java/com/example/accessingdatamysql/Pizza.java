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

@ConfigurationProperties
@Entity // This tells Hibernate to make a table out of this class
@Validated
public class Pizza {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer id;
	
	@NotEmpty(message = "Name may not be empty") 
	private String name;
	
	
	private double price;
	
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
