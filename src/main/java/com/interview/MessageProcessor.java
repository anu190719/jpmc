package com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageProcessor {
	private List<Product> queue = new ArrayList<Product>();
	private int count = 0;

	public boolean processType1(String message) {
		if (message == null) {
			return false;
		}
		if (count++ > 50) {
			System.out.println("Processor is pausing, stopped accepting new messages");
			return false;
		}
		String[] values = message.split(" ");
		Product product = new Product(values[0], Long.parseLong(values[2].substring(0, values[2].length() - 1)), 1);
		queue.add(product);
		if (queue.size() % 10 == 0) {
			printDetailedReport();
		}
		return true;
	}

	public boolean processType2(String message) {
		if (message == null) {
			return false;
		}
		if (count++ > 50) {
			System.out.println("Processor is pausing, stopped accepting new messages");
			return false;
		}
		String[] values = message.split(" ");
		Product product = new Product(values[3], Long.parseLong(values[5].substring(0, values[2].length() - 1)),
				Integer.parseInt(values[0]));
		queue.add(product);
		if (queue.size() % 10 == 0) {
			System.out.println("print logs");
		}
		return true;
	}

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
					System.out.println(product.getValue());
				}
			}
			return true;
		}
		case "Subtract": {
			for (Iterator<Product> iterator = queue.iterator(); iterator.hasNext();) {
				Product product = iterator.next();
				if (product.getType().equals(values[2])) {
					product.setValue(product.getValue() - value);
					System.out.println(product.getValue());
				}
			}
			return true;
		}
		case "Multiply": {
			for (Iterator<Product> iterator = queue.iterator(); iterator.hasNext();) {
				Product product = iterator.next();
				if (product.getType().equals(values[2])) {
					product.setValue(product.getValue() * value);
				}
			}
			return true;
		}
		default: {
			return false;
		}
		}
	}

	public void printQueue() {
		System.out.println(queue);
	}
	
	private void printDetailedReport(){
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
			System.out.println(type + "\t\t" + map.get(type) + "p");
		}
	}
}
