package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo_05 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/coding";
        String username = "root";
        String password = "8500312566";

        
            try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, username, password);
	            System.out.println("Connection: " + con);
	            Statement stmt = con.createStatement();
	            Scanner sc = new Scanner(System.in);
	            System.out.println("Enter the book id :");
	            int bid = sc.nextInt();
	            
	            String sql = "SELECT * FROM book where bid="+bid;
	            ResultSet rs = stmt.executeQuery(sql);
	            if( rs.next() ) {
	            	String bname = rs.getString("bname");
	            	int price = rs.getInt(3);
	            	String theme = rs.getString(4);
	            	System.out.println(bid+" - "+bname+" - "+price+" - "+theme);
	            }else {
	            	System.out.println("Book not found with given id");
	            }
	            
	            sc.close();
	            stmt.close();
	            con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
