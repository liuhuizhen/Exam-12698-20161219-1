package com.hand.entity;

public class Customer {
	private int customer_id;
	private String first_name;
	public Customer() {
		super();
	}
	public Customer(int customer_id, String first_name) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

}
