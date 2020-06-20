package com.ivj.sql;

import java.sql.*;
import java.util.HashMap;

public abstract class Abstract_SQL implements Interface_SQL {
	
 //-----------VARIABLES-----------
	
	// It stores conection
	private Connection myConnection = null;

	// It stores Statement
	private Statement myStatement = null;
	
	//It stores result
	private ResultSet myResutls = null;
	
	//It stores Metadatainformation
	private DatabaseMetaData metaData = null;
	
	//It stores database column names
	private HashMap <Integer, String> columnsDBNames = new HashMap<Integer, String>();
	
	//It stores database column number
	int totalColumnas = 0;
	
//---------------GETTERS Y SETTERS---------------------------
	
	public Connection getMyConnection() {
		return myConnection;
	}


	public void setMyConnection(Connection myConnection) {
		this.myConnection = myConnection;
	}


	public Statement getMyStatement() {
		return myStatement;
	}


	public void setMyStatement(Statement myStatement) {
		this.myStatement = myStatement;
	}


	public ResultSet getMyResutls() {
		return myResutls;
	}


	public void setMyResutls(ResultSet myResutls) {
		this.myResutls = myResutls;
	}


	public DatabaseMetaData getMetaData() {
		return metaData;
	}	

	public void setMetaData(DatabaseMetaData metaData) {
		this.metaData = metaData;
	}
	
	

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
				getMetaData();
			}else {
				this.myConnection = DriverManager.getConnection(url, user, password);
				this.getMetaData();
			}		
			//Se guarda la meta información de la base de datos de la conexión
			this.setMetaData(myConnection.getMetaData());
			this.createStatement();
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
	public void select(String sql) {
		try {
			myResutls = myStatement.executeQuery(sql);
			this.setColunmNames();
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
 	
 	
 	/**
 	 * Method that returns Results in a ResultSet
 	 * @return
 	 */
 	public ResultSet getResults() {
		return myResutls;
 		
 	}
 	
 	/**
 	 * Method that print select results
 	 */
 	
 	public void printSelectResults() {
 		System.out.println();
 		
 		
 	}
 	
 	
 	
 	/**
 	 * This method set All data base colunm names
 	 * @return columnasDB:HashMap It is a must to start with column number 1
 	 */
 	private void setColunmNames () {
 		try {
 			totalColumnas = myResutls.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumnas; i++ ) {
				Integer columna = Integer.valueOf(i);
				columnsDBNames.put(columna, myResutls.getString(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
 	}
}
