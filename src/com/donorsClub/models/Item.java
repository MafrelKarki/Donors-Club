package com.donorsClub.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Item extends Model{

	//Fields
	private long itemId;
	private long userId;
	private String itemName;
	private String description;
	private short status;
	private Date createdAt;
	private Date updatedAt;
	
	private int interestCount;
	
	private List<Picture> pictureList;
	private List<ItemCategory> itemCategoryList;
	
	public Item() {
		super();
		this.pictureList = new ArrayList<>();
		this.itemCategoryList = new ArrayList<>();
	}

	public void setItemId(long itemId){
		this.itemId = itemId;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public void setStatus(short status){
		this.status = status;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}

	public long getItemId(){
		return this.itemId;
	}

	public String getItemName(){
		return this.itemName;
	}

	public String getDescription(){
		return this.description;
	}

	public short getStatus(){
		return this.status;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}

	public List<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}
	
	public void addPicture(Picture picture) {
		this.pictureList.add(picture);
	}

	public List<ItemCategory> getItemCategoryList() {
		return itemCategoryList;
	}

	public void setItemCategoryList(List<ItemCategory> itemCategoryList) {
		this.itemCategoryList = itemCategoryList;
	}
	public void addItemCategoryList(ItemCategory itemCategory) {
		this.itemCategoryList.add(itemCategory);
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public int getInterestCount() {
		return interestCount;
	}
	
	public void setInterestCount(int interestCount) {
		this.interestCount = interestCount;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", userId=" + userId + ", itemName=" + itemName + ", description="
				+ description + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", pictureList=" + pictureList + ", itemCategoryList=" + itemCategoryList + "]";
	}

	
	
	
}
