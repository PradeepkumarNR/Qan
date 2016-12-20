package com.cisco.questionare.dao;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuestionDaoTest {

	QuestionDao questionDao;

	@Before
	public void setUp() throws Exception {
		questionDao = new QuestionDao(new ConnectionManager());

	}

	@After
	public void tearDown() throws Exception {
		questionDao = null;
	}

	@Test
	public void should_return_all_the_question_numbers_available() {
		Assert.assertEquals(Arrays.asList(1, 2, 3),
				questionDao.getQuestionNumbers());
	}

	@Test
	public void should_return_question_for_a_given_question_number() {
		Assert.assertEquals("What is the capital of India?",
				questionDao.getQuestion(1));
		Assert.assertEquals("What is the capital of Bangalore?",
				questionDao.getQuestion(2));
		Assert.assertEquals(
				"who is the outstanding contributor of cisco in 2012?",
				questionDao.getQuestion(3));
	}

	@Test
	public void should_return_empty_if_there_is_no_questiontext_for_given_questionNumber() {
		Assert.assertNull(questionDao.getQuestion(0));
	}

}
