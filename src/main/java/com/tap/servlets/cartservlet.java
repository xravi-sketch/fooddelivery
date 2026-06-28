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
import com.tap.daoimpl.fooditemdaoimpl;
import com.tap.model.User;
import com.tap.model.cart;
import com.tap.model.fooditem;

@WebServlet("/cartservlet")
public class cartservlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		  HttpSession session = req.getSession();
		  
		  User user = (User) session.getAttribute("user");
		  
		  if(user == null) {
			  
			  resp.sendRedirect("login.jsp");
			  return;
		  }
		
		  String foodIdStr = req.getParameter("foodId");
		  
		  System.out.println("foodId = " + foodIdStr);

		  if(foodIdStr == null){
		      resp.getWriter().println("foodId parameter is missing");
		      return;
		  }

		  int foodId = Integer.parseInt(foodIdStr);
		
		fooditemdaoimpl fooddao = new fooditemdaoimpl();
		
		fooditem food = fooddao.getfooditem(foodId);
		
		cart cart =new cart();
		
		cart.setUser_id(user.getUserid());
		cart.setF_id(food.getF_id());
		
		
		cart.setQuantity("1");
		cart.setPrice(food.getPrice());
		cart.setSubtotal(food.getPrice());
		
		cartdaoimpl cartdao = new cartdaoimpl();
		
		cartdao.addcart(cart);
		
		List<cart> cartList = cartdao.getallcart();
		
		req.setAttribute("cartList", cartList);
		
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);
	}

}
