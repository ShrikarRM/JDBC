package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movies_Condition {

	public static void main(String[] args) {
		try {
			onCondition();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void onCondition() throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(url)) {
			try (Statement statement = connection.createStatement()) {
				ResultSet res = statement.executeQuery("select * from jdbc.movies where Movie_ID=4");

				while (res.next()) {
					/*
					 * Double budget = res.getDouble("Budget"); int id =
					 * res.getInt("Movie_ID"); String name =
					 * res.getString("Movie_name"); String Actor =
					 * res.getString("Actor");
					 */
					String name = res.getString(2);
					int id = res.getInt(1);
					String Actor = res.getString(3);
					Double budget = res.getDouble(4);

					System.out.println(budget + " " + id + " " + name + " " + Actor + " ");
					System.out.println(res.getRow());
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
