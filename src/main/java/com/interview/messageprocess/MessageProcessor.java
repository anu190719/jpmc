package com.interview.messageprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.interview.beans.Product;
/**
 * MessageProcessor.java
 * @author anu
 *
 */
public class MessageProcessor{
	private List<Product> queue = new ArrayList<Product>();
	private int count = 0;

	/**
	 * processes "apple at 10p" messages and prints the report at certain threshold(10).
	 * accepts the data till 50 messages.
	 * @param message
	 * @return boolean
	 */
	public boolean processType1(String message) {
		if (message == null) {
			return false;
		}
		// verifies no.of counts 
		if (count++ > 50) {
			System.out.println("Processor is pausing, stopped accepting new messages");
			return false;
		}
		String[] values = message.split(" "); 
		// set the message data to Product bean
		Product product = new Product(values[0], Long.parseLong(values[2].substring(0, values[2].length() - 1)), 1);
		queue.add(product);
		// if queue size reaches multiple of 10 print report
		if (queue.size() % 10 == 0) {
			printDetailedReport1();
		}
		return true;
	}
	/**
	 * processes "20 sales of apples at 10p" messages and prints the report at certain threshold(10).
	 * @param message
	 * @return boolean
	 */

	public boolean processType2(String message) {
		if (message == null) {
			return false;
		}
		if (count++ > 50) {
			System.out.println("Processor is pausing, stopped accepting new messages");
			return false;
		}
		String[] values = message.split(" ");
		Product product = new Product(values[1], Long.parseLong(values[5].substring(0, values[5].length() - 1)),
				Integer.parseInt(values[0]));
		queue.add(product);
		if (queue.size() % 10 == 0) {
			printDetailedReport2();
		}
		return true;
	}
	/**
	 * processes "Add,Subtract,multiply " messages and prints the report at certain threshold(10).
	 * @param message
	 * @return boolean
	 */
	public boolean processType3(String message) {
		if (message == null) {
			return false;
		}
		if (count++ > 50) {
			System.out.println("Processor is pausing, stopped accepting new messages");
			return false;
		}
		String[] values = message.split(" ");
		Long value = Long.parseLong(values[1].substring(0, values[1].length() - 1));
		switch (values[0]) {
		case "Add": {
			for (Iterator<Product> iterator = queue.iterator(); iterator.hasNext();) {
				Product product = iterator.next();
				if (product.getType().equals(values[2])) {
					product.setValue(product.getValue() + value);
				
				}
			}
			System.out.println(queue);
			return true;
		}
		case "Subtract": {
			for (Iterator<Product> iterator = queue.iterator(); iterator.hasNext();) {
				Product product = iterator.next();
				if (product.getType().equals(values[2])) {
					product.setValue(product.getValue() - value);
				
				}
			}
			System.out.println(queue);
			return true;
		}
		case "Multiply": {
			for (Iterator<Product> iterator = queue.iterator(); iterator.hasNext();) {
				Product product = iterator.next();
				if (product.getType().equals(values[2])) {
					product.setValue(product.getValue() * value);
				}
			}
			System.out.println(queue);
			return true;
		}
		default: {
			return false;
		}
		}
	}
   /**
    * prints the sale and value details for "apple at 10p"
    * 
    */
	
	
	private void printDetailedReport1(){
		Map<String, Long> map =  new HashMap<>();
		for (Iterator<Product> iterator = queue.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			Long value = 0L;
			if(map.containsKey(product.getType())) {
				value = map.get(product.getType());
			}
			value += (product.getValue() *  product.getSize());
			map.put(product.getType(), value);
		}
		
		Set<String> keys = map.keySet();
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String type = iterator.next();
			System.out.println(queue.size()+type +"s"+ "\t\t" + map.get(type) + "p");
		}
	}
	/**
	 * prints the type and value details for "20 sales of apples at 10p"
	 */
	private void printDetailedReport2(){

		long saleCount = 0;
		long value = 0;
		for(Product product : queue){
			saleCount += product.getSize();
			value += product.getValue() * product.getSize();
		}
		System.out.println(saleCount +" sales of"+ queue.get(0).getType() + " at \t\t" + value + "p");
			}
}
