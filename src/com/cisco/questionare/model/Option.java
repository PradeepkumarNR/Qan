package com.cisco.questionare.model;

public class Option {

	private Integer id;

	private String answer;

	public Option() {
	}

	public Option(String answer) {
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
