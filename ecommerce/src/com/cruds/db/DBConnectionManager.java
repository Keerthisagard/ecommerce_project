package com.cruds.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {
	static 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getconnection()
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb","root","Sagarkeerthi620");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return conn;
	}
}