package com.ivj.sql;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		MySQL mysql = new MySQL("192.168.1.5", "3306", "pildoras", "elisa", "Sismed08");		
		
		mysql.select("*", "pedidos", null,null);
		//mysql.select("*", "productos", null, null);
		
		//mysql.select("PAIS_ORIGEN", "productos", null, null);
		
		//mysql.select("*", "productos", "SECCION","'CONFECCI�N'");
		
		mysql.printSelectResults();

	}

}
