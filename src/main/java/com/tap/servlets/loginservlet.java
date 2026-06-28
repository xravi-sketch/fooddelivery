package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.userdao;
import com.tap.daoimpl.userdaoimpl;
import com.tap.model.User;


@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	  
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	 String username = req.getParameter("username");
         String password = req.getParameter("password");
         
         System.out.println("Username = " + username);
         System.out.println("Password = " + password);


         userdao dao = new userdaoimpl();
         
         User user = dao.getUserByUsername(username);
    	
          System.out.println("User Object = " + user);
         
         if(user != null &&
                 user.getPassword().equals(password)) {
        	 
        	     System.out.println("Login success");

                  HttpSession session = req.getSession();
                  session.setAttribute("user", user);

                  resp.sendRedirect("index.jsp");

              } else {
                   System.out.println("Login failed"); 
            	  
                  resp.sendRedirect("login.jsp");
              }
    }
	

}
