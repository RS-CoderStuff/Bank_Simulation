package com.bank.simulation;

import java.util.LinkedList;
import java.util.Scanner;

public class BankSimulation {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter no of seconds for which bank simulaton should run :: ");  
		int simulationTime= sc.nextInt();  

		CustomerQueue yellowCustomerQueue= executeBankSimulation(simulationTime, "yellow");
		CustomerQueue redCustomerQueue= executeBankSimulation(simulationTime, "red");
		CustomerQueue blueCustomerQueue= executeBankSimulation(simulationTime, "blue");
		
		System.out.println("********Yellow Customer********");
		System.out.println("Value of 'x' in equation for calculate processing time :: "+ CommonUtil.xValueForYellowCust());
		displayValue(yellowCustomerQueue, "yellow");
		System.out.println("********Red Customer********");
		System.out.println("Value of 'x' in equation for calculate processing time :: "+ CommonUtil.xValueForRedCust());
		displayValue(redCustomerQueue, "red");
		System.out.println("********Blue Customer********");
		System.out.println("Value of 'x' in equation for calculate processing timer :: "+ CommonUtil.xValueForBlueCust());
		displayValue(blueCustomerQueue, "blue");
		System.out.println("********closest value between the average and maximum customer waiting times********");
		String type = closeDiffBetwMaxAvgWaitingTime(yellowCustomerQueue, redCustomerQueue, blueCustomerQueue);
		System.out.println(type);
	}
	
	
	private static CustomerQueue executeBankSimulation(int simulationTime, String customerType) {
		CustomerQueue customerQueue =  new CustomerQueue();
		customerQueue.setBankQueue(new LinkedList<Customer>());
		customerQueue.setCustomerType(customerType);
		Customer customer = null;
		int customerWaitTime = 0;
		for(int time =1; time<=simulationTime; time++) {
			if(checkCustomerArrival(time)) {
				customerQueue.getBankQueue().add(new Customer(time, customerType));
			}
			if(!customerQueue.getBankQueue().isEmpty() && customerQueue.getTellerAvailable()<=time) {
				customer = customerQueue.getBankQueue().remove();
				customerQueue.setTellerAvailable(customerQueue.getTellerAvailable() + customer.getProcessingTime());
				customerWaitTime = time - customer.getArrivalTime();
				setMaxWaitingTime(customerWaitTime, customerQueue);
				customerQueue.setTotalWaitingTime(customerQueue.getTotalWaitingTime()+customerWaitTime);
				customerQueue.setTotalCustomerServe(customerQueue.getTotalCustomerServe()+1);
				customerQueue.setTotalQueueLength(customerQueue.getTotalQueueLength()+customerQueue.getBankQueue().size());
				setMaxQueueLength(customerQueue.getBankQueue().size(), customerQueue);
			}
		}
		customerQueue.setUnAttendedCustomer(customerQueue.getBankQueue().size());
		setAverageWaitingTime(customerQueue);
		setAverageQueueLength(customerQueue);
		return customerQueue;
	}
	
	private static void displayValue(CustomerQueue customerQueue,  String customerType) {
		System.out.println("Customer Processing Time :: "+ CommonUtil.getProcessingTime(customerType));
		System.out.println("Customer Serve by teller :: "+customerQueue.getTotalCustomerServe());
		System.out.println("Average Customer Waiting Time :: "+customerQueue.getAvrageWaitingTime());
		System.out.println("Maximum Customer Waiting Time :: "+customerQueue.getMaxWaitingTime());
		System.out.println("Average Queue Length :: "+customerQueue.getAverageQueueLength());
		System.out.println("Maximum Queue Length :: "+customerQueue.getMaxQueueLength());
		System.out.println("UnAttended Customer in Queue  :: "+customerQueue.getMaxQueueLength());


	}
	
	private static String closeDiffBetwMaxAvgWaitingTime(CustomerQueue queue1, CustomerQueue queue2, CustomerQueue queue3) {
		double closeDiffQueue1 = queue1.getMaxWaitingTime()-queue1.getAvrageWaitingTime();
		double closeDiffQueue2 = queue2.getMaxWaitingTime()-queue2.getAvrageWaitingTime();
		double closeDiffQueue3 = queue3.getMaxWaitingTime()-queue3.getAvrageWaitingTime();
		
		if (closeDiffQueue1 <= closeDiffQueue2 && closeDiffQueue1 <= closeDiffQueue3) {
		   return  queue1.getCustomerType();
		} else if (closeDiffQueue2 <= closeDiffQueue3 && closeDiffQueue2 <= closeDiffQueue3) {
			 return  queue2.getCustomerType();
		} else {
			 return  queue3.getCustomerType();
		}
	}
	
	private static void setAverageQueueLength(CustomerQueue customerQueue) {
		double averageQueueLength = customerQueue.getTotalQueueLength() / 
										customerQueue.getTotalCustomerServe();
		customerQueue.setAverageQueueLength(averageQueueLength);
	}
	
	private static void setAverageWaitingTime(CustomerQueue customerQueue) {
		double averageWaitingTime = customerQueue.getTotalWaitingTime() /
										customerQueue.getTotalCustomerServe();
		customerQueue.setAvrageWaitingTime(averageWaitingTime);
	}
	
	private static void setMaxQueueLength(int currentQueueSize, CustomerQueue customerQueue) {
		if(currentQueueSize > customerQueue.getMaxQueueLength()) {
			customerQueue.setMaxQueueLength(currentQueueSize);
		}
	}
	
	private static void setMaxWaitingTime(int customerWaitTime, CustomerQueue customerQueue) {
		if(customerWaitTime > customerQueue.getMaxWaitingTime()) {
			customerQueue.setMaxWaitingTime(customerWaitTime);
		}
	}
	
	/*
	 * Checking customer arrival probability on particular time.
	 * if probability > 50 then adding customer
	 * else not adding customer in queue
	 * 
	 */
	private static boolean checkCustomerArrival(int time) {
		if (customerArrivalProbability(time)>=50)
			return true;
		return false;
	}

	/*
	 * Based on the given equation in problem, need to find the probability
	 * Using exponential  function and alpha = 100
	 * calculating F(t) value
	 * And over the time Probability will tends to 1
	 * 
	 */
	private static int customerArrivalProbability(int time) {
		double value = time/100;
		double d = 1- Math.exp(-value);
		int probability = (int) (d*100);
		return probability;
	}
}
