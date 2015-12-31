package com.samuelbristol.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.samuelbristol.math.Range;

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
		
		System.out.printf("%s\n%s\n%s\n%s\n",
						  "1) Calculate Yearly Income",
						  "2) Calculate Weekly Income",
						  "3) Calculate BiWeekly Income",
						  "0) Exit");
		
		// Create a BufferedReader to get console input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Get selection
		int selection = -1;
		boolean validSelection = false;
		while (!validSelection) {
			selection = getIntFromConsole(reader, "Please enter your selection (1-4):");
			validSelection = Range.intInRangeExclusive(selection, 0, 5);
			if (selection == 0) {
				System.out.println("Thank you. Exiting...");
				System.exit(0);
			}
		}
		
		// Get hourly wage and hours per week
		double hourlyWage = getDoubleFromConsole(reader, "Please enter your hourly wage (e.g. 15.00):");
		double hoursWorkedWeekly = getDoubleFromConsole(reader, "Please enter the number of hours worked " + 
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
	
	public static int getIntFromConsole(BufferedReader reader) {
		int value = 0;
		
		boolean validValue = false;
		while (!validValue) {
			try {
				value = Integer.parseInt(reader.readLine());
				validValue = true;
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid integer value and try again.");
			} catch (IOException ex) {
				System.out.println("Please enter a valid integer value and try again.");
			}
		}
		
		return value;
	}
	
	public static int getIntFromConsole(BufferedReader reader, String message) {
		System.out.println(message);
		return getIntFromConsole(reader);
	}
	
	public static double getDoubleFromConsole(BufferedReader reader) {
		double value = 0.0;
		
		boolean validValue = false;
		while (!validValue) {
			try {
				value = Double.parseDouble(reader.readLine());
				validValue = true;
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid decimal value and try again.");
			} catch (IOException ex) {
				System.out.println("Please enter a valid decimal value and try again.");
			}
		}
		
		return value;
	}
	
	public static double getDoubleFromConsole(BufferedReader reader, String message) {
		System.out.println(message);
		return getDoubleFromConsole(reader);
	}
}
