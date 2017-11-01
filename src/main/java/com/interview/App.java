package com.interview;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MessageProcessor processor =  new MessageProcessor();
        for (int i = 0; i < 60; i++) {
            processor.processType1("apple at 10p");
		}
        //processor.printQueue();
    }
}
