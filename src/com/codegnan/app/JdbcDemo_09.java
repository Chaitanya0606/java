package com.codegnan.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDemo_09 {

	public static void main(String[] args) {
		Properties props = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);

			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");

			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, username, password);
				System.out.println("Connection: " + con);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String sql = "SELECT * FROM book";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int bid = rs.getInt(1);
					String bname = rs.getString("bname");
					int price = rs.getInt(3);
					String theme = rs.getString(4);
					System.out.println(bid + " - " + bname + " - " + price + " - " + theme);
				}
				System.out.println("-----------------");

				rs.absolute(1);

				rs.updateString(4, "Creulty");
				rs.updateRow();

				int bid = rs.getInt(1);
				String bname = rs.getString("bname");
				int price = rs.getInt(3);
				String theme = rs.getString(4);
				System.out.println(bid + " - " + bname + " - " + price + " - " + theme);

				System.out.println("Navigating in backward direction");
				rs.afterLast();
				while (rs.previous()) {
					bid = rs.getInt(1);
					bname = rs.getString("bname");
					price = rs.getInt(3);
					theme = rs.getString(4);
					System.out.println(bid + " - " + bname + " - " + price + " - " + theme);
				}
				stmt.close();
				con.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
