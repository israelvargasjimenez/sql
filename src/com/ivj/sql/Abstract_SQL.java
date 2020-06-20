package com.ivj.sql;

import java.sql.*;

public abstract class Abstract_SQL implements Interface_SQL {
	
 //-----------VARIABLES-----------
	
	// It stores conection
	private Connection myConnection = null;

	// It stores Statement
	private Statement myStatement = null;
	
	//It stores result
	private ResultSet myResutls = null;
	
	//It stores Metadatainformation
	DatabaseMetaData metaData = null;
	

//-------------CLASS METHODS--------------------------	
	/**
	 * Method that set created connection for specific DBMS without user and password information
	 * @param connection
	 * @throws SQLException 
	 */
	public void connect(String url, String user, String password) {		
		try {
			if (user == null || password == null) {
				this.myConnection = DriverManager.getConnection(url);
			}else {
				this.myConnection = DriverManager.getConnection(url, user, password);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	/**
	 * Method that creates a Statement using this.myConnection
	 */
	public void createStatement()  {
		try {
			myStatement = myConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that execute query using sql sentence passed like argument
	 * @param sql:String
	 */
	public  void executeQuery (String sql) {
		try {
			myResutls = myStatement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement 
	 * 
	 */
 	public void executeUpdate(String sql) {
 		try {
			myStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}
 	
 	public Array [] getColunmsName () {
 		System.out.println(metaData.toString());
 		
 		
		return null; 		
 	}

}
