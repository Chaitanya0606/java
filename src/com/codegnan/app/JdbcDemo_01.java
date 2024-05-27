package com.codegnan.app;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner; 

public class JdbcDemo_01 {
    public static void main(String args[]) {
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

            String sql = "INSERT INTO book (bid, bname, price, theme) VALUES (" + bid + ", '" + bname + "', " + price + ", '" + theme + "')";
            int noRec = stmt.executeUpdate(sql);

            if (noRec == 1) {
                System.out.println("Insert Successful");
            } else {
                System.out.println("Insert Failed");
            }
            sc.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

