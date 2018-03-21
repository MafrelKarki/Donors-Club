package com.donorsClub.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.donorsClub.models.*;

/**
 * CategoryDao
 * @since 03/19/18
 * @author Edward T. Tanko
 *
 */
public class CategoryDao extends Dao implements IDao{
	
	private final String DB_TABLE = "category";
	
	public CategoryDao() {
		super();
	}
	
	/**
	 * Implicit RowMapper Class 
	 * @author Edward T. Tanko
	 *
	 */
	class CategoryDaoRowMapper implements RowMapper<Category>{
		@Override
		public Category mapRow(ResultSet rs) throws SQLException {
			Category category = new Category();
			category.setCategoryId((rs.getLong("category_id")));
			category.setCategoryName(rs.getString("category_name"));
			category.setCreatedAt(rs.getTimestamp("created_at"));
			category.setUpdatedAt(rs.getTimestamp("updated_at"));
			
			return category;
		}
	}
	

	@Override
	public long insert(Model model) {
		Category category = (Category) model;
		
		String sql = String.format("INSERT INTO %s(category_name, created_at, updated_at) "
				+ "VALUE(?,?,?)",this.DB_TABLE);
		 String[] returnId = { "category_id" };
		 long id = 0;
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql,returnId);
			statement.setString(1, category.getCategoryName());
			statement.setTimestamp(2, new Timestamp(category.getCreatedAt().getTime()));
			statement.setTimestamp(3, new Timestamp(category.getUpdatedAt().getTime()));
		
			int st = statement.executeUpdate();
			if (st>0) {
			ResultSet rs = statement.getGeneratedKeys();
	        if (rs.next()) {
	            id = rs.getInt(1);
	        }
	        rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
          try{
            this.getConnection().close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
		return id;	
		
	}

	@Override
	public boolean update(Model model) {
		Category category = (Category) model;
		String sql = String.format("UPDATE %s SET category_name = ?, updated_at=? "
				+ "WHERE category_id=?",this.DB_TABLE);
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setString(1, category.getCategoryName());
			statement.setTimestamp(2, new Timestamp(category.getUpdatedAt().getTime()));
			
			statement.setLong(3, category.getCategoryId()); 
			if (statement.executeUpdate()>0) return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
          try{
            this.getConnection().close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
		return false;
	}

	@Override
	public boolean delete(Model model) {
		Category category = (Category) model;
		String sql = String.format("DELETE FROM %s WHERE category_id=?",this.DB_TABLE);
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setLong(1, category.getCategoryId());
			if (statement.executeUpdate()>0) return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
          try{
            this.getConnection().close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
		return false;
	}

	@Override
	public Model findById(long Id) {
		String sql = String.format("SELECT * FROM %s WHERE category_id = ?",this.DB_TABLE);
		Category picture = null;;
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setLong(1, Id);
			ResultSet rs = statement.executeQuery();
			if (!rs.next()) return null;
			picture = new CategoryDaoRowMapper().mapRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
          try{
            this.getConnection().close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
		return picture;
	}

	@Override
	public List<Category> findAll() {
		String sql = String.format("SELECT * FROM %s",this.DB_TABLE);
		List<Category> picture = new ArrayList<>();
		try {
			ResultSet rs = this.query(sql);
			while(rs.next()) {
				picture.add(new CategoryDaoRowMapper().mapRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
          try{
            this.getConnection().close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
		return picture;
	}

	
}
