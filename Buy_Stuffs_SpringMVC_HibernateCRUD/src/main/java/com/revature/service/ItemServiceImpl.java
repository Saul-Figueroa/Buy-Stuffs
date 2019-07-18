package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ItemDAOImpl;
import com.revature.entity.Item;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAOImpl itemDAO;

	@Override
	@Transactional
	public void addItem(Item item) {
		itemDAO.addItem(item);
	}

	@Override
	@Transactional
	public List<Item> getAllItems() {
		List<Item> items = itemDAO.getAllItems();		
		return items;
	}

	@Override
	@Transactional
	public Item fetchItemById(int itemId) {
		Item item = itemDAO.fetchItemById(itemId);
		return item;
	}

	@Override
	@Transactional
	public void deleteItemById(int itemId) {
		itemDAO.deleteItemById(itemId);
	}
	
	

}
