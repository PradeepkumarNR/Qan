package com.cisco.questionare.frontend;

import java.util.Iterator;
import java.util.List;

import com.cisco.questionare.model.Option;
import com.cisco.questionare.model.Question;
import com.cisco.questionare.services.QuestionService;

public class FrontEnd {

	private QuestionService questionservice = null;

	public FrontEnd(QuestionService questionservice) {
		this.questionservice = questionservice;
	}

	public String getContentToDisplay() {
		StringBuffer content = new StringBuffer();
		List<Question> questions = questionservice.getAllQuestions();
		for (Question question : questions) {
			content.append(question.getQuestionNumber()).append(":")
					.append(question.getQuestion());
			for (Option option : question.getOptions()) {
				content.append("\n");
				content.append(option.getAnswer());
			}

		}
		return content.toString();
	}

}
