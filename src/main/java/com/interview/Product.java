package com.interview;

public class Product implements Comparable<Product> {

	private String type;
	private long value;
	private int size;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public Product(String type, Long value, Integer size) {
		this.type = type;
		this.value = value;
		this.size = size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return type + " : " + value + " : " + size;
	}

	public int compareTo(Product o) {
		return o.getType().compareTo(this.getType());
	}

	@Override
	public boolean equals(Object obj) {
		Product product = (Product) obj;
		return this.getType().equals(product.getType());
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
