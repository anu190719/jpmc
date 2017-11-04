package com.interview;
import org.junit.Test;
import junit.framework.Assert;

public class MessageProcessorTest {
		
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
			 Assert.assertFalse(result);
			
		}
		
		@Test
		public void testProcessType1Process1InputBelow50(){
			MessageProcessor processor = new MessageProcessor();
			boolean result = true ;
			 for (int i = 0; i <50; i++) {
		            result = processor.processType1("apple at 10p");
				}
			 Assert.assertTrue(result);
			
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
		
}
