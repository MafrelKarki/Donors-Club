package com.donorsClub.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This call is an abstract Data Acces Object Class to be extended by the IDao Interface.
 * All logic to make Database connections and run queries are handle by this classs
 * 
 * @version1.0
 * @since 03/17/18
 * @author Edward T. Tanko
 *
 */

public abstract class Dao {

	private String DBHost = "localhost";
	private String DBPort = "3306";
	private String DBName = "donationdb";
	private String DBUsername = "root";
	private String DBPassword = "";
	
	private Connection connection;
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	/**
	 * Constructor initialize and create the Connection object 
	 */
	public Dao() {
		 String urlstring = "jdbc:mysql://"+this.DBHost+":"+this.DBPort+"/"+this.DBName+"?useSSL=false";
		                   
	        try {
	            Class.forName(DRIVER_NAME);
	            try {
	                this.connection = DriverManager.getConnection(urlstring, this.DBUsername, this.DBPassword);
	            } catch (SQLException ex) {
	                //exception:
	                System.out.println("Failed to create the database connection.");
	            }
	        } catch (ClassNotFoundException ex) {
	            //exception
	            System.out.println("Database Driver not found.");
	        }
	}
	/**
	 * this method runs all valid SQL Statements and return a {@link ResultSet} 
	 * @param sql
	 * @return
	 */
	 protected ResultSet query(String sql){
	        ResultSet rs = null;
	        try{
	            Statement stmt = connection.createStatement();
	            rs = stmt.executeQuery(sql);
	           
	        }catch(SQLException ex){
	            ex.printStackTrace();
	        }
	         return rs;
	    }
	 
	protected Connection getConnection() {
			return this.connection;
	}
	
	protected void closeConnection() {
		 try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
	
	
}
