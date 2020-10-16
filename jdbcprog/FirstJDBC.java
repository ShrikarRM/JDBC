package com.sccount.jdbcprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {

	public static void main(String[] args) {
		try {
			insertMovie();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void insertMovie() throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		// Class.forName("com.mysql.cj.jdbc.Driver"); //forName() became optional after 1.6version

		try (Connection connection = DriverManager.getConnection(url)) {
			try (Statement statement = connection.createStatement()) {
				statement.execute("insert into jdbc.Movies values(4,'AK 47' ,'Shivanna',5200000.50)");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
