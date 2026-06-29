package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconn {
    private static final String URL ="jdbc:mysql://reseau.proxy.rlwy.net:34128/railway?useSSL=true&requireSSL=true&serverTimezone=UTC";
    private static final String UN ="root";
    private static final String PWD ="PYuWpdUtDEWwwMgDOhaQaJDJssvYZtDh";
    
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
