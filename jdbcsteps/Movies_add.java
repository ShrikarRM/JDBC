package com.account.jdbcsteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Movies_add {

	public static void main(String[] args) {
try{
	insertRecord();
}catch(ClassNotFoundException e){
	e.printStackTrace();
}
	}
	public static void insertRecord() throws ClassNotFoundException{
		String url=("jdbc:mysql://localhost:3306?user=root&password=root");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection=DriverManager.getConnection(url)){
			try(Statement statement=connection.createStatement()){
				statement.execute("insert into jdbc.movies values(6,'Krish','Hritik',200000)");
				statement.execute("insert into jdbc.movies values(7,'Krish','Hritik',250000)");

			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
