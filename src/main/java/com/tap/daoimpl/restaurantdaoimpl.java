package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.restaurantdao;
import com.tap.model.restaurant;
import com.tap.utility.dbconn;

public class restaurantdaoimpl implements restaurantdao {

	@Override
	public void getrestaurant(restaurant restaurant) {
		
		Connection con = dbconn.getcon();
		
		String query ="insert into restaurant (r_id ,r_name ,owner_name,email,phone ,address ,rating ) values (?,?,?,?,?,?,?) ";
		
		int res =0;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, restaurant.getR_id());
			pstmt.setString(2, restaurant.getR_name());
			pstmt.setString(3, restaurant.getOwner_name());
			pstmt.setString(4, restaurant.getEmail());
			pstmt.setLong(5,restaurant.getPhoneno());
			pstmt.setString(6, restaurant.getAddress());
			pstmt.setDouble(7, restaurant.getRating());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public restaurant addrestaurant(int r_id) {
		
		Connection con = dbconn.getcon();
		String query ="Select * from restaurant where r_id =?";
		
		restaurant rest =null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, r_id);
			
			ResultSet res =pstmt.executeQuery();
			if(res.next()) {
			
			String rname = res.getString("r_name");
			String owner =res.getString("owner_name");
			String email =res.getString("email");
			Long phone =res.getLong("phone");
			String address =res.getString("address");
			Double  rating = res.getDouble("rating");
			
			
			rest = new restaurant( r_id,rname,owner,email,phone,address,rating );
			
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return rest;
	}

	@Override
	public void updaterestaurant(restaurant restaurant) {
		
		Connection con = dbconn.getcon();
		String query = "update restaurant set r_name =? ,owner_name =? , email =? ,phone =?,address =?,rating=? where r_id =?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, restaurant.getR_name());
			pstmt.setString(2, restaurant.getOwner_name());
			pstmt.setString(3, restaurant.getEmail());
			pstmt.setLong(4,restaurant.getPhoneno());
			pstmt.setString(5, restaurant.getAddress());
			pstmt.setDouble(6, restaurant.getRating());
			pstmt.setInt(7, restaurant.getR_id());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleterestaurant(int r_id) {
		
		Connection con = dbconn.getcon();
		
		String query  ="delete from restaurant where r_id = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, r_id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	@Override
	public List<restaurant> getallrestaurant() {
		Connection con = dbconn.getcon();
		
		String query ="select * from restaurant";
		
		Statement stmt;
		
		restaurant rest = null;
		
		ArrayList<restaurant> restlist =new ArrayList<restaurant>();
		
		try {
			stmt = con .createStatement();
			ResultSet res =stmt.executeQuery(query);
			
			while(res.next()) {
				int  r_id =res.getInt("r_id");
				String rname = res.getString("r_name");
				String owner =res.getString("owner_name");
				String email =res.getString("email");
				Long phone =res.getLong("phone");
				String address =res.getString("address");
				Double  rating = res.getDouble("rating");
				
				
				rest = new restaurant( r_id,rname,owner,email,phone,address,rating );
				
				restlist.add(rest);
				
				}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return restlist;
	}

}
