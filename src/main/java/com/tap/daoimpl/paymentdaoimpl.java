package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.paymentdao;
import com.tap.model.payment;
import com.tap.utility.dbconn;

public class paymentdaoimpl implements paymentdao {

    @Override
    public void addpayment(payment payment) {

        String ins_query =
        "insert into payment(o_id,payment_method,amount,payment_status,payment_date) values(?,?,?,?,?)";
        int res=0;

        try(Connection con = dbconn.getcon();
            PreparedStatement pstmt = con.prepareStatement(ins_query))
        {

            pstmt.setInt(1, payment.getO_id());
            pstmt.setString(2, payment.getPayment_method());
            pstmt.setInt(3, payment.getAmount());
            pstmt.setString(4, payment.getPayment_status());
            pstmt.setDate(5, payment.getPayment_date());

           res = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public payment getpayment(int payment_id) {

        String get_query =
        "select * from payment where payment_id=?";

        payment pay = null;

        try(Connection con = dbconn.getcon();
            PreparedStatement pstmt = con.prepareStatement(get_query))
        {

            pstmt.setInt(1, payment_id);

            ResultSet res = pstmt.executeQuery();

            if(res.next())
            {
                int o_id = res.getInt("o_id");
                String payment_method = res.getString("payment_method");
                int amount = res.getInt("amount");
                String payment_status = res.getString("payment_status");
                Date payment_date = res.getDate("payment_date");

                pay = new payment(
                        payment_id,
                        o_id,
                        payment_method,
                        amount,
                        payment_status,
                        payment_date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pay;
    }

    @Override
    public void updatepayment(payment payment) {

        String up_query =
        "update payment set o_id=?, payment_method=?, amount=?, payment_status=?, payment_date=? where payment_id=?";

        try(Connection con = dbconn.getcon();
            PreparedStatement pstmt = con.prepareStatement(up_query))
        {

            pstmt.setInt(1, payment.getO_id());
            pstmt.setString(2, payment.getPayment_method());
            pstmt.setInt(3, payment.getAmount());
            pstmt.setString(4, payment.getPayment_status());
            pstmt.setDate(5, payment.getPayment_date());
            pstmt.setInt(6, payment.getPayment_id());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletepayment(payment payment) {

        String del_query =
        "delete from payment where payment_id=?";

        try(Connection con = dbconn.getcon();
            PreparedStatement pstmt = con.prepareStatement(del_query))
        {

            pstmt.setInt(1, payment.getPayment_id());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<payment> getallpayment() {

        String query = "select * from payment";

        ArrayList<payment> paymentlist = new ArrayList<>();

        try(Connection con = dbconn.getcon();
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query))
        {

            while(res.next())
            {
                int payment_id = res.getInt("payment_id");
                int o_id = res.getInt("o_id");
                String payment_method = res.getString("payment_method");
                int amount = res.getInt("amount");
                String payment_status = res.getString("payment_status");
                Date payment_date = res.getDate("payment_date");

                payment pay = new payment(
                        payment_id,
                        o_id,
                        payment_method,
                        amount,
                        payment_status,
                        payment_date);

                paymentlist.add(pay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentlist;
    }
}