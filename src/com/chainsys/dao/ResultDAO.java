package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.util.ConnectionUtil;

public class ResultDAO {
	public ArrayList Canswer() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT answer from c";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<String> list = new ArrayList();
		while (resultSet.next()) {
			list.add(resultSet.getString("answer"));
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;
	}

	public ArrayList JavaAnswer() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT answer from java";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<String> list = new ArrayList();
		while (resultSet.next()) {
			list.add(resultSet.getString("answer"));
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;
	}

	public ArrayList HtmlAnswer() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT answer from html";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<String> list = new ArrayList();
		while (resultSet.next()) {
			list.add(resultSet.getString("answer"));
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;
	}
}
