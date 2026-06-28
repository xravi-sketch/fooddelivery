package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.fooditemdao;
import com.tap.model.User;
import com.tap.model.fooditem;
import com.tap.utility.dbconn;

public class fooditemdaoimpl implements fooditemdao{

	@Override
	public void addfooditem(fooditem fooditem) {
		
		 String ins_query ="insert into  fooditem (f_id,r_id,food_name,price,category,description, availabilty,image,quantity) "
		    		+ "values (?,?,?,?,?,?,?,?,?)";
		    int res = 0;
		    try(Connection con = dbconn.getcon();
		    		PreparedStatement pstmt = con .prepareStatement(ins_query);) {
				
				pstmt.setInt(1,fooditem.getF_id());
				pstmt.setInt(2,fooditem.getR_id());
				pstmt.setString(3,fooditem.getFood_name());
				pstmt.setInt(4,fooditem.getPrice());
				pstmt.setString(5,fooditem.getCategory());
				pstmt.setString(6,fooditem.getDescription());
				pstmt.setFloat(7,fooditem.getAvailabilty());
				pstmt.setString(8,fooditem.getImage());
				pstmt.setString(9,fooditem.getQuantity());
				
				res =pstmt.executeUpdate();
				
			} 
		    catch (SQLException e) 
			    {
					
					e.printStackTrace();
				}
		
		
	}

	@Override
	public fooditem getfooditem(int f_id) {
		
		 String get_query = "select * from  fooditem where f_id =?";
         
         fooditem fooditems = null;
         try(Connection con = dbconn.getcon();
         		PreparedStatement pstmt = con.prepareStatement(get_query);) {
		
				  pstmt.setInt(1, f_id);
				  ResultSet res = pstmt.executeQuery();
				  if(res.next()){  
				  int fooid =res.getInt("f_id");
				 int rest_id = res.getInt("r_id");
				 String foodname = res.getString("food_name");
				 int price = res.getInt("price");
				 String category = res.getString("category");
				 String descripton = res.getString("description");
				 float availabilty = res.getFloat("availabilty");
				 String image =res.getString("image");
				 String quantity =res.getString("quantity");
				  
				  fooditems =new fooditem( fooid,rest_id,foodname,price,category,descripton,availabilty,image,quantity);
				  }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        return fooditems;
		
		
		
	}

	@Override
	public void updatefooditem(fooditem fooditem) {
		

		String up_query ="update fooditem set r_id=?,food_name=?,price=?,category =?,description=?,availabilty=?,image=?,quantity =?"
				+ "where f_id =?";
		
		
		try ( Connection con = dbconn.getcon();
				PreparedStatement pstmt = con .prepareStatement(up_query);)
		{
			pstmt.setInt(1,fooditem.getR_id() );;
			pstmt.setString(2,fooditem.getFood_name());
			pstmt.setInt(3,fooditem.getPrice());
			pstmt.setString(4,fooditem.getCategory());
			pstmt.setString(5,fooditem.getDescription());
			pstmt.setFloat(6,fooditem.getAvailabilty());
			pstmt.setInt(7,fooditem.getF_id());
			pstmt.setString(8,fooditem.getImage());
			pstmt.setString(9,fooditem.getQuantity());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deletefooditem(int f_id) {
		String del_query ="delete from fooditem where f_id = ?";
   		
		Connection con = dbconn.getcon();
		try {
			PreparedStatement pstmt = con .prepareStatement(del_query);
			
			pstmt.setInt(1, f_id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

	@Override
	public List<fooditem> getallfooditem() {
		
		String query ="select * from fooditem ";
		Connection con = dbconn.getcon();
		 fooditem food_item =null;
		 ArrayList<fooditem> fooditemlist = new ArrayList<fooditem>();
		try {
			Statement stmt = con .createStatement();
			ResultSet res =stmt.executeQuery(query);
			
			while(res.next()) {
				
				  int fooid =res.getInt("f_id");
					 int rest_id = res.getInt("r_id");
					 String foodname = res.getString("food_name");
					 int price = res.getInt("price");
					 String category = res.getString("category");
					 String descripton = res.getString("description");
					 float availabilty = res.getFloat("availabilty");
					 String image =res.getString("image");
					 String quantity =res.getString("quantity");
					 
					  food_item =new fooditem( fooid,rest_id,foodname,price,category,descripton,availabilty,image,quantity);
				
					  fooditemlist.add(food_item);
				
			}
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return fooditemlist;
		
	}

	@Override
	public List<fooditem> getFoodByRestaurant(int r_id) {

	    Connection con = dbconn.getcon();

	    String query = "SELECT * FROM fooditem WHERE r_id=?";

	    ArrayList<fooditem> foodList = new ArrayList<>();

	    try {
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, r_id);

	        ResultSet res = pstmt.executeQuery();

	        while (res.next()) {

	            fooditem food = new fooditem(
	                    res.getInt("f_id"),
	                    res.getInt("r_id"),
	                    res.getString("food_name"),
	                    res.getInt("price"),
	                    res.getString("category"),
	                    res.getString("description"),
	                    res.getFloat("availabilty"),
	                    res.getString("image"),
	                    res.getString("quantity")
	            );

	            foodList.add(food);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return foodList;
	}
		
	}


