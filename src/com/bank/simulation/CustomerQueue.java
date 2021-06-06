package com.bank.simulation;

import java.util.Queue;

public class CustomerQueue {

	private Queue < Customer > bankQueue;
	private String customerType;
	private int totalWaitingTime;
	private double avrageWaitingTime;
	private int maxWaitingTime;
	private int totalQueueLength;
	private double averageQueueLength;
	private int maxQueueLength;
	private int tellerAvailable;
	private int totalCustomerServe;
	private int unAttendedCustomer;
	
	public Queue<Customer> getBankQueue() {
		return bankQueue;
	}
	public void setBankQueue(Queue<Customer> bankQueue) {
		this.bankQueue = bankQueue;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getTotalWaitingTime() {
		return totalWaitingTime;
	}
	public void setTotalWaitingTime(int totalWaitingTime) {
		this.totalWaitingTime = totalWaitingTime;
	}
	public double getAvrageWaitingTime() {
		return avrageWaitingTime;
	}
	public void setAvrageWaitingTime(double avrageWaitingTime) {
		this.avrageWaitingTime = avrageWaitingTime;
	}
	public int getMaxWaitingTime() {
		return maxWaitingTime;
	}
	public void setMaxWaitingTime(int maxWaitingTime) {
		this.maxWaitingTime = maxWaitingTime;
	}
	public int getTotalQueueLength() {
		return totalQueueLength;
	}
	public void setTotalQueueLength(int totalQueueLength) {
		this.totalQueueLength = totalQueueLength;
	}
	public double getAverageQueueLength() {
		return averageQueueLength;
	}
	public void setAverageQueueLength(double averageQueueLength) {
		this.averageQueueLength = averageQueueLength;
	}
	public int getMaxQueueLength() {
		return maxQueueLength;
	}
	public void setMaxQueueLength(int maxQueueLength) {
		this.maxQueueLength = maxQueueLength;
	}
	public int getTellerAvailable() {
		return tellerAvailable;
	}
	public void setTellerAvailable(int tellerAvailable) {
		this.tellerAvailable = tellerAvailable;
	}
	public int getTotalCustomerServe() {
		return totalCustomerServe;
	}
	public void setTotalCustomerServe(int totalCustomerServe) {
		this.totalCustomerServe = totalCustomerServe;
	}
	public int getUnAttendedCustomer() {
		return unAttendedCustomer;
	}
	public void setUnAttendedCustomer(int unAttendedCustomer) {
		this.unAttendedCustomer = unAttendedCustomer;
	}
	
}
