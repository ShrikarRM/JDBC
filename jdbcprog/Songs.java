package com.sccount.jdbcprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Songs {

	public static void main(String[] args) {
		try{
			songsaddition();
		}	
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void songsaddition() throws ClassNotFoundException{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection=DriverManager.getConnection(url)){
			try(Statement statement=connection.createStatement()){
				statement.execute("insert into jdbc.songs values(5,'Huttidare','Dr.Raj',6)");
			}
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
