package com.cisco.questionare.services;

import java.util.ArrayList;
import java.util.List;

import com.cisco.questionare.dao.OptionDao;
import com.cisco.questionare.dao.QuestionDao;
import com.cisco.questionare.model.Option;
import com.cisco.questionare.model.Question;

public class QuestionService {

	private QuestionDao questionDao = null;

	private OptionDao optionDao = null;

	public QuestionService(QuestionDao questionDao, OptionDao optionDao) {
		this.questionDao = questionDao;
		this.optionDao = optionDao;
	}

	public List<Question> getAllQuestions() {

		List<Integer> questionNumbers = questionDao.getQuestionNumbers();

		List<Question> questions = new ArrayList<Question>();

		for (int i = 0; i < questionNumbers.size(); i++) {
			// take question number
			Integer questionNumber = questionNumbers.get(i);

			List<Option> options = optionDao.getOptions(questionNumber);

			// get question using the question number
			String question = questionDao.getQuestion(questionNumber);

			Question questionObj = new Question(questionNumber, question,
					options);
			questions.add(questionObj);
		}

		return questions;
	}

}
