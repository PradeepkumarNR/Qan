package com.cisco.questionare.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.cisco.questionare.dao.OptionDao;
import com.cisco.questionare.dao.QuestionDao;
import com.cisco.questionare.model.Option;
import com.cisco.questionare.model.Question;

public class QuestionServiceTest {

	private QuestionDao questionDao;

	private OptionDao optionDao;

	private QuestionService questionService;

	private List<Option> options;

	@Before
	public void setUp() throws Exception {
		questionDao = Mockito.mock(QuestionDao.class);
		optionDao = Mockito.mock(OptionDao.class);
		questionService = new QuestionService(questionDao, optionDao);
		options = new ArrayList<Option>();
		options.add(new Option("who won the CEO award in 2012"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_return_all_question_numbers() {

		expectations();

		List<Question> questions = questionService.getAllQuestions();

		verifications();
		
		
		assertEquals(3, questions.size());
	}

	private void verifications() {
		verify(questionDao).getQuestionNumbers();
		verify(optionDao).getOptions(1);
		verify(questionDao).getQuestion(1);

		verify(optionDao).getOptions(2);
		verify(questionDao).getQuestion(2);

		verify(optionDao).getOptions(3);
		verify(questionDao).getQuestion(3);
	}

	private void expectations() {
		when(questionDao.getQuestionNumbers()).thenReturn(
				Arrays.asList(1, 2, 3));

		when(optionDao.getOptions(1)).thenReturn(options);
		when(questionDao.getQuestion(1)).thenReturn(
				"who won the CEO award in 2012");

		when(optionDao.getOptions(2)).thenReturn(options);
		when(questionDao.getQuestion(2)).thenReturn(
				"who won the CEO award in 2012");

		when(optionDao.getOptions(3)).thenReturn(options);
		when(questionDao.getQuestion(3)).thenReturn(
				"who won the CEO award in 2012");
	}
}
