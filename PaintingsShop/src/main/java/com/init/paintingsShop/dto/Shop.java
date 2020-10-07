package com.init.paintingsShop.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shop")

public class Shop {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private Integer capacity;
	
	@OneToMany(cascade= CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="shop_id")
	private List<Picture> picture;
	//@Column @JsonIgnore

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public List<Picture> getPicture() {
		return picture;
	}

	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", capacity=" + capacity + ", picture="+ picture  + "]";
	}

	public Shop(Integer id, String name, Integer capacity, List<Picture> picture) {
		
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.picture = picture;
	}
	public Shop() {
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
