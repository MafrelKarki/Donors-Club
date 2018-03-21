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
public class ItemCategoryDao extends Dao implements IDao {

  private final String DB_TABLE = "itemcategory";

  public ItemCategoryDao() {
    super();
  }

  /**
   * Implicit RowMapper Class
   * 
   * @author Edward T. Tanko
   *
   */
  class ItemCategoryDaoRowMapper implements RowMapper<ItemCategory> {
    @Override
    public ItemCategory mapRow(ResultSet rs) throws SQLException {
      ItemCategory itemCategory = new ItemCategory();
      itemCategory.setId((rs.getLong("id")));
      itemCategory.setItemId((rs.getLong("item_id")));
      itemCategory.setCreatedAt(rs.getTimestamp("created_at"));
      itemCategory.setUpdatedAt(rs.getTimestamp("updated_at"));

      long categ_id = rs.getLong("category_id");
      itemCategory.setCategory((Category) new CategoryDao().findById(categ_id));

      return itemCategory;
    }
  }


  @Override
  public long insert(Model model) {
    ItemCategory category = (ItemCategory) model;

    String sql = String.format(
        "INSERT INTO %s(category_id, item_id, created_at, updated_at) " + "VALUE(?,?,?,?)",
        this.DB_TABLE);
    String[] returnId = {"id"};
    long id = 0;
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql, returnId);
      statement.setLong(1, category.getCategoryId());
      statement.setLong(2, category.getItemId());
      statement.setTimestamp(3, new Timestamp(category.getCreatedAt().getTime()));
      statement.setTimestamp(4, new Timestamp(category.getUpdatedAt().getTime()));

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
    ItemCategory category = (ItemCategory) model;
    String sql = String.format(
        "UPDATE %s SET category_id = ?,item_id=?, updated_at=? " + "WHERE id=?", this.DB_TABLE);
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, category.getCategoryId());
      statement.setLong(2, category.getItemId());
      statement.setTimestamp(3, new Timestamp(category.getUpdatedAt().getTime()));

      statement.setLong(4, category.getId());
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
    ItemCategory category = (ItemCategory) model;
    String sql = String.format("DELETE FROM %s WHERE id=?", this.DB_TABLE);
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, category.getId());
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
    ItemCategory category = null;;
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, Id);
      ResultSet rs = statement.executeQuery();
      if (!rs.next())
        return null;
      category = new ItemCategoryDaoRowMapper().mapRow(rs);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        this.getConnection().close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return category;
  }

  @Override
  public List<ItemCategory> findAll() {
    String sql = String.format("SELECT * FROM %s", this.DB_TABLE);
    List<ItemCategory> category = new ArrayList<>();
    try {
      ResultSet rs = this.query(sql);
      while (rs.next()) {
        category.add(new ItemCategoryDaoRowMapper().mapRow(rs));
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
    return category;
  }

  /**
   * Get all Categories of and Item
   * 
   * @param itemId
   * @return
   */
  public List<ItemCategory> getItemCategoriesByItemId(long itemId) {
    String sql = String.format("SELECT * FROM %s WHERE item_id = ?", this.DB_TABLE);
    List<ItemCategory> category = new ArrayList<>();
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, itemId);
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        category.add(new ItemCategoryDaoRowMapper().mapRow(rs));
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
    return category;
  }


}
