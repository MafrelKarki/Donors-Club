package com.donorsClub.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.donorsClub.daos.InterestDao;

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

public List<Interest> getInterests() {
		
		return new InterestDao().getItemInterests(getItemId());

	}

	
	@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + interestCount;
	result = prime * result + ((itemCategoryList == null) ? 0 : itemCategoryList.hashCode());
	result = prime * result + (int) (itemId ^ (itemId >>> 32));
	result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
	result = prime * result + ((pictureList == null) ? 0 : pictureList.hashCode());
	result = prime * result + status;
	result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
	result = prime * result + (int) (userId ^ (userId >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Item other = (Item) obj;
	if (createdAt == null) {
		if (other.createdAt != null)
			return false;
	} else if (!createdAt.equals(other.createdAt))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (interestCount != other.interestCount)
		return false;
	if (itemCategoryList == null) {
		if (other.itemCategoryList != null)
			return false;
	} else if (!itemCategoryList.equals(other.itemCategoryList))
		return false;
	if (itemId != other.itemId)
		return false;
	if (itemName == null) {
		if (other.itemName != null)
			return false;
	} else if (!itemName.equals(other.itemName))
		return false;
	if (pictureList == null) {
		if (other.pictureList != null)
			return false;
	} else if (!pictureList.equals(other.pictureList))
		return false;
	if (status != other.status)
		return false;
	if (updatedAt == null) {
		if (other.updatedAt != null)
			return false;
	} else if (!updatedAt.equals(other.updatedAt))
		return false;
	if (userId != other.userId)
		return false;
	return true;
}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", userId=" + userId + ", itemName=" + itemName + ", description="
				+ description + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", pictureList=" + pictureList + ", itemCategoryList=" + itemCategoryList + "]";
	}

	
	
	
}
