package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.Item;

@Repository("ItemDAO")
public class ItemDAOImpl implements ItemDAO {
	@Autowired
	SessionFactory sessionFactory;

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
