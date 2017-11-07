package com.interview.messageprocesstest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.interview.messageprocess.MessageProcessor;

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
			 for (int i = 0; i <60; i++) {
		            result = processor.processType1("apple at 10p");
				}
			 boolean processType3 = processor.processType3("test 10p");
			 Assert.assertFalse(result);
			 Assert.assertFalse(processType3);
			
		}
	    @Test
		public void testProcessType1Process1InputBelow50(){
			MessageProcessor processor = new MessageProcessor();
			boolean result = false ;
			Map<String,Long> map=new HashMap<String,Long>();
			 for (int i = 0; i < 50; i++) {
		            result = processor.processType1("apple at 10p");
				}
		 Assert.assertTrue(result);
		 String resultString ="";
		 for(int i=0;i<4;i++){
			 resultString = resultString + "apple" + "\t\t" + map.get(i) + "p";
		 }
		 Assert.assertEquals("apple		100p\napple		200p\napple		300p\napple		400p\napple		500p", outContent.toString());
	}
	
		
		
	
		
		@Test(expected=ArrayIndexOutOfBoundsException.class)
		public void testProcessType1Process1InputEmptyString(){
			 MessageProcessor processor = new MessageProcessor();
			
		     boolean result = processor.processType1("appleat10p");
             Assert.assertTrue(result);
		}
		
		@Test
		public void testProcessType1Process1ValidInput(){
			 MessageProcessor processor = new MessageProcessor();
			 boolean result = processor.processType1("apple at 10p");
			 Assert.assertTrue(result);
		}

		@Test
		public void testProcessType2Empty(){
			MessageProcessor processor=new MessageProcessor();
			boolean result=processor.processType2(null);
			Assert.assertFalse(result);
			
		}
		@Test
		public void testProcessType2Process2InputBelow50(){
			MessageProcessor processor=new MessageProcessor();
			boolean result=false;
			for(int i=0;i<50;i++){
			result=processor.processType2("20 sales of apples at 10p");
			}
			
			Assert.assertTrue(result);
		
		}
	   @Test
	   public void testProcessType2Process2InputAbove50(){
		   MessageProcessor processor=new MessageProcessor();
		   boolean result=false;
		   for(int i=0;i<60;i++){
			   result=processor.processType2("20 sales of apples at 10p");
		   }
		   Assert.assertFalse(result);
	   

		}
	   @Test
	   public void testProcessType2Process2ValidInput(){
		   MessageProcessor processor=new MessageProcessor();
		   boolean result=processor.processType2("20 sales of apples at 10p");
		   Assert.assertTrue(result);
	   }
	   @Test(expected=ArrayIndexOutOfBoundsException.class)
	   public void testProcessType2InuputEmptyString(){
		   MessageProcessor processor=new MessageProcessor();
		   boolean result=processor.processType2("20salesofapples");
		   Assert.assertTrue(result);
	   }
	   
	   
}
