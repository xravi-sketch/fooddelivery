package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.cartdaoimpl;
import com.tap.model.cart;


@WebServlet("/updatecartservlet")
public class updatecartservlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		int cartid =Integer.parseInt(req.getParameter("cart_id"));
		
		String action = req.getParameter("action");
		
		cartdaoimpl dao =new cartdaoimpl();
		
		cart cart = dao.getcart(cartid);

		int qty = Integer.parseInt(cart.getQuantity());
		
		if(action.equals("increase")) {
			
			qty++;
		}else if(action.equals("decrease")) {
			
			if(qty>1) {
				qty--;
			}
		}
		
		cart.setQuantity(String.valueOf(qty));
		
		cart.setSubtotal(qty*cart.getPrice());
		
		dao.updatecart(cart);
		
		List<cart> cartList = dao.getallcart();

		req.setAttribute("cartList", cartList);
		 
        RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		
		rd.forward(req, resp);
	}
}
