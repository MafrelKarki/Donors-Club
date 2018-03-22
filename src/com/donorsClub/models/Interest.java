package com.donorsClub.models;

import java.util.Date;

/**
 * @author Mafrel
 *
 */
public class Interest extends Model {

  // Fields
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

  public void setId(long id) {
    this.id = id;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public void setSeen(short seen) {
    this.seen = seen;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public long getId() {
    return this.id;
  }

  public int getUserId() {
    return this.userId;
  }

  public int getItemId() {
    return this.itemId;
  }

  public short getSeen() {
    return this.seen;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
  
  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((item == null) ? 0 : item.hashCode());
    result = prime * result + itemId;
    result = prime * result + seen;
    result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
    result = prime * result + userId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    
    if (this.getClass() != obj.getClass())
        return false;
    
    Interest other = (Interest) obj;
    if (createdAt == null) {
      if (other.createdAt != null)
        return false;
    } else if (!createdAt.equals(other.createdAt))
      return false;
    
    if (id != other.id)
      return false;
    if (item == null) {
      if (other.item != null)
        return false;
    } else if (!item.equals(other.item))
      return false;
    
    if (itemId != other.itemId)
      return false;
    
    if (seen != other.seen)
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
    return "Interest [id=" + id + ", userId=" + userId + ", itemId=" + itemId + ", seen=" + seen
        + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", item=" + item + "]";
  }



}
