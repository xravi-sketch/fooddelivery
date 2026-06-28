package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.delivery_partnersdao;
import com.tap.model.delivery_partners;
import com.tap.utility.dbconn;

public class delivery_partnersdaoimpl implements delivery_partnersdao {

	@Override
	public void adddelivery_partner(delivery_partners delivery_partners) {

       Connection con =dbconn.getcon();
       
       String ins_query ="insert into delivery_partner (partner_id,`name`,phone_no,`vechile_no`,`status`) values (?,?,?,?,?) ";
       
       try {
		PreparedStatement pstmt = con.prepareStatement(ins_query);
		
		pstmt.setInt(1, delivery_partners.getPartner_id());
		pstmt.setString(2, delivery_partners.getName());
		pstmt.setInt(3, delivery_partners.getPhoneno());
		pstmt.setString(4, delivery_partners.getVechile_number());
		pstmt.setString(5, delivery_partners.getStatus());
		
		int res = pstmt.executeUpdate();
		 
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		
	}

	@Override
	public delivery_partners getdelivery_partners(int pat_id) {
		
		
		delivery_partners delivery_partner = null;
		
		 Connection con =dbconn.getcon();
		 String query ="select * from delivery_partner where partner_id = ?";
		 
		  try {
			PreparedStatement pstmt = con.prepareStatement(query);
			 pstmt.setInt(1, pat_id);
			 
			 ResultSet res = pstmt.executeQuery();
			 int partner_id = res.getInt("partner_id");
			 String name =res.getString("name");
			 int phone =res.getInt("phone_no");
			 String vechile =res.getString("vechile_no");
			 String status =res.getString("status");
			 
			 delivery_partner = new  delivery_partners(partner_id, name, phone, vechile, status); 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return delivery_partner;
	}

	@Override
	public void updatedelivery_partner(delivery_partners delivery_partners) {
		
		String up_query="update delivery_partner set name =? ,phone_no =?,vechile_no=?,status =? where partner_id =?";
		Connection con =dbconn.getcon();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(up_query);
			pstmt.setString(1, delivery_partners.getName());
			pstmt.setInt(2, delivery_partners.getPhoneno());
			pstmt.setString(3, delivery_partners.getVechile_number());
			pstmt.setString(4, delivery_partners.getStatus());
			pstmt.setInt(5, delivery_partners.getPartner_id());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deletedelivery_partner(int pat_id) {

		String del_query ="delete from user where partner_id = ?";
   		
		Connection con = dbconn.getcon();
		try {
			PreparedStatement pstmt = con .prepareStatement(del_query);
			
			pstmt.setInt(1, pat_id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<delivery_partners> getalldeliverypartner() {
	  
		String query ="select * from delivery_partner";
		Connection con = dbconn.getcon();
		
		delivery_partners delivery_partner = null;
		ArrayList<delivery_partners> del_part = new ArrayList<delivery_partners>();
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			
			while(res.next()) {
				int partner_id = res.getInt("partner_id");
				 String name =res.getString("name");
				 int phone =res.getInt("phone_no");
				 String vechile =res.getString("vechile_no");
				 String status =res.getString("status");
				 
				 delivery_partner = new  delivery_partners(partner_id, name, phone, vechile, status); 
				
				del_part.add(delivery_partner);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		return del_part ;
	}
  
	
	
	
	
	
	
}
