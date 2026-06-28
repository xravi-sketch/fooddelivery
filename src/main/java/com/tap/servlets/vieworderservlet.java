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

import com.tap.daoimpl.ordersdaoimpl;
import com.tap.model.User;
import com.tap.model.orders;

@WebServlet("/vieworderservlet")
public class vieworderservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        ordersdaoimpl dao = new ordersdaoimpl();

        // Better: create getOrdersByUser(user.getUserid())
        List<orders> orderList = dao.getallorders();

        req.setAttribute("orderList", orderList);

        RequestDispatcher rd = req.getRequestDispatcher("orders.jsp");
        rd.forward(req, resp);
    }
}