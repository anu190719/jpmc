package com.interview.messageprocesstest;

import org.junit.Test;

import com.interview.messageprocess.MessageProcessor;

import junit.framework.Assert;

public class MessageProcessorTest {

	@Test
	public void testProcessType1Empty() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = processor.processType1(null);
		Assert.assertFalse(result);
	}

	@Test
	public void testProcessType1Process1InputAbove50() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = true;
		for (int i = 0; i < 60; i++) {
			result = processor.processType1("apple at 10p");
		}
		boolean processType3 = processor.processType3("test 10p");
		Assert.assertFalse(result);
		Assert.assertFalse(processType3);

	}

	@Test
	public void testProcessType1process3Input() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = processor.processType3("Subtract 20p apple");
		Assert.assertTrue(result);

	}

	@Test
	public void testProcessType1Process1InputBelow50() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = false;
		for (int i = 0; i < 50; i++) {
			result = processor.processType1("apple at 10p");
		}
		Assert.assertTrue(result);

	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testProcessType1Process1InputEmptyString() {
		MessageProcessor processor = new MessageProcessor();

		boolean result = processor.processType1("appleat10p");
		Assert.assertTrue(result);
	}

	@Test
	public void testProcessType1Process1ValidInput() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = processor.processType1("apple at 10p");
		Assert.assertTrue(result);
	}

	@Test
	public void testProcessType2Empty() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = processor.processType2(null);
		Assert.assertFalse(result);

	}

	@Test
	public void testProcessType2Process2InputBelow50() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = false;
		for (int i = 0; i < 50; i++) {
			result = processor.processType2("20 sales of apples at 10p");
		}

		Assert.assertTrue(result);

	}

	@Test
	public void testProcessType2Process2InputAbove50() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = false;
		for (int i = 0; i < 60; i++) {
			result = processor.processType2("20 sales of apples at 10p");
		}
		Assert.assertFalse(result);

	}

	@Test
	public void testProcessType2Process2ValidInput() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = processor.processType2("20 sales of apples at 10p");
		Assert.assertTrue(result);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testProcessType2InuputEmptyString() {
		MessageProcessor processor = new MessageProcessor();
		boolean result = processor.processType2("20salesofapples");
		Assert.assertTrue(result);
	}

}
