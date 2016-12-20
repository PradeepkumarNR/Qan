package com.cisco.questionare.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {

	private static final String QUESTION_NUMBER = "question_number";

	private static final String QUESTION_QUERY = "SELECT id question_number FROM question";

	private static final String QUESTIONSTRING_QUERY = "SELECT question FROM question WHERE id = ";

	private static final String QUESTION = "question";

	private ConnectionManager connectionManager;

	public QuestionDao(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	public List<Integer> getQuestionNumbers() {
		List<Integer> questionNumbers = new ArrayList<Integer>();
		ResultSet resultSet = connectionManager.getResultSet(QUESTION_QUERY);
		try {
			while (resultSet.next()) {
				Integer questionNumber = resultSet.getInt(QUESTION_NUMBER);
				questionNumbers.add(questionNumber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionManager.cleanUp();
		}
		return questionNumbers;
	}

	public String getQuestion(int i) {
		String questionString = null;
		ResultSet resultSet = connectionManager
				.getResultSet(QUESTIONSTRING_QUERY + i);
		try {
			while (resultSet.next()) {
				questionString = resultSet.getString(QUESTION);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionManager.cleanUp();
		}
		return questionString;
	}
}
