package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.order_itemsdao;
import com.tap.model.order_items;
import com.tap.utility.dbconn;

public class order_itemsdaoimpl implements order_itemsdao {

	@Override
	public void addorder_item(order_items order_item) {
		
		Connection con =dbconn.getcon();
		
		String query ="insert into order_item (o_details,o_id,f_id,quantity,subtotal,) values (?,?,?,?,?)";
		
		int res =0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, order_item.getO_details());
			pstmt.setInt(2, order_item.getO_id());
			pstmt.setInt(3,order_item.getF_id());
			pstmt.setString(4, order_item.getQuantity());
			pstmt.setInt(5, order_item.getSubtotal());
			
			res =pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public order_items getorder_item(String o_details) {
		
		Connection con =dbconn.getcon();
		
		String query ="select * from order_item where o_details =?";
		
		order_items orderitems =null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, o_details);
			ResultSet res =pstmt.executeQuery();
			
			int order_id = res.getInt("o_id");
			int food_id =res.getInt("f_id");
			String quant =res.getString("quantity");
			int tot =res.getInt("subtotal");
			
			
			orderitems = new order_items(o_details,order_id,food_id,quant,tot);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return orderitems;
	}

	@Override
	public void updateorder_item(order_items order_item) {
	
		Connection con =dbconn.getcon();
		
		String query ="update order_item set o_id =? ,f_id =? ,quantity =? ,subtotal=? where o_details =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
	
			pstmt.setInt(1, order_item.getO_id());
			pstmt.setInt(2,order_item.getF_id());
			pstmt.setString(3, order_item.getQuantity());
			pstmt.setInt(4, order_item.getSubtotal());
			pstmt.setString(5, order_item.getO_details());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void deleteorder_item(String o_details) {
		
		Connection con =dbconn.getcon();
		String query ="delete from order_items where o_details=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,o_details);
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<order_items> getallorder_items() {
         
		Connection con =dbconn.getcon();
		
		String query ="select * from order_items";
		
		order_items orderitems =null;
		
		ArrayList<order_items> orderitem = new ArrayList<order_items>();
		
		try {
			Statement pstmt = con.createStatement();
			
			ResultSet res = pstmt.executeQuery(query);
			
			String order_details =res.getString("o_details");
			int order_id = res.getInt("o_id");
			int food_id =res.getInt("f_id");
			String quant =res.getString("quantity");
			int tot =res.getInt("subtotal");
			
			orderitems = new order_items(order_details ,order_id ,food_id ,quant,tot );
			
			orderitem.add(orderitems);
			
		} catch (SQLException e) {
			
			
			
			e.printStackTrace();
		}
		
		return orderitem;
	}

}
