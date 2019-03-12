package com.chainys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.CourseDAO;
import com.chainsys.model.C;
import com.chainsys.model.Html;
import com.chainsys.model.Java;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String course = request.getParameter("coursetype");
		if (course.equalsIgnoreCase("c")) {
			CourseDAO dao = new CourseDAO();
			try {
				int rows = dao.Rows();
				HttpSession session = request.getSession();
				session.setAttribute("rows", rows);

				List<C> clist = dao.c(course);
				request.setAttribute("C", clist);
				RequestDispatcher rd = request
						.getRequestDispatcher("clist.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to print questions");
			}
		} else if (course.equalsIgnoreCase("java")) {
			CourseDAO dao = new CourseDAO();
			try {
				int rows = dao.Rows();
				HttpSession session = request.getSession();
				session.setAttribute("rows", rows);
				List<Java> javalist = dao.java(course);
				request.setAttribute("java", javalist);
				RequestDispatcher rd = request
						.getRequestDispatcher("javalist.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to print questions");
			}
		} else if (course.equals("html")) {
			CourseDAO dao = new CourseDAO();
			try {
				int rows = dao.Rows();
				HttpSession session = request.getSession();
				session.setAttribute("rows", rows);
				List<Html> htmllist = dao.html(course);
				request.setAttribute("html", htmllist);
				RequestDispatcher rd = request
						.getRequestDispatcher("htmllist.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to print questions");
			}
		}
	}
}
