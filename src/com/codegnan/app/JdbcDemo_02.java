package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo_02 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/coding";
		String username = "root";
		String password = "8500312566";
		

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				){
			Class.forName(driver);
			String sql = "SELECT * FROM book";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int bid = rs.getInt(1);
				String bname = rs.getString("bname");
				int price = rs.getInt(3);
				String theme = rs.getString(4);
				System.out.println(bid+" - "+bname+" - "+price+" - "+theme);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
