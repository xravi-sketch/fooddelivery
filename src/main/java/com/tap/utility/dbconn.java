package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconn {
    private static final String URL ="jdbc:mysql://localhost:3306/fooddb";
    private static final String UN ="root";
    private static final String PWD ="Ramips@143";
    
	public static Connection getcon() {
	  
		Connection con=null;
		
             try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con =DriverManager.getConnection(URL, UN, PWD);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

  
  return con;
	
	}
	
}
