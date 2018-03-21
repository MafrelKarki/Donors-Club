package com.donorsClub.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.donorsClub.models.*;


/**
 * UserDAO
 * 
 * @since 03/19/18
 * @author Edward T. Tanko
 *
 */
public class UserDao extends Dao implements IDao {

  private final String DB_TABLE = "users";

  public UserDao() {
    super();
  }

  /**
   * Implicit RowMapper Class
   * 
   * @author Edward T. Tanko
   *
   */
  class UserDaoRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs) throws SQLException {
      User user = new User();
      user.setUserId(rs.getLong("user_id"));
      user.setFname(rs.getString("fname"));
      user.setLname(rs.getString("lname"));
      user.setStatus(rs.getShort("status"));
      user.setEmail(rs.getString("email"));
      user.setAddress(rs.getString("address"));
      user.setCreatedAt(rs.getTimestamp("created_at"));
      user.setUpdatedAt(rs.getTimestamp("updated_at"));
      user.setPassword(rs.getString("password"));
      user.setEmail(rs.getString("email"));
      user.setPhoneNumber(rs.getString("phone_number"));
      user.setPicture(rs.getString("picture"));

      long userId = rs.getLong("user_id");
      user.setItemList(new ItemDao().getUserItem(userId));
      user.setInterestList(new InterestDao().getUserInterests(userId));
      return user;
    }

  }


  @Override
  public long insert(Model model) {

    User user = (User) model;

    String sql = String.format("INSERT INTO %s(fname,lname, email, status, password,"
        + "phone_number, address, user_type, created_at,updated_at,picture) "
        + "VALUE(?,?,?,?,?,?,?,?,?,?,?)", this.DB_TABLE);
    String[] returnId = {"user_id"};

    long id = 0;
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql, returnId);
      statement.setString(1, user.getFname());
      statement.setString(2, user.getLname());
      statement.setString(3, user.getEmail());
      statement.setShort(4, user.getStatus());
      statement.setString(5, user.getPassword());
      statement.setString(6, user.getPhoneNumber());
      statement.setString(7, user.getAddress());
      statement.setInt(8, user.getUserType());
      statement.setTimestamp(9, new Timestamp(user.getCreatedAt().getTime()));
      statement.setTimestamp(10, new Timestamp(user.getUpdatedAt().getTime()));
      statement.setString(11, user.getPicture());
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
    User user = (User) model;
    String sql = String.format("UPDATE %s SET fname=?,lname=?, email=?, status=?, password=?,"
        + "phone_number=?, address=?, user_type=?, created_at=?,updated_at=?,picture=? "
        + "WHERE user_id=?", this.DB_TABLE);
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setString(1, user.getFname());
      statement.setString(2, user.getLname());
      statement.setString(3, user.getEmail());
      statement.setShort(4, user.getStatus());
      statement.setString(5, user.getPassword());
      statement.setString(6, user.getPhoneNumber());
      statement.setString(7, user.getAddress());
      statement.setInt(8, user.getUserType());
      statement.setTimestamp(9, new Timestamp(user.getCreatedAt().getTime()));
      statement.setTimestamp(10, new Timestamp(user.getUpdatedAt().getTime()));
      statement.setString(11, user.getPicture());

      statement.setLong(12, user.getUserId());
      if (statement.executeUpdate() > 0)
        return true;

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
    User user = (User) model;
    String sql = String.format("DELETE FROM %s WHERE userId=?", this.DB_TABLE);
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, user.getUserId());
      if (statement.executeUpdate() > 0)
        return true;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public Model findById(long Id) {
    String sql = String.format("SELECT * FROM %s WHERE user_id = ?", this.DB_TABLE);
    User user = null;;
    try {
      PreparedStatement statement = this.getConnection().prepareStatement(sql);
      statement.setLong(1, Id);
      ResultSet rs = statement.executeQuery();
      if (!rs.next())
        return null;
      user = new UserDaoRowMapper().mapRow(rs);
    } catch (SQLException e) {
      e.printStackTrace();
    }finally{
      try{
        this.getConnection().close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
    return user;
  }

  @Override
  public List<User> findAll() {
    String sql = String.format("SELECT * FROM %s", this.DB_TABLE);
    List<User> users = new ArrayList<>();
    try {
      ResultSet rs = this.query(sql);
      while (rs.next()) {
        users.add(new UserDaoRowMapper().mapRow(rs));
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
    return users;
  }
  
  /**
	 * @author Sherif
	 * @param email
	 * @param password
	 * @return
	 */
	
  public Model checkUser(String email , String password) {

		String sql = String.format("SELECT * FROM %s WHERE  email= ? and password =? ", this.DB_TABLE);
		User user = null;
		try {
			PreparedStatement statement = this.getConnection().prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (!rs.next()) return null;
			user = new UserDaoRowMapper().mapRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
          try{
            this.getConnection().close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
		return user;
	}
}
