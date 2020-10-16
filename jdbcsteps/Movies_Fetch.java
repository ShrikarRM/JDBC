package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movies_Fetch {

	public static void main(String[] args) {
		try {
			selectRecords();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void selectRecords() throws ClassNotFoundException{
		String url=("jdbc:mysql://localhost:3306?user=root&password=root");
			Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection=DriverManager.getConnection(url)){
			try(Statement statement=connection.createStatement()){
				//statement.execute("delete from jdbc.movies where Movie_ID=6");
				ResultSet set=statement.executeQuery("select * from jdbc.movies");
				while(set.next()){
					String Moviename=set.getString(2);
					String ID=set.getString(1);
					String Actor=set.getString(3);
					String Budget=set.getString(4);
					
					System.out.println(Moviename+" "+ID+" "+Actor+" "+Budget);
				}
			}connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
