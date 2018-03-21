package com.donorsClub.models;

import java.util.Date;

public class Interest extends Model{

	//Fields
	private long id;
	private int userId;
	private int itemId;
	private short seen;
	private Date createdAt;
	private Date updatedAt;
	
	private Item item;
	
	public Interest() {
		this.item = new Item();
	}
	public Interest(Item item) {
		this.item = item;
	}

	public void setId(long id){
		this.id = id;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public void setItemId(int itemId){
		this.itemId = itemId;
	}

	public void setSeen(short seen){
		this.seen = seen;
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

	public int getUserId(){
		return this.userId;
	}

	public int getItemId(){
		return this.itemId;
	}

	public short getSeen(){
		return this.seen;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
