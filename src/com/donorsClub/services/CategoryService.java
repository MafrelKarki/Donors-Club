package com.donorsClub.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

import com.donorsClub.daos.CategoryDao;
import com.donorsClub.daos.ItemCategoryDao;
import com.donorsClub.daos.ItemDao;
import com.donorsClub.daos.PictureDao;
import com.donorsClub.models.Category;
import com.donorsClub.models.Item;
import com.donorsClub.models.ItemCategory;
import com.donorsClub.models.Picture;

/**
 * 
 * @author shiko
 *
 */
public class CategoryService {

	public List<Category> GetAllCategory() {

		CategoryDao categoryDao = new CategoryDao();
		return categoryDao.findAll();
	}


}
