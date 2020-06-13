package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.user;
import utility.ConnectionManager;

public class UserDaoImpl implements UserDaoInterface {

	@Override
	public int signUp(user user) throws ClassNotFoundException {
		
		String INSERT_USERS_SQL = "INSERT INTO hotel(NAME,EMAIL,PASSWORD,ETYPE)VALUES(?,?,?,?)";

		int result = 0;
		try
		{
			Connection connection = ConnectionManager.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2,user.getEmail());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getEmpType());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public boolean loginUser(user user) {
		
		boolean status = false;
		try{
			Connection connection = ConnectionManager.getConnection();
		
				// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement("select * from hotel where EMAIL = ? and PASSWORD = ? and ETYPE=? ");
		
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmpType());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			// process sql exception
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getEmpType());
		System.out.println("return "+status);
		return status;
		

		
		
	}

}
