package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.ordersdao;
import com.tap.model.orders;
import com.tap.utility.dbconn;

public class ordersdaoimpl implements ordersdao {

    @Override
    public void addorders(orders order) {

        String ins_query = "insert into orders(o_id,userid,order_date,t_amt,status,delivery_address,customer_name,phone)"
        		+ " values(?,?,?,?,?,?,?,?)";
 
        int res = 0;
        
        try(Connection con = dbconn.getcon();
            PreparedStatement pstmt = con.prepareStatement(ins_query))
        {
            pstmt.setInt(1, order.getO_id());
            pstmt.setInt(2, order.getUserid());
            pstmt.setDate(3, order.getOrder_date());
            pstmt.setInt(4, order.getT_amt());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getDelivery_address());
            pstmt.setString(7,order.getCustomer_name());
            pstmt.setLong(8, order.getPhone());

           res = pstmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public orders getorders(int o_id) {

        String get_query = "select * from orders where o_id=?";

        orders order = null;

        try(Connection con = dbconn.getcon();
            PreparedStatement pstmt = con.prepareStatement(get_query))
        {

            pstmt.setInt(1, o_id);
  
            ResultSet res = pstmt.executeQuery();

            if(res.next())
            {
                int userid = res.getInt("userid");
                Date order_date = res.getDate("order_date");
                int t_amt = res.getInt("t_amt");
                String status = res.getString("status");
                String delivery_address = res.getString("delivery_address");
                String customer_name =res.getString("customer_name");
                Long phone  = res.getLong("phone");

                order = new orders(o_id, userid, order_date, t_amt, status, delivery_address,customer_name,phone);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public void updateorders(orders order) {

        String up_query =
        "update orders set userid=?, order_date=?, t_amt=?, status=?, delivery_address=? ,customer_name =? ,phone =? where o_id=?";

        try(Connection con = dbconn.getcon();
            PreparedStatement pstmt = con.prepareStatement(up_query))
        {

            pstmt.setInt(1, order.getUserid());
            pstmt.setDate(2, order.getOrder_date());
            pstmt.setInt(3, order.getT_amt());
            pstmt.setString(4, order.getStatus());
            pstmt.setString(5, order.getDelivery_address());
            pstmt.setInt(8, order.getO_id());
            pstmt.setString(6,order.getCustomer_name());
            pstmt.setLong(7, order.getPhone());

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteorders(int o_id) {

        String del_query = "delete from orders where o_id=?";

        try(Connection con = dbconn.getcon();
            PreparedStatement pstmt = con.prepareStatement(del_query))
        {

            pstmt.setInt(1, o_id);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<orders> getallorders() {

        String query = "select * from orders";

        ArrayList<orders> orderlist = new ArrayList<>();

        try(Connection con = dbconn.getcon();
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query))
        {

            while(res.next())
            {
                int o_id = res.getInt("o_id");
                int userid = res.getInt("userid");
                Date order_date = res.getDate("order_date");
                int t_amt = res.getInt("t_amt");
                String status = res.getString("status");
                String delivery_address = res.getString("delivery_address");
                String customer_name =res.getString("customer_name");
                Long phone  = res.getLong("phone");

                orders order = new orders(
                        o_id,
                        userid,
                        order_date,
                        t_amt,
                        status,
                        delivery_address,
                        customer_name,
                        phone);

                orderlist.add(order);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return orderlist;
    }
}