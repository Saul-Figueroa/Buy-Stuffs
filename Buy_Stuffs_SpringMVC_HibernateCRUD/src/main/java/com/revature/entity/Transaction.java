package com.revature.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTIONS")

public class Transaction {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "description", length = 200)
	private String description;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "amount")
	private double amount;
	
	// FK for item/transaction (many transactions can have the same item)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "itemid")
	private Item itemid;

	public Transaction() { }

	
	public Transaction(String description, int quantity, double amount, Item itemid) {
		this.description = description;
		this.quantity = quantity;
		this.amount = amount;
		this.itemid = itemid;
	}
	
	public Transaction(String description, int quantity, double amount) {
		this.description = description;
		this.quantity = quantity;
		this.amount = amount;

	}
	
	public Transaction(int id, String description, int quantity, double amount, Item itemid) {
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.amount = amount;
		this.itemid = itemid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Item getItemid() {
		return itemid;
	}


	public void setItemid(Item itemid) {
		this.itemid = itemid;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", description=" + description + ", quantity=" + quantity + ", price=" + price
				+ ", amount=" + amount + ", itemid=" + itemid + "]";
	}


	

}
