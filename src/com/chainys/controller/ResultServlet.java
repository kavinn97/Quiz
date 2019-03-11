package com.chainys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.ResultDAO;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("cname");
		ResultDAO dao = new ResultDAO();
		int count = 0;
		String userans;
		ArrayList<String> list = null;
		try {
			if (cname.equalsIgnoreCase("c")) {
				list = dao.cAnswer();
			} else if (cname.equalsIgnoreCase("java")) {
				list = dao.javaAnswer();
			} else if (cname.equalsIgnoreCase("html")) {
				list = dao.htmlAnswer();
			}
			int i = 1;
			for (String result : list) {

				userans = String.valueOf(i);
				String ans = request.getParameter(userans);
				if (ans.equalsIgnoreCase(result)) {
					count++;
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to validate");
		}
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("finalresult.jsp");
		rd.forward(request, response);
	}
}
