package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.dao.userdao;
import com.tap.daoimpl.userdaoimpl;
import com.tap.model.User;


@WebServlet("/registerservlet")
public class registerservlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
        
		String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Long phone = Long.parseLong(req.getParameter("phone"));
        String address = req.getParameter("address");
        String role = req.getParameter("role");

        User user = new User();

        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneno(phone);
        user.setAddress(address);
        user.setRole(role);

        userdao dao = new userdaoimpl();
        dao.addUser(user);

        resp.sendRedirect("login.jsp");
            
		
	}

}
