package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.restaurantdaoimpl;
import com.tap.model.restaurant;


@WebServlet("/restaurantservlet")
public class restaurantservlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		try {
			
			restaurantdaoimpl restaurantdao =new restaurantdaoimpl();
			
			List<restaurant> allrestaurant = restaurantdao.getallrestaurant();
			
			
			
			req.setAttribute("restaurants", allrestaurant);
			
			RequestDispatcher rd = req.getRequestDispatcher("restaurant.jsp");
					rd.forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
