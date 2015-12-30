package com.samuelbristol.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
						  "4) Exit");
		
		// Create a BufferedReader to get console input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Get selection
		int selection = -1;
		boolean validSelection = false;
		
		while (!validSelection) {
			try {
				System.out.println("Please enter your selection (1-4):");
				selection = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException ex) {
				System.out.println("Please enter an integer that corresponds with " + 
								   "an available selection and try again.");
			} catch (IOException ex) {
				ex.printStackTrace();
				System.out.println("Program crashed. Oops!");
				System.exit(0);
			}		
			finally {
				if (selection > 0 && selection < 5) {
					validSelection = true;
				}
			}
		}
		
		switch (selection) {
			case 1:
				//TODO Calculate Yearly Income
				break;
			case 2:
				//TODO Calculate Weekly Income
				break;
			case 3:
				//TODO Calculate BiWeekly Income
				break;
			case 4:
				//TODO Exit
				System.out.println("Thank you. Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Something strange happened.");
				break;
		}
	}

}
