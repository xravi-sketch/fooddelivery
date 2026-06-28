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


@WebServlet("/deletecartservlet")
public class deletecartservlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		  
	     int  cartid = Integer.parseInt(req.getParameter("cart_id"));
	     
	     cartdaoimpl dao = new cartdaoimpl();
	     
	    dao.deletecart(cartid); 
	    
	    List<cart> cartList =  dao.getallcart();
	    
	    req.setAttribute("cartList", cartList);
	    
	    RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
	    
	     rd.forward(req, resp);
	}

}
