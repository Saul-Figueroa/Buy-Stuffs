package com.revature.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", length=50)
	private String name;
	
	@Column(name="description", length=50)
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="quantity")
	private int quantity;
	
	//Many to One FK for Vendor(the person who register the product), many items can have the same vendor
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User userid;
	
	public Item() {}
	
	public Item(int id, String name, String description, double price, int quantity, User userid) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.userid = userid;
	}

	public Item(int id, String name, String description, double price) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Item(String name, String description, double price,int quantity, User userid ) {
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.userid = userid;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", quantity="
				+ quantity + ", userid=" + userid + "]";
	}


}
