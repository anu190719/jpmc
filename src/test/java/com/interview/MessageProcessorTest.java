package com.interview;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class MessageProcessorTest {
		
		private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		@Before
		public void setUpStreams() {
		    System.setOut(new PrintStream(outContent));
		}

		@After
		public void cleanUpStreams() {
		    System.setOut(null);
		    System.setErr(null);
		}
		
		@Test
		public void testProcessType1Empty(){
			MessageProcessor processor = new MessageProcessor();
			boolean result = processor.processType1(null);
			Assert.assertFalse(result);
		}
		
		@Test
		public void testProcessType1Process1InputAbove50(){
			MessageProcessor processor = new MessageProcessor();
			boolean result = true ;
			 for (int i = 0; i >50; i++) {
		            result = processor.processType1("apple at 10p");
				}
			 Assert.assertFalse(result);
			
		}		
		
		@Test(expected=ArrayIndexOutOfBoundsException.class)
		public void testProcessType1Process1InputEmptyString(){
			MessageProcessor processor = new MessageProcessor();
			boolean result = false ;
		     result = processor.processType1("appleat10p");
//			 Assert.assertTrue(result);
		}
		
		@Test
		public void testProcessType1Process1ValidInput(){
			MessageProcessor processor = new MessageProcessor();
			boolean result = false ;
		     result = processor.processType1("apple at 10p");
//		     Assert.assertEquals("", outContent.toString());
			 Assert.assertTrue(result);
		}
		
}
