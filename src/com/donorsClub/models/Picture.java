package com.donorsClub.models;

import java.util.Date;

public class Picture extends Model{

	//Fields
	private long pictureId;
	private String path;
	private Date createdAt;
	private Date updatedAt;
	private long itemId;

	public void setPictureId(long pictureId){
		this.pictureId = pictureId;
	}

	public void setPath(String path){
		this.path = path;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}

	public void setItemId(long itemId){
		this.itemId = itemId;
	}

	public long getPictureId(){
		return this.pictureId;
	}

	public String getPath(){
		return this.path;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}

	public long getItemId(){
		return this.itemId;
	}


}
