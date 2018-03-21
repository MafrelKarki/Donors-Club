package com.donorsClub.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.donorsClub.models.*;

/**
 * PictureDao
 * @since 03/19/18
 * @author Edward T. Tanko
 *
 */
public class PictureDao extends Dao implements IDao{
	
	private final String DB_TABLE = "pictures";
	
	public PictureDao() {
		super();
	}
	
	/**
	 * Implicit RowMapper Class 
	 * @author Edward T. Tanko
	 *
	 */
	class PictureDaoRowMapper implements RowMapper<Picture>{
		@Override
		public Picture mapRow(ResultSet rs) throws SQLException {
			Picture picture = new Picture();
			picture.setPictureId((rs.getLong("picture_id")));
			picture.setPath(rs.getString("path"));
			picture.setItemId(rs.getLong("item_id"));
			picture.setCreatedAt(rs.getTimestamp("created_at"));
			picture.setUpdatedAt(rs.getTimestamp("updated_at"));
			
			return picture;
		}
	}
	

	@Override
	public long insert(Model model) {
		Picture picture = (Picture) model;
		
		String sql = String.format("INSERT INTO %s(path, item_id, created_at, updated_at) "
				+ "VALUE(?,?,?,?)",this.DB_TABLE);
		 String[] returnId = { "picture_id" };
		 long id = 0;
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql,returnId);
			statement.setString(1, picture.getPath());
			statement.setLong(2, picture.getItemId());
			statement.setTimestamp(3, new Timestamp(picture.getCreatedAt().getTime()));
			statement.setTimestamp(4, new Timestamp(picture.getUpdatedAt().getTime()));
		
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
		Picture picture = (Picture) model;
		String sql = String.format("UPDATE %s SET path = ?, item_id = ?, updated_at=? "
				+ "WHERE picture_id=?",this.DB_TABLE);
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setString(1, picture.getPath());
			statement.setLong(2, picture.getItemId());
			statement.setTimestamp(3, new Timestamp(picture.getUpdatedAt().getTime()));
			
			statement.setLong(4, picture.getPictureId()); 
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
		Picture picture = (Picture) model;
		String sql = String.format("DELETE FROM %s WHERE picture_id=?",this.DB_TABLE);
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setLong(1, picture.getPictureId());
			if (statement.executeUpdate()>0) return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Model findById(long Id) {
		String sql = String.format("SELECT * FROM %s WHERE picture_id = ?",this.DB_TABLE);
		Picture picture = null;;
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setLong(1, Id);
			ResultSet rs = statement.executeQuery();
			if (!rs.next()) return null;
			picture = new PictureDaoRowMapper().mapRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return picture;
	}

	@Override
	public List<Picture> findAll() {
		String sql = String.format("SELECT * FROM %s",this.DB_TABLE);
		List<Picture> picture = new ArrayList<>();
		try {
			ResultSet rs = this.query(sql);
			while(rs.next()) {
				picture.add(new PictureDaoRowMapper().mapRow(rs));
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
	/**
	 *  Get all pictures of an Item
	 * @param itemId
	 * @return
	 */
	public List<Picture> getItemPictures(long itemId) {
		String sql = String.format("SELECT * FROM %s WHERE item_id = ?",this.DB_TABLE);
		List<Picture>  pictures = new ArrayList<>();
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setLong(1, itemId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				pictures.add(new PictureDaoRowMapper().mapRow(rs));
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
		return pictures;
	}
}
