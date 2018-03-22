package com.donorsClub.daos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.donorsClub.models.Interest;
import com.donorsClub.models.Item;
import com.donorsClub.models.Model;
/**
 *InterestDao
 *@since (2018/19/03)
 * @author sherif
 *
 */
public class InterestDao extends Dao implements IDao {
    private final String DB_TABLE ="interested";
   
    class InterestDaoRowMapper implements RowMapper<Interest>{
        
        @Override
        public Interest mapRow(ResultSet rs) throws SQLException {
        	Interest interest =new Interest();    
        
            interest.setId((rs.getLong("id")));
            interest.setUserId(rs.getInt("user_id"));
            interest.setItemId(rs.getInt("item_id"));
            interest.setSeen(rs.getShort("seen"));
            interest.setCreatedAt(rs.getTimestamp("created_at"));
            interest.setUpdatedAt(rs.getTimestamp("updated_at"));
            
            interest.setItem((Item) new ItemDao().findById(rs.getInt("item_id")));
            
            return interest;
        }
    }
    
    @Override
    public long insert(Model model) {
    
    	Interest interest  = (Interest) model;
     
        String sql = String.format("INSERT INTO %s( user_id, item_id, seen, created_at, updated_at) "
                + "VALUE(?,?,?,?,?)",this.DB_TABLE);
         String[] returnId = { "id" };
         long id = 0;
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(sql,returnId);
            statement.setInt(1, interest.getUserId() );
            statement.setInt(2, interest.getItemId());
            statement.setInt(3, interest.getSeen());
            statement.setTimestamp(4, new Timestamp(interest.getCreatedAt().getTime()));
            statement.setTimestamp(5, new Timestamp(interest.getUpdatedAt().getTime()));
        
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
        
    	Interest interest  = (Interest) model;
        String sql=String.format("UPDATE %s SET user_id=?,item_id=?,seen=?,updated_at=?"
                + " WHERE id=? " ,this.DB_TABLE);
        
        try {
            PreparedStatement statement =this.getConnection().prepareStatement(sql);
            
            statement.setInt(1, interest.getUserId());
            statement.setInt(2, interest.getItemId());
            statement.setInt(3, interest.getSeen());
            statement.setTimestamp(4, new Timestamp( interest.getUpdatedAt().getTime()));
            // Where Condition
            statement.setLong(5, interest.getId());
            
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
    	Interest interest = (Interest) model;
        String sql = String.format("DELETE FROM %s WHERE id=?",this.DB_TABLE);
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(sql);
            statement.setLong(1, interest.getId());
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
    	Interest interest =null;
        String sql = String.format("SELECT * FROM %s WHERE id = ?",this.DB_TABLE);
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(sql);
            statement.setLong(1, Id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return null;
            interest = new InterestDaoRowMapper().mapRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
          try{
            this.getConnection().close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
        return interest;
    }
    
    @Override
    public List<Interest> findAll() {
        String sql = String.format("SELECT * FROM %s",this.DB_TABLE);
        List<Interest> interests = new ArrayList<>();
        try {
            ResultSet rs = this.query(sql);
            while(rs.next()) {
                interests.add(new InterestDaoRowMapper().mapRow(rs));
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
        return interests;
    }
    
    /**
     * @author Sherif
     * @param choos
     * @param user
     * @return
     */
     private List<Interest> findAllbyProperty(String choos ,long user ) {
        String sql = String.format("SELECT * FROM %s where "+choos+" = ?",this.DB_TABLE);        
        System.out.println("Sql->   "+sql);
        List<Interest> interests = new ArrayList<>();
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(sql);
            statement.setLong(1, user);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                interests.add(new InterestDaoRowMapper().mapRow(rs));
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
        return interests;
    }
    /**
     * Get all a User's Interest
     * @author Sherif
     * @param UserId
     * @return
     */
    public List<Interest> getUserInterests (long UserId) {
        return findAllbyProperty("user_id" ,UserId );
    } 
    /**
     * Get all Interest of an Item
     * @author Sherif
     * @param ItemId
     * @return
     */
    public List<Interest> getItemInterests (long ItemId) {
        return findAllbyProperty("item_id" ,ItemId );
    } 
    
    public Interest getItemInterestByItemIdAndUserId (long itemId, long userId) {
      String sql = String.format("SELECT * FROM %s where item_id = ? and user_id = ? ",this.DB_TABLE);        
      Interest interest = null;
      try {
          PreparedStatement statement = this.getConnection().prepareStatement(sql);
          statement.setLong(1, itemId);
          statement.setLong(2, userId);
          System.out.println("Sql-> "+statement);
          ResultSet rs = statement.executeQuery();
          if(!rs.next()) return null;
          interest = new InterestDaoRowMapper().mapRow(rs);
      } catch (SQLException e) {
          e.printStackTrace();
      }finally{
        try{
            this.getConnection().close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
      return interest;
  } 
    
    
    
}