package com.tap.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.cartdaoimpl;
import com.tap.daoimpl.ordersdaoimpl;
import com.tap.model.User;
import com.tap.model.cart;
import com.tap.model.orders;

@WebServlet("/orderservlet")
public class orderservlet extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doGet(req, resp);
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Customer Details
        String customerName = req.getParameter("customerName");
        String address = req.getParameter("address");
        String phoneStr = req.getParameter("phone");

        if (phoneStr == null || phoneStr.trim().isEmpty()) {
            resp.getWriter().println("Phone number is required");
            return;
        }

        long phone = Long.parseLong(phoneStr);

        // Logged in User
        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int userId = user.getUserid();

        // User Cart
        cartdaoimpl cartDao = new cartdaoimpl();

        List<cart> cartList = cartDao.getCartByUser(userId);

        if (cartList == null || cartList.isEmpty()) {
            resp.getWriter().println("Cart is Empty");
            return;
        }

        // Total Amount
        int totalAmount = 0;

        for (cart c : cartList) {
            totalAmount += c.getSubtotal();
        }

        totalAmount += 5;   // Platform Fee
        totalAmount += 30;  // Delivery Fee

        // Generate Order Id
        ordersdaoimpl orderDao = new ordersdaoimpl();

        int orderId = orderDao.getallorders().size() + 1;

        // Current Date
        Date orderDate = new Date(System.currentTimeMillis());

        // Create Order
        orders order = new orders();

        order.setO_id(orderId);
        order.setUserid(userId);
        order.setOrder_date(orderDate);
        order.setT_amt(totalAmount);
        order.setStatus("Order Placed");
        order.setDelivery_address(address);
        order.setCustomer_name(customerName);
        order.setPhone(phone);

        // Save Order
        orderDao.addorders(order);

        // TODO:
        // 1. Insert into order_items table
        // 2. Insert into payment table
        // 3. Delete user's cart

        resp.sendRedirect("ordersuccess.jsp");
    }
}