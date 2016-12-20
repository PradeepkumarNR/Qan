package com.cisco.questionare.frontend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import com.cisco.questionare.model.Option;
import com.cisco.questionare.model.Question;
import com.cisco.questionare.services.QuestionService;

public class QuestionFrontEndTest {

	private FrontEnd frontEnd;

	private QuestionService questionServiceMock;

	@Before
	public void setUp() throws Exception {
		questionServiceMock = Mockito.mock(QuestionService.class);
		frontEnd = new FrontEnd(questionServiceMock);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void should_display_question_and_respective_options() {

		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(1, "Who is super star?", Arrays
				.asList(new Option("Pradeep"))));

		when(questionServiceMock.getAllQuestions()).thenReturn(questions);

		String content = frontEnd.getContentToDisplay();

		verify(questionServiceMock).getAllQuestions();

		
		Assert.assertEquals("1:Who is super star?\nPradeep", content);
	}
}
