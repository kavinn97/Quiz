package com.chainsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.chainsys.util.ConnectionUtil;


public class ForgetpasswordDAO {
	ResultSet resultSet=null;
	public boolean alterpassword(String email,LocalDate dob,String newpassword) throws SQLException{
		Connection connection = ConnectionUtil.getConnection();
		String sql ="select * from members where email=? and dob=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setDate(2, Date.valueOf(dob));
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			
			String sql1="update members set password=? where email=?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setString(1, newpassword);
			preparedStatement1.setString(2, email);
			resultSet=preparedStatement1.executeQuery();
			preparedStatement.close();
			connection.close();
			return true;
		}
		preparedStatement.close();
		connection.close();
		return false;
	}
}
