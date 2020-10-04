package com.init.paintingsShop.dto;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="picture")

public class Picture {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name = "date", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    //private Calendar registDate;
	 private Date registDate;
	
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;
	
	// Contructores 
	public Picture() {
	}

	public Picture(Integer id, String name, Integer price, Date registDate, Shop shop) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.registDate = registDate;
		this.shop = shop;
	}
	//  Getters & setters
	
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	




}