package com.cisco.questionare.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/question_bank";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "password";

	private Connection connection = null;

	private Statement statement = null;

	private ResultSet resultSet = null;

	static {
		try {
			Class.forName(COM_MYSQL_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet(String query) {
		try {
			connection = DriverManager
					.getConnection(DB_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultSet;
	}

	public void cleanUp() {
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
