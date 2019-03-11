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

import com.chainsys.dao.MemberDAO;
import com.chainsys.model.Members;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ((request.getParameter("name").length() > 2)&& (request.getParameter("dob").length()>2)){
			String name = request.getParameter("name");
			LocalDate dob = LocalDate.parse(request.getParameter("dob"));
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Members member = new Members();
			member.setName(name);
			member.setDob(dob);
			member.setGender(gender);
			member.setEmail(email);
			member.setPassword(password);
			MemberDAO dao = new MemberDAO();
			try {
				boolean b = dao.checkMember(member);
				if (b) {
					try {
						dao.addMember(member);
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("Unable to add member");
					}
					RequestDispatcher rd = request
							.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("message", "!!!Invalid Signup!!!");
					RequestDispatcher rd = request
							.getRequestDispatcher("signup.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to check member");
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.include(request, response);
		}
	}
}
