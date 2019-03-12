package com.chainys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.ForgetpasswordDAO;

/**
 * Servlet implementation class ForgetpasswordServlet
 */
@WebServlet("/ForgetpasswordServlet")
public class ForgetpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		String newpassword = request.getParameter("newpassword");
		ForgetpasswordDAO fg = new ForgetpasswordDAO();
		try {
			fg.alterpassword(email, dob, newpassword);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get the value");
		}
	}
}
