package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.deliverydao;
import com.tap.model.delivery;
import com.tap.utility.dbconn;

public class deliverydaoimpl implements deliverydao {

	@Override
	public void adddelivery(delivery delivery) {
		
		
		Connection con =dbconn.getcon();
		
		String query ="insert into delivery(delivery_id ,order_id,partner_id,delivery_status,delivery_item) values (?,?,?,?,?)";
		
		int res =0;
		try {
			PreparedStatement pstmt =con.prepareStatement(query);
			
			pstmt.setInt(1, delivery.getDelivery_id());
			pstmt.setInt(2, delivery.getOrder_id());
			pstmt.setInt(3, delivery.getPartner_id());
			pstmt.setString(4, delivery.getDelivery_status());
			pstmt.setString(5, delivery.getDelivery_item());
			
			res = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			
			
			e.printStackTrace();
		}
		
	}

	@Override
	public delivery getdelivery(int delivery_id) {
		
		Connection con =dbconn.getcon();
		
		String query ="select * from delivery where delivery_id =?";
		delivery deliverys =null;
		try {
			PreparedStatement pstmt =con.prepareStatement(query);
			
			pstmt.setInt(1, delivery_id);
			
			ResultSet res = pstmt.executeQuery();
			
			int deliveryid = res.getInt("delivery_id");
			int order_id = res.getInt("order_id");
			int partner_id = res.getInt("partner_id");
			String delivery_status = res.getString("delivery_status");
			String delivery_item = res.getString("delivery_item");
     
			  deliverys = new delivery( deliveryid,order_id,partner_id,delivery_status,delivery_item);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	return deliverys;
	}

	@Override
	public void updatedelivery(delivery delivery) {
		
		Connection con =dbconn.getcon();
		String query ="update delivery set order_id =? ,partner_id =?,delivery_status =? ,delivery_item =? where delivery_id =?";
		
		try {
			PreparedStatement pstmt =con.prepareStatement(query);
			
			pstmt.setInt(1, delivery.getOrder_id());
			pstmt.setInt(2, delivery.getPartner_id());
			pstmt.setString(3, delivery.getDelivery_status());
			pstmt.setString(4, delivery.getDelivery_item());
			pstmt.setInt(5, delivery.getDelivery_id());
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletedelivery(int delivery_id) {
		Connection con =dbconn.getcon();
		String query ="delete from delivery where delivery_id =?";
		
		try {
			PreparedStatement pstmt =con.prepareStatement(query);
			
			pstmt.setInt(1, delivery_id);
			
			pstmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<delivery> getalldelivery() {
		
		Connection con =dbconn.getcon();
		
		String query ="select * from delivery ";
		
		delivery deliverys =null;
		
		ArrayList<delivery> delivery_list = new ArrayList<delivery>();
		
		try {
			Statement stmt =con.createStatement();
			
			ResultSet res =stmt.executeQuery(query);
			
			
			
		while(res.next()) {
				int deliveryid = res.getInt("delivery_id");
				int order_id = res.getInt("order_id");
				int partner_id = res.getInt("partner_id");
				String delivery_status = res.getString("delivery_status");
				String delivery_item = res.getString("delivery_item");
				
				 deliverys = new delivery( deliveryid,order_id,partner_id,delivery_status,delivery_item);
				
				 delivery_list.add(deliverys);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	return delivery_list;
	}

}
