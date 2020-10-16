package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FestivalTransaction {

	public static void main(String[] args) {
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
			c.setAutoCommit(false);
			Statement statement = c.createStatement();
			statement.addBatch("insert into jdbc.festival values(16,'rakhi','august',1)");
			statement.addBatch("insert into jdbc.festival values(17,'sankranti','jan',2)");
			int a[] = statement.executeBatch();

			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				c.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
