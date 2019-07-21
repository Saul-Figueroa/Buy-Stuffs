package com.revature.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	//Many to One FK for Vendor(the person who register the product), One vendor can have many items
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clientid")
	private Client clientid;
	
	public Item() {}
	
	public Item(int id, String name, String description, double price, int quantity, Client clientid) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.clientid = clientid;
	}

	public Item(int id, String name, String description, double price) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Item(String name, String description, double price,int quantity, Client clientid ) {
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.clientid = clientid;
		
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
	
	

	public Client getClientid() {
		return clientid;
	}

	public void setClientid(Client clientid) {
		this.clientid = clientid;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", quantity="
				+ quantity + ", clientid=" + clientid + "]";
	}

}
