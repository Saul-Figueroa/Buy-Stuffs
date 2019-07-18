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
	public void deleteItemById(long itemId) {
//		Item item = session.get(Item.class, itemId);
//		if (item != null) {
//			session.beginTransaction();
//			session.delete(item);
//			session.getTransaction().commit();
//		} else {
//			System.out.println("Item doesn't exist with provided Id...");
//		}
	}

	public List<Item> getAllItems() {
		ArrayList<Item> itemList = new ArrayList<>();

		Query query = sessionFactory.getCurrentSession().createQuery("from Item");
		query.setMaxResults(3);
		itemList = (ArrayList<Item>) query.getResultList();
		System.out.println("list in DAO " + itemList);
		return itemList;
	}

//	@Override
//	public void addItem(Item item) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			session.beginTransaction();
//			System.out.println("Item Id in Service: " + item);
//			long id = (long)session.save(item);
//			System.out.println("Item is created with Id: " + id);
//			session.getTransaction().commit();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public Item fetchItemById(long itemId) {
//		Item item = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			
//			item = session.get(Item.class, itemId); //Returns null pointer exception if ID doesn't match
//			
//			System.out.println("Item Id was :" + itemId + "Object is " + item.getTitle());
//			if (item != null) {
//				return item;
//			} else {
//				System.out.println("Item doesn't exist with provided Id...");
//			}
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public void deleteItemById(long itemId) {
//		
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Item item = session.get(Item.class, itemId);
//			if (item != null) {
//				session.beginTransaction();
//				session.delete(item);
//				session.getTransaction().commit();
//			} else {
//				System.out.println("Item doesn't exist with provided Id...");
//			}
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void updateItemById(long itemId, Float price) { //This example is specifically for updating price
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Item item = session.get(Item.class, itemId);
//			if (item != null) {
//				item.setPrice(price);
//				session.beginTransaction();
//				System.out.println("Item updated: " + item);
//				session.update(item);
//				session.getTransaction().commit();
//			} else {
//				System.out.println("Item doesn't exist with provided Id...");
//			}
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		
//	}
}
