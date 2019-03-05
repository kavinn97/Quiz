package com.chainys.controller;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDAO {
	public ArrayList Canswer() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT answer from c";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<String> list = new ArrayList();
		while (resultset.next()) {
			list.add(resultset.getString("answer"));
		}
		return list;
	}
	public ArrayList JavaAnswer() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT answer from java";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<String> list = new ArrayList();
		while (resultset.next()) {
			list.add(resultset.getString("answer"));
		}
		return list;
	}
	public ArrayList HtmlAnswer() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT answer from html";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<String> list = new ArrayList();
		while (resultset.next()) {
			list.add(resultset.getString("answer"));
		}
		return list;
	}
}
