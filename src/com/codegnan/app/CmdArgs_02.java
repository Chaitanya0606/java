package com.codegnan.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CmdArgs_02 {

	public static void main(String[] args) {
		String props = "";
		if(args.length == 0) {
			props = "db.properties";
		}
		else {
			if( args.length == 1) {
				if(args[0].equals("test")) {
					props = "test.properties";
				}
				else {
					if (args[0].equals("prod")) {
						props = "prod.properties";
					}
					else {
						System.out.println("Invalid environment");
					}
				}
			}
			else {
				System.out.println("Invalid command line arguments");
			}
		}
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(props));
			System.out.println(properties);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
