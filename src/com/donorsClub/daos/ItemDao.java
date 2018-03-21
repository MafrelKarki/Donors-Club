package com.donorsClub.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.donorsClub.models.*;

/**
 * ItemCategoryDao
 * 
 * @since 03/19/18
 * @author Edward T. Tanko
 *
 */
public class ItemDao extends Dao implements IDao {

  private final String DB_TABLE = "items";

  public ItemDao() {
    super();
  }

  /**
   * Implicit RowMapper Class
   * 
   * @author Edward T. Tanko
   *
   */
  class ItemDaoRowMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs) throws SQLException {
      Item item = new Item();
      item.setItemId((rs.getLong("item_id")));
      item.setUserId((rs.getLong("user_id")));
      item.setItemName((rs.getString("item_name")));
      item.setDescription((rs.getString("description")));
      item.setStatus((rs.getShort("status")));
      item.setCreatedAt(rs.getTimestamp("created_at"));
      item.setUpdatedAt(rs.getTimestamp("updated_at"));

      long itemId = rs.getLong("item_id");
      item.setItemCategoryList(new ItemCategoryDao().getItemCategoriesByItemId(itemId));
      item.setPictureList(new PictureDao().getItemPictures(itemId));

      return item;
    }
  }


  @Override
  public long insert(Model model) {
    Item item = (Item) model;

    String sql = String
        .format("INSERT INTO %s(user_id, item_name, description, status, created_at, updated_at) "
            + "VALUE(?,?,?,?,?,?)", this.DB_TABLE);
    String[] returnId = {"itemId"};
    long id = 0;
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql, returnId);
      statement.setLong(1, item.getUserId());
      statement.setString(2, item.getItemName());
      statement.setString(3, item.getDescription());
      statement.setShort(4, item.getStatus());
      statement.setTimestamp(5, new Timestamp(item.getCreatedAt().getTime()));
      statement.setTimestamp(6, new Timestamp(item.getUpdatedAt().getTime()));

      int st = statement.executeUpdate();
      if (st > 0) {
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
          id = rs.getInt(1);
        }
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.getConnection().close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return id;
  }

  @Override
  public boolean update(Model model) {
    Item item = (Item) model;
    String sql = String.format(
        "UPDATE %s SET user_id = ?, item_name = ?, description = ?, status =?, updated_at=? "
            + "WHERE id=?",
        this.DB_TABLE);
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, item.getUserId());
      statement.setString(2, item.getItemName());
      statement.setString(3, item.getDescription());
      statement.setShort(4, item.getStatus());
      statement.setTimestamp(5, new Timestamp(item.getUpdatedAt().getTime()));

      statement.setLong(6, item.getItemId());
      if (statement.executeUpdate() > 0)
        return true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.getConnection().close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  @Override
  public boolean delete(Model model) {
    Item item = (Item) model;
    String sql = String.format("DELETE FROM %s WHERE id=?", this.DB_TABLE);
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, item.getItemId());
      if (statement.executeUpdate() > 0)
        return true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.getConnection().close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  @Override
  public Model findById(long Id) {
    String sql = String.format("SELECT * FROM %s WHERE id = ?", this.DB_TABLE);
    Item item = null;
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, Id);
      ResultSet rs = statement.executeQuery();
      if (!rs.next())
        return null;
      item = new ItemDaoRowMapper().mapRow(rs);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.getConnection().close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return item;
  }

  @Override
  public List<Item> findAll() {
    String sql = String.format("SELECT * FROM %s", this.DB_TABLE);
    List<Item> item = new ArrayList<>();
    try {
      ResultSet rs = this.query(sql);
      while (rs.next()) {
        item.add(new ItemDaoRowMapper().mapRow(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.getConnection().close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return item;
  }

  /**
   * Get user's Post Items
   * 
   * @param userId
   * @return
   */
  public List<Item> getUserItem(long userId) {
    String sql = String.format("SELECT * FROM %s WHERE user_id = ?", this.DB_TABLE);
    List<Item> item = new ArrayList<>();
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, userId);
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        item.add(new ItemDaoRowMapper().mapRow(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.getConnection().close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return item;
  }



  /**
   * Search a donation post
   * 
   * @param keyWord
   * @return
   */
  public List<Item> searchPost(String keyWord) {
    /*
     * String sql = String.format("SELECT * FROM %s, %s ,%s " +
     * "WHERE (item_name like ? OR description like ? OR category_name = ?) AND " + this.DB_TABLE+
     * ".item_id = itemcategory.item_id AND " + "itemcategory.category_id = category.category_id "
     * ,this.DB_TABLE,"itemcategory","category");
     */
    String sql = String.format(
        "SELECT * FROM %s "
            + "WHERE (item_name like ? OR description like ? ) order by created_at desc",
        this.DB_TABLE);

    List<Item> item = new ArrayList<>();

    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setString(1, "%" + keyWord + "%");
      statement.setString(2, "%" + keyWord + "%");
      // statement.setString(3, "%"+keyWord+"%");

      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        item.add(new ItemDaoRowMapper().mapRow(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.getConnection().close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return item;
  }

}
