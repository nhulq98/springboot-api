package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.mapper.IRowMapper;
import com.laptrinhjavaweb.repository.jdbc.IBaseJDBC;
import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BaseJDBCImpl implements IBaseJDBC{
	private static ResourceBundle dbResourceBundle = ResourceBundle.getBundle("application");
	private static String PASSWORD = dbResourceBundle.getString("password");
	private static String URL = dbResourceBundle.getString("url");
	private static String USER = dbResourceBundle.getString("userName");
	private static String DRIVER_NAME = dbResourceBundle.getString("driverName");

	private static Connection connection = getConnection();
	private Statement statement;
	private ResultSet resultSet;

	public static Connection getConnection() {
		try {
			// Load the Connector driver
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			return null;
		}

	}

	public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return;
		}
	}

	public static void setParameters(Statement statement, Object... parameters) {
//		try {
//			for (int i = 0; i < parameters.length; i++) {
//				// way 1:
//				// statement.setObject(i + 1, parameters[i]);
//
//				// way 2:
//				Object parameter = parameters[i];
//				int index = i + 1;
//				if (parameter instanceof Long) {
//					statement.setLong(index, (Long) parameter);
//				} else if (parameter instanceof String) {
//					statement.setString(index, (String) parameter);
//				} else if (parameter instanceof Timestamp) {
//					statement.setTimestamp(index, (Timestamp) parameter);
//				} else if (parameter instanceof Integer) {
//					statement.setInt(index, (Integer) parameter);
//				} else if (parameter == null) {
//					statement.setNull(index, Types.NULL);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	//@Override
	public <T> List<T> query(String sql, IRowMapper<T> objectMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		try {
			connection.setAutoCommit(false);
			statement = connection.createStatement();

			// set parameters
//			if(parameters.length != 0){
//				setParameters(statement, parameters);
//			}
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				//get All data from resultset
				results.add(objectMapper.mapRow(resultSet));
			}
			connection.commit();
			return results;

		} catch (SQLException e) {
			try {
				if(connection != null){
					connection.rollback();
				}
			}catch (SQLException e1){
				e1.printStackTrace();
			}

			return new ArrayList<>();
		} finally {

			closeAll(connection, statement, resultSet);
			//connectionPool.releaseConnection(connection);
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Long id = null;
		try{
			connection.setAutoCommit(false);
			//statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement = connection.createStatement();
			// set parameter
			//setParameters(statement, parameters);

			statement.executeUpdate(sql);
//			ResultSet resultSet = statement.getGeneratedKeys();
//			if(resultSet.next()){
//				id = resultSet.getLong(1);
//			}
			connection.commit();
			return 0L;
		}catch (SQLException e){
			try {
				connection.rollback();// return and database not change
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return 0L;
		}finally {
			closeAll(connection, statement, resultSet);
		}
	}

	//generic function for update and delete in database
	@Override
	public void update(String sql, Object... parameters) {
		try{
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			// set parameter
			//setParameters(statement, parameters);

			statement.executeUpdate(sql);

			connection.commit();
		}catch (SQLException e){
			try {
				connection.rollback();// return and database not affected
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}finally {
			closeAll(connection, statement, resultSet);
		}
	}
}
