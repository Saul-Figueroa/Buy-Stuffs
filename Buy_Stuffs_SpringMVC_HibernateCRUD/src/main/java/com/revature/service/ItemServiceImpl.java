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
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item fetchItemById(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item deleteItemById(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
