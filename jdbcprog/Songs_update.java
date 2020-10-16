package com.sccount.jdbcprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Songs_update {

	public static void main(String[] args) {
		try {
			updateList();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void updateList() throws ClassNotFoundException{
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		Class.forName("com.mysql.cj.jdbc.Driver");
	try(Connection connection=DriverManager.getConnection(url)){
		try(Statement statement=connection.createStatement()){
			statement.execute("update jdbc.songs set song_name='Rajakumara' where songs_id=2");
		}
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
