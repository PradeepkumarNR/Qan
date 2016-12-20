package com.cisco.questionare.model;

import java.util.List;

public class Question {

	public Question(Integer questionNumber, String question,
			List<Option> options) {
		super();
		this.questionNumber = questionNumber;
		this.question = question;
		this.options = options;
	}

	Integer questionNumber;

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	String question;

	List<Option> options;

}
