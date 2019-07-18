package com.revature.service;

import java.util.List;

import com.revature.entity.Item;

public interface ItemService {
	
	public List<Item> listAllItems();
//	public void createItem(Item item);
//	public Item getItemById(long itemId);
//	public void updateItemById(long itemId, double price);
	public void deleteItemById(long itemId);

}
