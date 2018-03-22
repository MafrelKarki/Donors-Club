package com.donorsClub.models;

import java.util.List;

public class ItemInfo {

	private Item item;
	private List<Interest> interest;
	private User user;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public List<Interest> getInterest() {
		return interest;
	}
	public void setInterest(List<Interest> interest) {
		this.interest = interest;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
