package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.fooditemdaoimpl;
import com.tap.model.fooditem;


@WebServlet("/menuservlet")
public class menuservlet extends HttpServlet {
	
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	     
	 int r_id =Integer.parseInt(req.getParameter("r_id"));
	 
	 fooditemdaoimpl dao = new fooditemdaoimpl();
	 
	 System.out.println("Restaurant ID = " + r_id);
	 
	 List<fooditem> fooditems = dao.getFoodByRestaurant(r_id);
	 
	 System.out.println("Food Items = " + fooditems.size());
	 
	 req.setAttribute("fooditems", fooditems);
	 
	 
	 
	 RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
	 
	  rd.forward(req, resp);
	
   }

}
