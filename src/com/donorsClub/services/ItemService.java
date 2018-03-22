package com.donorsClub.services;

import java.util.Date;

import com.donorsClub.daos.ItemCategoryDao;
import com.donorsClub.daos.ItemDao;
import com.donorsClub.daos.PictureDao;
import com.donorsClub.daos.UserDao;
import com.donorsClub.models.Item;
import com.donorsClub.models.ItemCategory;
import com.donorsClub.models.Picture;
import com.donorsClub.models.User;

public class ItemService {

	public long InsertUpdateItem(String itemName, String description, String photo1, String photo2, String photo3,
			String photo4, String photo5, long categoryId, User user, long myItemId) {

		System.out.println(photo1);
		Item item = new Item();
		Date createdAt = new Date();
		item.setItemName(itemName);
		item.setDescription(description);
		item.setCreatedAt(createdAt);
		item.setUpdatedAt(createdAt);
		item.setUserId(user.getUserId());
		ItemDao itmdao = new ItemDao();
		long itemId = myItemId;
		if (myItemId == 0) {
			itemId = itmdao.insert(item);
			item.setItemId(itemId);
		} else {
			item.setItemId(itemId);
			itmdao.update(item);
			itmdao = new ItemDao();
			item = (Item) itmdao.findById(itemId);

		}

		Picture pic;
		PictureDao pDao = new PictureDao();
		if (myItemId != 0) {
			for (int i = 0; i < item.getPictureList().size(); i++) {
				pDao.delete(item.getPictureList().get(i));
			}
		}
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

		if (myItemId != 0) {
			for (int i = 0; i < item.getItemCategoryList().size(); i++) {
				new ItemCategoryDao().delete(item.getItemCategoryList().get(i));
			}
		}
		ItemCategory ic;

		ItemCategoryDao itmcDao = new ItemCategoryDao();
		ic = new ItemCategory();
		ic.setItemId(itemId);
		ic.setCreatedAt(createdAt);
		ic.setUpdatedAt(createdAt);
		ic.setCategoryId(categoryId);
		itmcDao.insert(ic);
		

		/*
		 * for (int i = 0; i < 5; i++) { ic=new ItemCategory(); ic.setItemId(itemId);
		 * ic.setUpdatedAt(createdAt); ic.setCategoryId(5); itmDao.insert(ic); }
		 */

		return itemId;

	}

	public Item getItem(long itemId) {
		ItemDao itmDao = new ItemDao();
		return (Item) itmDao.findById(itemId);
	}

}
