package com.donorsClub.daos;

import java.util.List;

import com.donorsClub.models.*;

/**
 * This interface MUST be implemented by all DAOs
 * @since 03/19/18
 * @author Edward T. Tanko
 *
 */
public interface IDao{
	
	/**
	 * Insert a new record of a model in the database.
	 * it returns the Id of that newly inserted record or 0 if no record was added
	 * 
	 * @param model
	 * @return
	 */
	public abstract long insert(Model model);
	
	/**
	 * Update a record of a model in the database. 
	 * it returns TRUE if record exist and was updated successfully
	 * otherwise it return FALSE
	 * 
	 * @param model
	 * @return
	 */
	public abstract boolean update (Model model); 
	
	/**
	 * Delete a record of a model.
	 * it returns TRUE if record exist and was deleted successfully
	 * otherwise it return FALSE
	 * 
	 * @param model
	 * @return
	 */
	public abstract boolean delete(Model model);
	
	/**
	 * query the database and return a model with the particular Id
	 * 
	 * @param Id
	 * @return
	 */
	public abstract Model findById(long Id);
	
	/**
	 * query the database and return all the record of a model
	 * 
	 * @return
	 */
	public abstract List<? extends Model> findAll();
	
	
}
