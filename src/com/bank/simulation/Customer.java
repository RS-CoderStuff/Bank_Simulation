package com.bank.simulation;

public class Customer {

	private int arrivalTime;
	private int processingTime;
	private String customerType;
	
	public Customer(int arrivalTime, String customerType) {
		this.arrivalTime = arrivalTime;
		this.customerType = customerType;
		this.processingTime = CommonUtil.getProcessingTime(customerType);
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
}
