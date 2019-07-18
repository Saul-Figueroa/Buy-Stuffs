package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.entity.Item;
import com.revature.service.ItemService;

@Controller
@RequestMapping("/ItemController")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/itemdelete")
	public String delete(Model model) {
//		List<Item> itemList = itemService.listAllItems();
//		System.out.println("List is :");
//		itemList.forEach(System.out::println);
		return "itemDelete";
	}
	
	@GetMapping("/itemlist")
	public String hello(Model model) {
		List<Item> itemList = itemService.listAllItems();
		System.out.println("List is :");
		itemList.forEach(System.out::println);
		return "itemList";
	}


	public ItemController() {
		// TODO Auto-generated constructor stub
	}

}
