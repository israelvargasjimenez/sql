package com.ivj.sql;

import java.sql.*;

/**
 * Interface to be user for SQL data management
 * It is neccesary to import right library connection driver for each sql database 
 *
 * @author Israel Vargas
 * @since 20-6-2020
 * @version 1.0
 */

public interface Interface_SQL {
	
	/**
	 * It stores available query options
	 * @author cuarto
	 *
	 */	
	public enum QUERY {		
		SELECT,
		UPDATE,
		DELETE,
		INSERT;			
	}
	
	
	
	/**
	 * Method that creates connection to database
	 */
	public abstract void connect(String url, String user, String password);
	
	
	/**
	 * Method that creates Statement
	 * @throws SQLException 
	 */
	public abstract void createStatement() throws SQLException;
	
	
	/**
	 * Method that execute query using sql sentence passed like argument
	 */
	public abstract void select (String sql);
	
	
	/**
	 * Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement 
	 * 
	 */
 	public abstract void executeUpdate(String sql);
 	
 		
}
