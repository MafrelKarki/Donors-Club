package com.donorsClub.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is a generic template RowMapper interface that set all the properties of a Model
 * from the ResultSet SQL statement object;
 * 
 * @author Edward T. Tanko
 *  @since 03/19/18
 *@version 1.0
 * @param <Model>
 */

public interface RowMapper<Model> {
	/**
	 * 
	 * @param rs
	 * @param rowNum
	 * @return
	 * @throws SQLException
	 */
	public Model mapRow(ResultSet rs) throws SQLException;
	
}
