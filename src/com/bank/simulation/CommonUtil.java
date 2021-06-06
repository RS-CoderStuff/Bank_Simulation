package com.bank.simulation;

public class CommonUtil {

	private static double xValueYellowCustomer;
	private static double xValueRedCustomer;
	private static double xValueBlueCustomer;

	public static int getProcessingTime(String customerType) {
		int processingTime = 0;
		if (customerType.equals("yellow")) {
			processingTime = calculateProcessingTime(xValueForYellowCust(), 2, 5, 200);
		} else if (customerType.equals("red")) {
			processingTime = calculateProcessingTime(xValueForRedCust(), 2, 2, 200);
		} else if (customerType.equals("blue")) {
			processingTime = calculateProcessingTime(xValueForBlueCust(), 5, 1, 200);
		}
		return processingTime;
	}
	
	/*
	 * Calculate processing time based on the equation
	 * 
	 */
	private static int calculateProcessingTime(double x, int alpha, int beta, int pie) {
		double value = (Math.pow(x, (alpha-1)))*(Math.pow((1-x), (beta-1)));
		return (int) (pie*value);
	}
	
	/*
	 * Value of x between 0 to 1
	 * for yellow customer.
	 * Using random function to guess the value
	 */
	public static double xValueForYellowCust() {
		if (xValueYellowCustomer > 0) {
			return xValueYellowCustomer;
		}
		xValueYellowCustomer =   Math.round((Math.random())*100.0)/100.0;
		return xValueYellowCustomer;
	}
	
	/*
	 * Value of x between 0 to 1
	 * for red customer.
	 * Using random function to guess the value
	 */
	public static double xValueForRedCust() {
		if (xValueRedCustomer > 0) {
			return xValueRedCustomer;
		}
		xValueRedCustomer =   Math.round((Math.random())*100.0)/100.0;
		return xValueRedCustomer;
	}
	
	/*
	 * Value of x between 0 to 1
	 * for blue customer.
	 * Using random function to guess the value
	 */
	public static double xValueForBlueCust() {
		if (xValueBlueCustomer > 0) {
			return xValueBlueCustomer;
		}
		xValueBlueCustomer =   Math.round((Math.random())*100.0)/100.0;
		return xValueBlueCustomer;
	}
}
