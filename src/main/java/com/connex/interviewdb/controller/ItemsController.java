package com.connex.interviewdb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connex.interviewdb.controller.model.Item;
import com.connex.interviewdb.repository.ItemsRepository;

@RestController
@RequestMapping("/api")
public class ItemsController {
	@Autowired
	ItemsRepository itemRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void initDB() {
		if(itemRepository.count()<=0) {
		// Item 1: Classic Staple
		itemRepository.save(new Item("Red Apple", "Sweet and crisp red apple, perfect for snacking.", 0.99, 50));

		// Item 2: Tropical Delight
		itemRepository.save(new Item("Mango", "Juicy and flavorful mango with a vibrant orange hue.", 2.49, 20));

		// Item 3: Citrus Burst
		itemRepository.save(new Item("Orange", "Tangy and refreshing orange, packed with vitamin C.", 0.79, 40));

		// Item 4: Summer Favorite
		itemRepository.save(new Item("Watermelon", "Large, hydrating watermelon slice.", 4.99, 5));

		// Item 5: Antioxidant Power 
		itemRepository.save(new Item("Blueberries", "A handful of sweet and nutritious blueberries.", 3.49, 30)); 
		}
	}
	
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems() {
		try {
			List<Item> items = new ArrayList<Item>();

			items = itemRepository.findAll();
			if (items.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	  @PostMapping("/items")
	  public ResponseEntity<Item> createItem(@RequestBody Item item) {
	    try {
	    	Item item_t = itemRepository.save(item);
	      return new ResponseEntity<>(item_t, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  
	  /**
	   * TODO 1 Implement Update  
	   * @PutMapping("/items/{id}")
	   */
	  
	  /**
	   * TODO 1 Implement Delete  
	   * @DeleteMapping("/items/{id}")
	   */


	  
	  /**
	   * TODO 3: Add the Search Functionality
	   * 
	   * Objective:
	   * update the @GetMapping("/items") implementation to add search for items by their name. The method should handle requests to the "/items" endpoint, 
	   * allowing users to search for items either by specifying a name or not. When a name is provided in the request, 
	   * the method should return items whose names contain the specified string, ignoring case sensitivity. If no name is provided, 
	   * the method should return all items.
	   * Example Usage:
	   * 
	   * To call the implemented endpoint, you can use HTTP GET requests. Here are two examples on how to do it:
	   * 
	   * 1. To retrieve all items without filtering by name:
	   *    GET /api/items
	   *    This request does not include the 'name' parameter and thus should return all available items.
	   * 
	   * 2. To search for items by name:
	   *    GET /api/items?name=apple
	   *    This request includes the 'name' parameter with the value 'apple'. The method should return items whose names contain 'apple', 
	   *    ignoring case sensitivity. For example, it should return items named 'Red Apple', 'Green Apple', etc.
	   * 
	   */


}
