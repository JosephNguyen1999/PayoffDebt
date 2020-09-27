/*
 * PayoffDebt.java
 * Author:  Joseph Nguyen
 * Submission Date:  1/28/2020
 *
 * Purpose: The purpose of this program is to calculate the net pay after taking off the deductions from the gross pay 
 * which is calculated based on an input of how many hours have been worked for the week.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

import java.util.Scanner;

public class PayoffDebt {

	public static void main(String[] args) {
		
		//variables
		double principal;
		double annualInterestRate;
		double monthlyPayment;
		double monthsNeededToPayOff;
		double totalAmountPaid;
		double totalInterestPaid;
		double overpayment;
		
		//using scanner so that we can keyboard input for principal, annual interest rates, and monthly payment
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Principal:\t\t\t");
		principal = keyboard.nextDouble();
		System.out.print("Annual Interest Rate (%):\t");
		annualInterestRate = keyboard.nextDouble();
		System.out.print("Monthly Payment:\t\t");
		monthlyPayment = keyboard.nextDouble();
		
		//just for formatting purposes
		System.out.println("");
		
		//calculation for the months needed to pay off and also another variable for months needed to pay off so that it is a an integer in the end instead of double
		monthsNeededToPayOff = (Math.log(monthlyPayment) - (Math.log(monthlyPayment - ((annualInterestRate/1200.0)*principal))))/(Math.log((annualInterestRate/1200.0)+1.0)); 
		int monthsNeededToPayOffInt;
		monthsNeededToPayOffInt = (int) Math.ceil(monthsNeededToPayOff);
		System.out.println("Months Needed To Pay Off:\t" + monthsNeededToPayOffInt);
		
		//calculation for total amount paid
		totalAmountPaid = monthlyPayment * Math.ceil(monthsNeededToPayOff);
		System.out.print("Total Amount Paid:\t\t$");
		System.out.format("%.02f%n", totalAmountPaid);
		
		//calculation for total interest paid
		totalInterestPaid = totalAmountPaid - principal;
		System.out.print("Total Interest Paid:\t\t$");
		System.out.format("%.02f%n", totalInterestPaid);
		
		//calculation for overpayment
		overpayment = (Math.ceil(monthsNeededToPayOff) * monthlyPayment) - (monthsNeededToPayOff * monthlyPayment);
		System.out.print("Overpayment:\t\t\t$");
		System.out.format("%.02f%n", overpayment);
		
		keyboard.close();
		
	}

}
