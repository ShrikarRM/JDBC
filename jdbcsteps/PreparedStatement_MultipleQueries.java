package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement_MultipleQueries {

	public static void main(String[] args) {
		try {
			multipleSQLStatements();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void multipleSQLStatements() throws ClassNotFoundException {
		String url = ("jdbc:mysql://localhost:3306?user=root&password=root");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(url)) {
			try (PreparedStatement preparedStatement = connection
					.prepareStatement("insert into jdbc.festival values(?,?,?,?)")) {
				preparedStatement.setInt(1, 13);
				preparedStatement.setString(2, "Ganesh");
				preparedStatement.setString(3, "August");
				preparedStatement.setInt(4, 10);
				preparedStatement.execute();
			}
			try (PreparedStatement preparedStatement = connection
					.prepareStatement("insert into jdbc.festival values(?,?,?,?)")) {
				preparedStatement.setInt(1, 14);
				preparedStatement.setString(2, "divali");
				preparedStatement.setString(3, "may");
				preparedStatement.setInt(4, 5);
				preparedStatement.execute();
			}

			/*try (PreparedStatement preparedStatement = connection
					.prepareStatement("update jdbc.festival set no_of_days=? where festival_id=?")) {
				preparedStatement.setInt(1, 5);
				preparedStatement.setInt(2, 1);
				preparedStatement.execute();
				connection.close();
			
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
