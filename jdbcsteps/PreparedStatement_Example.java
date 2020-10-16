package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatement_Example {

	public static void main(String[] args) {
		try {
			insertValues();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void insertValues() throws ClassNotFoundException {
		String url = ("jdbc:mysql://localhost:3306?user=root&password=root");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(url)) {
			try (PreparedStatement preparedStatement = connection
					// .prepareStatement("insert into jdbc.movies
					// values(?,?,?,?)")) {
					.prepareStatement("update jdbc.movies set movie_name=?,Actor=? where Movie_ID=?")) {
				// set values for placeholders before executing query
				/*
				 * preparedStatement.setInt(1, 6);
				 * preparedStatement.setString(2, "3 idiots");
				 * preparedStatement.setString(3, "Madhavan");
				 * preparedStatement.setDouble(4,243000.4);
				 * preparedStatement.execute(); connection.close();
				 */

				Scanner sc = new Scanner(System.in);
				System.out.println("Enter id");
				int id = sc.nextInt();

				System.out.println("Enter movie name");
				String name = sc.next();

				System.out.println("Enter actor name");
				String actor = sc.next();
				/*
				 * System.out.println("Enter movie budget"); Double budget =
				 * sc.nextDouble(); sc.close();
				 */
				preparedStatement.setString(2, actor);
				preparedStatement.setString(1, name);

				preparedStatement.setInt(3, id);
				/* preparedStatement.setDouble(4, budget); */
				preparedStatement.execute();
				System.out.println(preparedStatement);
				preparedStatement.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
