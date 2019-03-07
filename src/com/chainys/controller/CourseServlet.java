package com.chainys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String course = request.getParameter("coursetype");
		// PrintWriter out=response.getWriter();
		// out.println(course);

		// HttpServletResponse httpResponse = null;
		// httpResponse.setHeader("Cache-Control",
		// "no-cache, no-store, must-revalidate");
		// httpResponse.setHeader("Pragma", "no-cache");
		// httpResponse.setDateHeader("Expires", 0);
		if (course.equalsIgnoreCase("c")) {
			CourseDAO dao = new CourseDAO();
			try {
				int rows = dao.Rows();
				HttpSession session = request.getSession();
				session.setAttribute("rows", rows);

				ArrayList<C> clist = dao.C(course);
				request.setAttribute("C", clist);
				RequestDispatcher rd = request
						.getRequestDispatcher("clist.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (course.equalsIgnoreCase("java")) {
			CourseDAO dao = new CourseDAO();
			try {
				int rows = dao.Rows();
				HttpSession session = request.getSession();
				session.setAttribute("rows", rows);
				ArrayList<Java> javalist = dao.Java(course);
				request.setAttribute("java", javalist);
				RequestDispatcher rd = request
						.getRequestDispatcher("javalist.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (course.equals("html")) {
			CourseDAO dao = new CourseDAO();
			try {
				int rows = dao.Rows();
				HttpSession session = request.getSession();
				session.setAttribute("rows", rows);
				ArrayList<Html> htmllist = dao.Html(course);
				request.setAttribute("html", htmllist);
				RequestDispatcher rd = request
						.getRequestDispatcher("htmllist.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
}
