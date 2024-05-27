package com.codegnan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo_08 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/coding";
        String username = "root";
        String password = "8500312566";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection: " + con);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM book";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	int bid = rs.getInt(1);
            	String bname = rs.getString("bname");
            	int price = rs.getInt(3);
            	String theme = rs.getString(4);
            	System.out.println(bid+" - "+bname+" - "+price+" - "+theme);
            }
            System.out.println("-----------------");          
            
            rs.absolute(1);
            
            rs.updateString(4,"Creulty");
            rs.updateRow();
            
            int bid = rs.getInt(1);
        	String bname = rs.getString("bname");
        	int price = rs.getInt(3);
        	String theme = rs.getString(4);
        	System.out.println(bid+" - "+bname+" - "+price+" - "+theme);
            
            System.out.println("Navigating in backward direction");
            rs.afterLast();
            while(rs.previous()) {
            	bid = rs.getInt(1);
            	bname = rs.getString("bname");
            	price = rs.getInt(3);
            	theme = rs.getString(4);
            	System.out.println(bid+" - "+bname+" - "+price+" - "+theme);
            }
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
