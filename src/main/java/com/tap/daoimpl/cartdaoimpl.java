package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.cartdao;
import com.tap.model.cart;
import com.tap.utility.dbconn;

public class cartdaoimpl implements cartdao {

	@Override
	public void addcart(cart cart) {

		String query = "INSERT INTO cart(user_id,f_id,quantity,price,subtotal) VALUES(?,?,?,?,?)";

		try (Connection con = dbconn.getcon();
				PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, cart.getUser_id());
			pstmt.setInt(2, cart.getF_id());
			pstmt.setString(3, cart.getQuantity());
			pstmt.setInt(4, cart.getPrice());
			pstmt.setInt(5, cart.getSubtotal());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public cart getcart(int cart_id) {

		String query = "SELECT * FROM cart WHERE cart_id=?";

		cart c = null;

		try (Connection con = dbconn.getcon();
				PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, cart_id);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				int user_id = res.getInt("user_id");
				int f_id = res.getInt("f_id");
				String quantity = res.getString("quantity");
				int price = res.getInt("price");
				int subtotal = res.getInt("subtotal");

				c = new cart(cart_id, user_id, f_id, quantity, price, subtotal);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public void updatecart(cart cart) {

		String query = "UPDATE cart SET user_id=?,f_id=?,quantity=?,price=?,subtotal=? WHERE cart_id=?";

		try (Connection con = dbconn.getcon();
				PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, cart.getUser_id());
			pstmt.setInt(2, cart.getF_id());
			pstmt.setString(3, cart.getQuantity());
			pstmt.setInt(4, cart.getPrice());
			pstmt.setInt(5, cart.getSubtotal());
			pstmt.setInt(6, cart.getCart_id());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletecart(int cart_id) {

		String query = "DELETE FROM cart WHERE cart_id=?";

		try (Connection con = dbconn.getcon();
				PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, cart_id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<cart> getallcart() {

		ArrayList<cart> cartList = new ArrayList<>();

		String query = "SELECT * FROM cart";

		try (Connection con = dbconn.getcon();
				Statement stmt = con.createStatement()) {

			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {

				int cart_id = res.getInt("cart_id");
				int user_id = res.getInt("user_id");
				int f_id = res.getInt("f_id");
				String quantity = res.getString("quantity");
				int price = res.getInt("price");
				int subtotal = res.getInt("subtotal");

				cart c = new cart(cart_id, user_id, f_id, quantity, price, subtotal);

				cartList.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cartList;
	}

	@Override
	public List<cart> getCartByUser(int userId) {
		
		 ArrayList<cart> cartList = new ArrayList<>();

		    String query = "SELECT * FROM cart WHERE user_id=?";

		    try (Connection con = dbconn.getcon();
		         PreparedStatement pstmt = con.prepareStatement(query)) {

		        pstmt.setInt(1, userId);

		        ResultSet res = pstmt.executeQuery();

		        while (res.next()) {

		            cart c = new cart(
		                    res.getInt("cart_id"),
		                    res.getInt("user_id"),
		                    res.getInt("f_id"),
		                    res.getString("quantity"),
		                    res.getInt("price"),
		                    res.getInt("subtotal")
		            );

		            cartList.add(c);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return cartList;
		
		
	}
}