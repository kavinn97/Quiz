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

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultServlet() {
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

		HttpSession session = request.getSession();
		int row = (int) session.getAttribute("rows");
		ResultDAO dao = new ResultDAO();
		int count = 0;
		// System.out.println(row);
		int max = row;
		String temp;
		PrintWriter out = response.getWriter();

		try {
			ArrayList<String> list = dao.Canswer();
			int i = 1;
			for (String result : list) {

				temp = String.valueOf(i);
				String ans = request.getParameter(temp);
				if (ans.equalsIgnoreCase(result)) {
					count++;
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("finalresult.jsp");
		rd.forward(request, response);
	}

}