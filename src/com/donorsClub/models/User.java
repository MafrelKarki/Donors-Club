package com.donorsClub.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends Model{

	//Fields
	private long userId;
	private String fname;
	private String lname;
	private String email;
	private short status;
	private String password;
	private String phoneNumber;
	private String address;
	private int userType;
	private Date createdAt;
	private Date updatedAt;
	private String picture;
	
	private List<Item> itemList;
	private List<Interest> interestList;
	
	public User() {
		super();
		this.itemList = new ArrayList<>();
		this.interestList = new ArrayList<>();
	}

	public void setUserId(long userId){
		this.userId = userId;
	}

	public void setFname(String fname){
		this.fname = fname;
	}

	public void setLname(String lname){
		this.lname = lname;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setStatus(short status){
		this.status = status;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setUserType(int userType){
		this.userType = userType;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public long getUserId(){
		return this.userId;
	}

	public String getFname(){
		return this.fname;
	}

	public String getLname(){
		return this.lname;
	}

	public String getEmail(){
		return this.email;
	}

	public short getStatus(){
		return this.status;
	}

	public String getPassword(){
		return this.password;
	}

	public String getPhoneNumber(){
		return this.phoneNumber;
	}

	public String getAddress(){
		return this.address;
	}

	public int getUserType(){
		return this.userType;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}

	public String getPicture(){
		return this.picture;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public void addItem(Item item) {
		this.itemList.add(item);
	}
	
	public List<Interest> getInterestList() {
		return interestList;
	}

	public void setInterestList(List<Interest> interestList) {
		this.interestList = interestList;
	}
	
	public void addInterestList(Interest interest) {
		this.interestList.add(interest);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", status="
				+ status + ", password=" + password + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", userType=" + userType + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", picture="
				+ picture + "]";
	}

	
	

}
