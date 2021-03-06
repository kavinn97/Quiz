package com.chainsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.model.Members;
import com.chainsys.util.ConnectionUtil;

public class MemberDAO {
	public boolean existingUser(Members member) throws SQLException {
		ResultSet resultSet = null;
		boolean login = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select * from members where email=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		try {
			preparedStatement.setString(1, member.getEmail());
			preparedStatement.setString(2, member.getPassword());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String checkUser = resultSet.getString(5);
				String checkPass = resultSet.getString(6);
				if ((checkUser.equalsIgnoreCase(member.getEmail()))
						&& (checkPass.equals(member.getPassword()))) {
					login = true;
				} else {
					login = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to search the matching record");
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return login;
	}

	public boolean checkMember(Members member) throws SQLException {
		ResultSet resultSet = null;
		boolean signup = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select email from members where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, member.getEmail());
		resultSet = preparedStatement.executeQuery();
		try {
			if (resultSet.next()) {
				signup = false;
				return signup;

			} else {
				signup = true;
				return signup;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return signup;
	}

	public void addMember(Members member) throws Exception {
		ResultSet resultset = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			String sql = "insert into members(id,name,dob,gender,email,password) values(seq.nextval,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, member.getName());
			preparedStatement.setDate(2, Date.valueOf(member.getDob()));
			preparedStatement.setString(3, member.getGender());
			preparedStatement.setString(4, member.getEmail());
			preparedStatement.setString(5, member.getPassword());
			preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, resultset);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add membersS");
		}
	}
}
