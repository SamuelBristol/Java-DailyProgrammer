package com.samuelbristol.dailyprogrammer.easy;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.samuelbristol.console.ConsoleReader;
import com.samuelbristol.numbers.Range;

/**
 * @author samuelbristol
 * Challenge 2 - Easy - Reddit Daily Programmer
 * Found at: https://www.reddit.com/r/dailyprogrammer/comments/pjbj8/easy_challenge_2/
 * Submitted by Reddit user: nottoobadguy
 * Challenge: Hello, coders! An important part of programming is being able to apply 
 * 		your programs, so your challenge for today is to create a calculator application 
 * 		that has use in your life. It might be an interest calculator, or it might be 
 * 		something that you can use in the classroom. For example, if you were in physics 
 * 		class, you might want to make a F = M * A calc.
 * 
 * EXTRA CREDIT: make the calculator have multiple functions! Not only should it be able to 
 * 		calculate F = M * A, but also A = F/M, and M = F/A! 
 * 
 * */

public class Challenge002 {

	public static void main(String[] args) {
		System.out.print("Hours and Wage Calculator\n\n");
		
		System.out.printf("%s\n%s\n%s\n%s\n%s\n",
						  "1) Calculate Yearly Income",
						  "2) Calculate Weekly Income",
						  "3) Calculate BiWeekly Income",
						  "4) Calculate Hourly Pay by Salary",
						  "0) Exit");
		
		// Create an autocloseable ConsoleReader to get console input
		try (ConsoleReader reader = new ConsoleReader(new InputStreamReader(System.in))) {

			// Get selection
			int selection = -1;
			boolean validSelection = false;
			while (!validSelection) {
				selection = reader.getValidInteger("Please enter your selection (1-4):");
				validSelection = Range.intInRangeExclusive(selection, 0, 5);
				if (selection == 0) {
					System.out.println("Thank you. Exiting...");
					System.exit(0);
				}
			}
			
			// Get hourly wage and hours per week
			double hourlyWage = reader.getValidDouble("Please enter your hourly wage (e.g. 15.00):");
			double hoursWorkedWeekly = reader.getValidDouble("Please enter the number of hours worked " + 
					"weekly (e.g. 40.00):");
			
			// Handle each menu choice
			double totalWages = 0.0;
			switch (selection) {
				case 1:
					// Calculate Yearly Income
					totalWages = calculateIncome(hourlyWage, hoursWorkedWeekly, 52);
					
					displayIncome(hourlyWage, hoursWorkedWeekly, totalWages, "yearly");
					break;
				case 2:
					// Calculate Weekly Income
					totalWages = calculateIncome(hourlyWage, hoursWorkedWeekly, 1);
					
					displayIncome(hourlyWage, hoursWorkedWeekly, totalWages, "weekly");
					break;
				case 3:
					// Calculate BiWeekly Income
					totalWages = calculateIncome(hourlyWage, hoursWorkedWeekly, 2);
					
					displayIncome(hourlyWage, hoursWorkedWeekly, totalWages, "bi-weekly");
					break;
				default:
					// Input is clamped, this should never be reached.
					System.out.println("Something strange happened.");
					break;
			}
			
		} catch (IOException ex) {
			System.out.println("Could not close some resources. Exiting...");
			System.exit(0);
		}
	}
	
	private static void displayIncome(double hourlyWage, double hoursWorkedWeekly, double totalWages, String wageType) {
		NumberFormat decimalFormatter = DecimalFormat.getNumberInstance();
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		
		String message = String.format(
				"At %s/hr, %s hrs/wk, you make %s %s.",
				currencyFormatter.format(hourlyWage),
				decimalFormatter.format(hoursWorkedWeekly),
				currencyFormatter.format(totalWages),
				wageType);
		
		System.out.println(message);
	}

	public static double calculateIncome(double hourlyWage, double hoursWorkedWeekly, int howManyWeeks) {
		return hourlyWage * hoursWorkedWeekly * howManyWeeks;
	}
}
