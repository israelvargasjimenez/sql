package com.ivj.sql;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		MySQL mysql = new MySQL("192.168.1.5", "3306", "pildoras", "elisa", "Sismed08");		
		
		mysql.select("*", "pedidos", null);
		
		

	}

}
