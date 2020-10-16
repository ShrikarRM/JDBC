package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Festival_addBatch {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
			Statement statement = con.createStatement();
			statement.addBatch("insert into jdbc.festival values(4,'holi','march',2)");
			statement.addBatch("insert into jdbc.festival values(5,'yugadi','april',1)");
			statement.addBatch("insert into jdbc.festival values(6,'sankranti','jan',1)");
			int a[] = statement.executeBatch();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
