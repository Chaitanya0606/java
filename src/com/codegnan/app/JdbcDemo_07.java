package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo_07 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/coding";
        String username = "root";
        String password = "8500312566";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book ID: ");
        int bid = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter book name: ");
        String bname = sc.next();
        System.out.print("Enter book price: ");
        int price = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter book theme: ");
        String theme = sc.next();

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO book VALUES (?,?,?,?)");
            pstmt.setInt(1, bid);
            pstmt.setString(2, bname);
            pstmt.setInt(3, price);
            pstmt.setString(4, theme);
            int noRec = pstmt.executeUpdate();
            if ( noRec == 1 ) {
            	System.out.println("INSERTed successfully");
            }
            else {
            	// Nothing to execute here
            }
            
            pstmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
