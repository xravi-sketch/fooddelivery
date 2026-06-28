package com.tap. daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.userdao;
import com.tap.model.User;
import com.tap.utility.dbconn;

public class userdaoimpl implements userdao {

	@Override
	public void addUser(User user) {
		
	    
	    String ins_query ="insert into  user (`name`,`username`,`password`,`email`,phone,`address`,`role`) "
	    		+ "values (?,?,?,?,?,?,?)";
	    int res = 0;
	    try(Connection con = dbconn.getcon();
	    		PreparedStatement pstmt = con .prepareStatement(ins_query);) {
			
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setLong(5,user.getPhoneno());
			pstmt.setString(6,user.getAddress());
			pstmt.setString(7,user.getRole());
			
			res =pstmt.executeUpdate();
			
		} 
	    catch (SQLException e) 
		    {
				
				e.printStackTrace();
			}
	
	}

	@Override
	public User getUser(int userid) {
            String get_query = "select * from  user where userid =?";
            
            User user = null;
            try(Connection con = dbconn.getcon();
            		PreparedStatement pstmt = con.prepareStatement(get_query);) {
		
				  pstmt.setInt(1, userid);
				  ResultSet res = pstmt.executeQuery();
				  
				  if(res.next())
		            {
				 String name = res.getString("name");
				 String username = res.getString("username");
				 String password = res.getString("password");
				 String email = res.getString("email");
				 Long phoneno = res.getLong("phone");
				 String address = res.getString("address");
				 String role = res.getString("role");
				  
				  user = new User( userid, name, username, password, email, phoneno , address,role, null, null);
		            }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
           return user;
	
	}

	@Override
	public void updateUser(User user) {
		
		String up_query ="update user set name =? ,username =?,password =?,email=?,phone =?,address =?,role=? where userid =?";
		
		
		try ( Connection con = dbconn.getcon();
				PreparedStatement pstmt = con .prepareStatement(up_query);)
		{
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setLong(5,user.getPhoneno());
			pstmt.setString(6,user.getAddress());
			pstmt.setString(7,user.getRole());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUser(int userid) {
		String del_query ="delete from user where userid = ?";
       		
		Connection con = dbconn.getcon();
		try {
			PreparedStatement pstmt = con .prepareStatement(del_query);
			
			pstmt.setInt(1, userid);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUser() {
		 
		String query ="select * from user ";
		Connection con = dbconn.getcon();
		 User user =null;
		 ArrayList<User> userlist = new ArrayList<User>();
		try {
			Statement stmt = con .createStatement();
			ResultSet res =stmt.executeQuery(query);
			
			while(res.next()) {
				 int userid =res.getInt("userid"); 
				 String name = res.getString("name");
				 String username = res.getString("username");
				 String password = res.getString("password");
				 String email = res.getString("email");
				 Long phoneno = res.getLong("phone");
				 String address = res.getString("address");
				 String role = res.getString("role");
				 
				 
				user = new User( userid, name, username, password, email, phoneno , address,role, null, null);
				
				userlist.add(user);
				
			}
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userlist;
		
	}

	@Override
	public User getUserByUsername(String username) {

	    String query = "select * from user where username=?";

	    User user = null;

	    try(Connection con = dbconn.getcon();
	        PreparedStatement pstmt = con.prepareStatement(query))
	    {

	        pstmt.setString(1, username);

	        ResultSet res = pstmt.executeQuery();

	        if(res.next()) {

	            int userid = res.getInt("userid");
	            String name = res.getString("name");
	            String password = res.getString("password");
	            String email = res.getString("email");
	            long phone = res.getLong("phone");
	            String address = res.getString("address");
	            String role = res.getString("role");

	            user = new User(
	                    userid,
	                    name,
	                    username,
	                    password,
	                    email,
	                    phone,
	                    address,
	                    role,
	                    null,
	                    null);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}

}
