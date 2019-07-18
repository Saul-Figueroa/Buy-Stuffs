package com.revature.service;

import java.util.List;

import com.revature.entity.Item;

public interface ItemService {
	
	//Save and update	
	public void addItem(Item item);	
	public List<Item>  getAllItems();
	public Item fetchItemById(int itemId);
	public Item deleteItemById(int itemId);

}
