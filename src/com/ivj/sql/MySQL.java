package com.ivj.sql;

import java.sql.Connection;

public  class MySQL extends Abstract_SQL{
	String dbDestination = null;
	String port = null;
	String dbName = null;
	String user = null;
	String password = null;	
	
	
	/**
	 * Constructor sin datos de conexión
	 * @param url
	 */
	public MySQL(String dbDestination, String port, String dbName) {
		super();		
		this.dbDestination = dbDestination;
		this.port = port;
		this.dbName = dbName;		
		connect();		
	}
	
	/**
	 * Constructor con datos de conexión
	 * @param url
	 */
	public MySQL(String dbDestination, String port, String dbName, String user, String password) {
		super();		
		this.dbDestination = dbDestination;
		this.port = port;
		this.dbName = dbName;
		this.user = user;
		this.password = password;
		connect();		
	}


	public void connect() {
		String url = "jdbc:mysql://"+dbDestination+":"+port+"/"+dbName;
		super.connect(url, user, password);
	}

	
    public void select(String fields, String tableName, String condition ) {
    	//SQL sentence
    	String sql;
    	
    	if (condition == null) {
    		sql = QUERY.SELECT.name()+" "+fields+" "+"FROM"+
                    " "+tableName+";";
    	}else {
    		sql = QUERY.SELECT.name()+" "+fields+" "+"FROM"+
                    " "+tableName+" "+"WHERE"+" "+condition+";";
    	} 
    	super.select(sql);
    }
	

	
	
	
	
}
