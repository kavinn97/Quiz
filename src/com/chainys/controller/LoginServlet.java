package com.chainys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.MemberDAO;
import com.chainsys.model.Members;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("email").length() > 2) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			Members member = new Members();
			member.setEmail(email);
			member.setPassword(password);
			MemberDAO dao = new MemberDAO();

			try {
				boolean b = dao.existingUser(member);
				if (b) {

					HttpSession session = request.getSession();
					session.setAttribute("email", email);

					request.setAttribute("email", email);
					RequestDispatcher rd = request
							.getRequestDispatcher("course.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("message", "!!!Invalid Login!!!");
					RequestDispatcher rd = request
							.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to get the value");
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}
}
