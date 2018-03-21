package com.donorsClub.services;

import java.util.ArrayList;
import java.util.List;

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
		List<Item> items = new ArrayList<>();
		ItemDao itmDoa = new ItemDao();
		items = itmDoa.searchPost(keyWord);
		return items;
	}
	
	public List<Item> getMostInterestedItem(int limit){
		List<Item> items = new ArrayList<>();
		ItemDao itmDoa = new ItemDao();
		items = itmDoa.getMostInterestedItems(limit);
		return items;
	}
	
}
