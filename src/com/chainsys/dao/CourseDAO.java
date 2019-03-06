package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.C;
import com.chainsys.model.Html;
import com.chainsys.model.Java;
import com.chainsys.util.ConnectionUtil;

public class CourseDAO {
	public ArrayList C(String course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from c";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<C> clist = new ArrayList<C>();
		while (resultset.next()) {
			C cobj = new C();
			cobj.setQuenum(resultset.getInt("quenum"));
			cobj.setQuestions(resultset.getString("questions"));
			cobj.setOption1(resultset.getString("option1"));
			cobj.setOption2(resultset.getString("option2"));
			clist.add(cobj);
		}
		return clist;
	}

	public ArrayList Java(String course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from  java";
		// String sql1="select count(*) from c";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// preparedStatement = connection.prepareStatement(sql1);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<Java> javalist = new ArrayList<Java>();
		while (resultset.next()) {
			Java javaobj = new Java();
			javaobj.setQuenum(resultset.getInt("quenum"));
			javaobj.setQuestions(resultset.getString("questions"));
			javaobj.setOption1(resultset.getString("option1"));
			javaobj.setOption2(resultset.getString("option2"));
			javalist.add(javaobj);
		}
		return javalist;
	}

	public ArrayList Html(String course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from  html";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<Html> htmllist = new ArrayList<Html>();
		while (resultset.next()) {
			Html htmlobj = new Html();
			htmlobj.setQuenum(resultset.getInt("quenum"));
			htmlobj.setQuestions(resultset.getString("questions"));
			htmlobj.setOption1(resultset.getString("option1"));
			htmlobj.setOption2(resultset.getString("option2"));
			htmllist.add(htmlobj);
		}
		return htmllist;
	}

	public int Rows() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select count(*) as num from c";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		resultset.next();
		int rows = resultset.getInt(1);
		return rows;
	}

}
