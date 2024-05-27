package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo_04 {

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
	            String sql = "DELETE from book where bid=4";
	            int noRec = stmt.executeUpdate(sql);
	            if (noRec == 1){
	            	System.out.println("DELETEed successfully");
	            }
	            else {
	            	// Nothing to do
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
