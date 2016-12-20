package com.cisco.questionare.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cisco.questionare.model.Option;

public class OptionsDaoTest {

	OptionDao optionDao;

	@Before
	public void setUp() throws Exception {
		optionDao = new OptionDao(new ConnectionManager());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_return_options_for_a_given_question_number() {
		Integer questionNumber = new Integer(1);
		List<Option> options = optionDao.getOptions(questionNumber);

		// compare expected vs actual here
	
		Assert.assertEquals(4, options.size());
		Assert.assertEquals("Bangalore", options.get(0).getAnswer());
		Assert.assertEquals("Chennai", options.get(1).getAnswer());
		Assert.assertEquals("Mumbai", options.get(2).getAnswer());
		Assert.assertEquals("Delhi", options.get(3).getAnswer());
		
	}
	
	@Test
	public void should_return_error_if_there_are_no_options(){
		Integer questionNumber= new Integer(0);
		List<Option> options = optionDao.getOptions(questionNumber);
		Assert.assertEquals(0, options.size());
			
	}

}
