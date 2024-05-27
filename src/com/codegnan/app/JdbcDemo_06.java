package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo_06 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/coding";
        String username = "root";
        String password = "8500312566";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the book id :");
        int bid = sc.nextInt();
        System.out.print("Enter book name: ");
        String bname = sc.next();
        System.out.print("Enter theme: ");
        String theme = sc.next();
        System.out.print("Enter price: "); 
        int price = sc.nextInt();
        
            try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, username, password);
	            Statement stmt = con.createStatement();
	            /*Update data of an existing table*/
	            //String sql = "DELETE FROM student where id ="+id;
	            String sql = "UPDATE book SET bname = '"+bname+"', theme = '"+theme+"', price='"+price+"' WHERE bid = "+bid;
	            int noRec = stmt.executeUpdate(sql);
	            if(noRec == 1) {
	            	System.out.println("Record updated successfully");
	            }
	            else {
	            	System.out.println("Invalid book id to update book data");
	            }
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
