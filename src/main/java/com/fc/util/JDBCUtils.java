package com.fc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class JDBCUtils {
	
	
	public static Connection getMySQLConnection(ServletContext context) throws ClassNotFoundException, SQLException {
	
		System.out.println("---getMySQLConnection---");
		
		String driverClassName=context.getInitParameter("driver-class-name");
		String hostName = context.getInitParameter("host");
		String mysqlPort=context.getInitParameter("mysql-port");
		String userName=context.getInitParameter("user-name");
		String password=context.getInitParameter("password");
		String databaseName=context.getInitParameter("database-name");
		
		Class.forName(driverClassName);
		String url="jdbc:mysql://" + hostName + ":" + mysqlPort + "/" + databaseName;
		Connection con=DriverManager.getConnection(url, userName, password);
		
		return con;
	}

}

