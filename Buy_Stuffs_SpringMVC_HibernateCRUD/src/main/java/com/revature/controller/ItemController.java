package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Item;
import com.revature.service.ItemService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	//Add new item
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		
		itemService.addItem(item);
		return item;
		
	}
	//Get all items
	@GetMapping("/items")
	public List<Item> getAllItems() {
		
		System.out.println("Entered list items");
		List<Item> items= itemService.getAllItems();
		
		System.out.println("List: "+items);
		
		if (items == null) {
			return null;
		}
		
		return items;
	}
	
	//Get item by id
	@GetMapping("/items/{id}")
	public Item findItem(@PathVariable int id)
	{
		
		return null;
		
	}
	//Delete item
	@RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
	public String deleteItem(@PathVariable ("id") int id) {
		
		
		return null;
		
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.PUT)
	public String updateItem(@RequestBody Item item) {
		
		return null;
		
	}
	
	
	

}
