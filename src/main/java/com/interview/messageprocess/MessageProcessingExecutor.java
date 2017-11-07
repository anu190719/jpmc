package com.interview.messageprocess;

public class MessageProcessingExecutor 
{
    public static void main( String[] args )
    {
        MessageProcessor processor =  new MessageProcessor();
        for (int i = 0; i < 50; i++) {
            processor.processType1("apple at 10p");
		}
        processor.processType3("Subtract 20p apple");

        MessageProcessor processor1 =  new MessageProcessor();
        for (int i = 0; i < 50; i++) {
        	processor1.processType2("20 sales of apples at 10p");
		}
        
    }
}
