package com.donorsClub.services;

import java.util.Date;

import com.donorsClub.daos.ItemCategoryDao;
import com.donorsClub.daos.ItemDao;
import com.donorsClub.daos.PictureDao;
import com.donorsClub.models.Item;
import com.donorsClub.models.ItemCategory;
import com.donorsClub.models.Picture;

public class ItemService {


	

	public void InsertItem(String itemName, String description, String photo1, String photo2, String photo3,
			String photo4, String photo5, long categoryId ,long userId) {

		System.out.println(photo1);
		Item item = new Item();
		Date createdAt=new Date();
		item.setItemName(itemName);
		item.setDescription(description);
		item.setCreatedAt(createdAt);
		item.setUpdatedAt(createdAt);
		item.setUserId(userId);
		
		ItemDao idao = new ItemDao();
		long itemId = idao.insert(item);
		Picture pic ;
		PictureDao pDao = new PictureDao();
		if (!photo1.isEmpty()) {
			pic = new Picture();
			pic.setItemId(itemId);
			pic.setPath(photo1);
			pic.setCreatedAt(createdAt);
			pic.setUpdatedAt(createdAt);
			pDao.insert(pic);
		}

		if (!photo2.isEmpty()) {
			pic = new Picture();
			pic.setItemId(itemId);
			pic.setPath(photo2);
			pic.setCreatedAt(createdAt);
			pic.setUpdatedAt(createdAt);
			pDao.insert(pic);
		}
		if (!photo3.isEmpty()) {
			pic = new Picture();
			pic.setItemId(itemId);
			pic.setPath(photo3);
			pic.setCreatedAt(createdAt);
			pic.setUpdatedAt(createdAt);
			pDao.insert(pic);
		}
		if (!photo4.isEmpty()) {
			pic = new Picture();
			pic.setItemId(itemId);
			pic.setPath(photo4);
			pic.setCreatedAt(createdAt);
			pic.setUpdatedAt(createdAt);
			pDao.insert(pic);
		}
		if (!photo5.isEmpty()) {
			pic = new Picture();
			pic.setItemId(itemId);
			pic.setPath(photo5);
			pic.setCreatedAt(createdAt);
			pic.setUpdatedAt(createdAt);
			pDao.insert(pic);
		}
		
		ItemCategory ic;
		
		ItemCategoryDao itmDao=new ItemCategoryDao();
		System.out.println("1111122222ss");
		ic=new ItemCategory();
		ic.setItemId(itemId);
		ic.setCreatedAt(createdAt);
		ic.setUpdatedAt(createdAt);
		ic.setCategoryId(categoryId);
		itmDao.insert(ic);
		
		/*for (int i = 0; i < 5; i++) {
			ic=new ItemCategory();
			ic.setItemId(itemId);
			ic.setUpdatedAt(createdAt);
			ic.setCategoryId(5);
			itmDao.insert(ic);
		}*/
	
		

	}
}
