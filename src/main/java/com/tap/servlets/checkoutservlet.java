package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.cartdaoimpl;
import com.tap.model.User;
import com.tap.model.cart;


@WebServlet("/checkoutservlet")
public class checkoutservlet extends HttpServlet {
	
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	 
	  HttpSession session = req.getSession(false);

      if (session == null || session.getAttribute("user") == null) {
          resp.sendRedirect("login.jsp");
          return;
      }

      User user = (User) session.getAttribute("user");

      cartdaoimpl dao = new cartdaoimpl();

      List<cart> cartList = dao.getCartByUser(user.getUserid());
      
      int grandtotal = 0 ;
      
      for(cart c : cartList) {
    	  
    	  grandtotal += c.getSubtotal();
      }
      
      grandtotal += 35 ;

      req.setAttribute("cartList", cartList);
      req.setAttribute("grandtotal", grandtotal);

      RequestDispatcher rd = req.getRequestDispatcher("checkout.jsp");
      rd.forward(req, resp);
	  
}
}
