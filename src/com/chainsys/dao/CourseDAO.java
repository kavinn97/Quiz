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
	public ArrayList<C> c(String course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from c";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<C> clist = new ArrayList<C>();
		while (resultSet.next()) {
			C cobj = new C();
			cobj.setQuenum(resultSet.getInt("quenum"));
			cobj.setQuestions(resultSet.getString("questions"));
			cobj.setOption1(resultSet.getString("option1"));
			cobj.setOption2(resultSet.getString("option2"));
			clist.add(cobj);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return clist;
	}

	public ArrayList<Java> java(String course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from  java";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Java> javalist = new ArrayList<Java>();
		while (resultSet.next()) {
			Java javaobj = new Java();
			javaobj.setQuenum(resultSet.getInt("quenum"));
			javaobj.setQuestions(resultSet.getString("questions"));
			javaobj.setOption1(resultSet.getString("option1"));
			javaobj.setOption2(resultSet.getString("option2"));
			javalist.add(javaobj);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return javalist;
	}

	public ArrayList<Html> html(String course) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from  html";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Html> htmllist = new ArrayList<Html>();
		while (resultSet.next()) {
			Html htmlobj = new Html();
			htmlobj.setQuenum(resultSet.getInt("quenum"));
			htmlobj.setQuestions(resultSet.getString("questions"));
			htmlobj.setOption1(resultSet.getString("option1"));
			htmlobj.setOption2(resultSet.getString("option2"));
			htmllist.add(htmlobj);
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return htmllist;
	}

	public int Rows() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select count(*) as num from c";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int rows = resultSet.getInt(1);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return rows;
	}
}
