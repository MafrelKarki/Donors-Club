package com.donorsClub.services;

import java.util.ArrayList;
import java.util.List;

import com.donorsClub.daos.ItemDao;
import com.donorsClub.models.Item;
import com.donorsClub.models.User;

/**
 * 
 * 
 * @author Sherif
 *
 */
public class ViewItemService {
	
	public List<Item> getAllItem(User user) {
		
		ItemDao itmDao=new ItemDao();		
		return itmDao.getUserItem(user.getUserId());
		
	}

	public void DeleteItem(long itemId) {
		
		ItemDao itmDao=new ItemDao();
		
		Item item=(Item)itmDao.findById(itemId);
		item.setStatus((short)1);
		
		new ItemDao().update(item);
		
		
	}

}
