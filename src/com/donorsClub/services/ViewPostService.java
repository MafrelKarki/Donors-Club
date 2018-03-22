package com.donorsClub.services;

import java.util.List;

import com.donorsClub.daos.InterestDao;
import com.donorsClub.daos.ItemDao;
import com.donorsClub.daos.UserDao;
import com.donorsClub.models.Interest;
import com.donorsClub.models.Item;
import com.donorsClub.models.ItemInfo;
import com.donorsClub.models.User;

public class ViewPostService {

	public ItemInfo getItemInfo(long itemId) {
	
		ItemInfo itemInfo = new ItemInfo();
		Item item = (Item) new ItemDao().findById(itemId);
		List<Interest> interest = (List<Interest>) new InterestDao().getItemInterests(item.getItemId());
		User user = (User) new UserDao().findById(item.getUserId());
		
		itemInfo.setInterest(interest);
		itemInfo.setItem(item);
		itemInfo.setUser(user);
		
		return itemInfo;
	}
}
