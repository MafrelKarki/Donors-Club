package com.donorsClub.models;

import java.util.Date;

public class ItemCategory extends Model{

	//Fields
	private long id;
	private long itemId;
	private long categoryId;
	private Date createdAt;
	private Date updatedAt;

	private Category category;
	
	public ItemCategory() {
		this.category = new Category();
	}
	
	public ItemCategory(Category category) {
		this.category = category;
	}
	
	public void setId(long id){
		this.id = id;
	}


	public void setItemId(long itemId){
		this.itemId = itemId;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}

	public long getId(){
		return this.id;
	}

	public long getItemId(){
		return this.itemId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}


	

}
