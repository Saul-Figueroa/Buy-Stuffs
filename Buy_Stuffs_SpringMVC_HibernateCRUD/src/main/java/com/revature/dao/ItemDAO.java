package com.revature.dao;

import java.util.List;

import com.revature.entity.Item;

public interface ItemDAO {
	
//Save and update	
public void addItem(Item item);	
public List<Item>  getAllItems();
public Item fetchItemById(int itemId);
public void deleteItemById(int itemId);




}
