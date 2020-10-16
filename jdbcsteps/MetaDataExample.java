package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataExample {

	public static void main(String[] args) {
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			DatabaseMetaData metaData = c.getMetaData();
			System.out.println(metaData.getDatabaseMajorVersion());
			System.out.println(metaData.getDatabaseProductName());
			ResultSet resultSet = metaData.getColumns("jdbc",null, "festival", null);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(5));
				System.out.println(resultSet.getInt(5));
			}

			String sql = ("select * from festival");
			Statement statement = c.createStatement();
			ResultSet resultSet2 = statement.executeQuery(sql);
			ResultSetMetaData metaData2 = resultSet2.getMetaData();
			System.out.println(metaData2.getColumnCount());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
