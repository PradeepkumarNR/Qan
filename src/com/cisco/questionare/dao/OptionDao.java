package com.cisco.questionare.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cisco.questionare.model.Option;

public class OptionDao {

	// private static final String QUESTION_NUMBER = "question_number";

	private static final String OPTION_QUERY = "SELECT answer FROM OPTIONS WHERE question_id = ";

	// private static final String QUESTIONSTRING_QUERY =
	// "SELECT question FROM question WHERE id = ";

	private static final String QUESTION = "question";

	private static final String ANSWER = "answer";

	private ConnectionManager connectionManager;

	public OptionDao(ConnectionManager connectionManager) {

		this.connectionManager = connectionManager;

	}

	public List<Option> getOptions(Integer questionNumber) {

		List<Option> options = new ArrayList<Option>();
		ResultSet resultSet = connectionManager.getResultSet(OPTION_QUERY
				+ questionNumber);
		try {
			while (resultSet.next()) {
				options.add(new Option(resultSet.getString(ANSWER)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionManager.cleanUp();
		}
		return options;
	}

}
