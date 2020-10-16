package com.sccount.jdbcprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Songs_Delete {

	public static void main(String[] args) {
		try {
			deleteSong();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deleteSong() throws ClassNotFoundException {
		String url = ("jdbc:mysql://localhost:3306?user=root&password=root");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(url)) {
			try (Statement statement = connection.createStatement()) {
				statement.execute("Delete from jdbc.songs where songs_id=2");
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
