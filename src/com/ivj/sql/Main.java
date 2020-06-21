package com.ivj.sql;


import java.util.HashMap;


import java.sql.*;

public class Main {

	public static void main(String[] args) {
		//MySQL mysql = new MySQL("192.168.1.5", "3306", "pildoras", "elisa", "Sismed08");		
		
		//mysql.select("*", "pedidos", null,null);
		//mysql.select("*", "productos", null, null);
		
		//mysql.select("PAIS_ORIGEN", "productos", null, null);
		
		//mysql.select("*", "productos", "SECCION","'CONFECCI�N'");
		
		//mysql.printSelectResults();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = "jdbc:sqlserver://ESTUDIOSISRAEL\\MSSQLSERVER_NEW:1433;databaseName =Mercado;user=usuarioSQL;password=Sismed08;";
		Connection conexion;
	    try {
			conexion = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
