package com.donorsClub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.donorsClub.daos.ItemDao;
import com.donorsClub.models.Item;

/**
 * 
 * Search service class
 * @author Edward T. Tanko
 *
 */
public class SearchPostService {

	public List<Item> searchPost(String keyWord){
		String[] keys = keyWord.split(" ");
		List<Item> items = new ArrayList<>();
		for(int i = 0;i<keys.length;i++) {
			ItemDao itmDoa = new ItemDao();
			items.addAll(itmDoa.searchPost(keys[i]));
		}
		return items.stream().distinct().collect(Collectors.toList());
	}
	
	public List<Item> getMostInterestedItem(int limit){
		List<Item> items = new ArrayList<>();
		ItemDao itmDoa = new ItemDao();
		items = itmDoa.getMostInterestedItems(limit);
		return items;
	}
	
}
