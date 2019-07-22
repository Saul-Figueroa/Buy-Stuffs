package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.Item;

@Repository("ItemDAO")
public class ItemDAOImpl implements ItemDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addItem(Item item) {
		sessionFactory.getCurrentSession().saveOrUpdate(item);
		System.out.println("Item added succesfully");
		
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> itemList = new ArrayList<>();

		
		Query query = sessionFactory.getCurrentSession().createQuery("from Item order by id");
		query.setMaxResults(100);
		itemList = (ArrayList<Item>) query.list();
		System.out.println("List in DAO "+itemList);
		
		
		return itemList;
	}

	@Override
	public Item fetchItemById(int itemId) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("Book in DAO "+itemId);
		Item item = currentSession.get(Item.class, itemId);
		return item;	
	}

	@Override
	public void deleteItemById(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		Item item = session.byId(Item.class).load(itemId);
		System.out.println("Delete called from dao "+item);
		session.delete(item);
	}

	
}
