package com.donorsClub.models;

import java.util.Date;

public class Category extends Model{

	//Fields
	private long categoryId;
	private String categoryName;
	private Date createdAt;
	private Date updatedAt;

	public void setCategoryId(long categoryId){
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}

	public long getCategoryId(){
		return this.categoryId;
	}

	public String getCategoryName(){
		return this.categoryName;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}


}
