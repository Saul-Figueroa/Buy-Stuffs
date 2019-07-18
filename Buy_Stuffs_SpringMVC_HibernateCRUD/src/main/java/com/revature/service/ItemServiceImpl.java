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
	public void deleteItemById(long itemId) {
		new ItemDAOImpl().deleteItemById(itemId);
	}
	
//	@Override
	@Transactional
	public List<Item> listAllItems() {
		List<Item> listItem = itemDAO.getAllItems();
		System.out.println("list in service: " + listItem);
		return listItem;
	}

//	@Override
//	public void createItem(Item item) {
//		new ItemDAOImpl().addItem(item);
//
//	}
//
//	@Override
//	public Item getItemById(long itemId) {
//		return new ItemDAOImpl().fetchItemById(itemId);
//	}
//
//	@Override
//	public void updateItemById(long itemId, float price) {
//		new ItemDAOImpl().updateItemById(itemId, price);
//
//	}
//
//	@Override
//	public void deleteItemById(long itemId) {
//		new ItemDAOImpl().deleteItemById(itemId);
//	}

}
