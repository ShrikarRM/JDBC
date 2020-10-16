package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Festival_CreateStatement_AddBatch {

	public static void main(String[] args) {

		// c=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
		String url = ("jdbc:mysql://localhost:3306?user=root&password=root");
		// Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(url)) {
			try (PreparedStatement preparedStatement = connection
					.prepareStatement("insert into jdbc.festival values(?,?,?,?)")) {
				preparedStatement.setInt(1, 15);
				preparedStatement.setString(2, "Dasara");
				preparedStatement.setString(3, "october");
				preparedStatement.setInt(4, 5);
				preparedStatement.addBatch();

				/*
				 * preparedStatement.setInt(1, 8);
				 * preparedStatement.setString(2, "Holi");
				 * preparedStatement.setString(3, "march");
				 * preparedStatement.setInt(4, 1); preparedStatement.addBatch();
				 */
				try {

					int a[] = preparedStatement.executeBatch();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try (PreparedStatement preparedStatement1 = connection
					.prepareStatement("update jdbc.festival set month=? where festival_id=?")) {
				preparedStatement1.setString(1, "oct");
				preparedStatement1.setInt(2, 1);
				preparedStatement1.addBatch();

				int a[] = preparedStatement1.executeBatch();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
