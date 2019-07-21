package com.revature.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@Column(name = "amount")
	private double amount;
	
	//OneToOne FK for item
	@OneToOne(cascade = CascadeType.ALL)
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + quantity;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", description=" + description + ", quantity=" + quantity + ", amount="
				+ amount + ", itemid=" + itemid + "]";
	}


	

}
