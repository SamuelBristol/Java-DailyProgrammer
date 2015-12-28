package com.samuelbristol.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author samuelbristol
 * Challenge 1 - Easy - Reddit Daily Programmer
 * Found at: https://www.reddit.com/r/dailyprogrammer/comments/pih8x/easy_challenge_1/
 * Submitted by Reddit user: nottoobadguy
 * Challenge: create a program that will ask the users name, age, and reddit username. 
 * 		Have it tell them the information back, in the format:
 * 		your name is (blank), you are (blank) years old, and your username is (blank).
 * 		For extra credit, have the program log this information in a file to be 
 * 		accessed later. */

public class Challenge001 {

	public static void main(String[] args) {
		// Variables for name, age, reddit username
		String name = "";
		int age = 0;
		String redditUsername = "";

		// Create a buffered reader for keyboard console input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Get name
		boolean nameValidated = false;
		while (!nameValidated) {
			System.out.println("What is your name? (e.g. John Smith)");
			try {
				name = reader.readLine();
			} catch (Exception ex) {
				System.out.printf("There was a problem getting your name from the console." + 
					"There may be a problem with the console.\nStack Trace:\n%s\n", ex.getMessage());
				System.out.println("The program will now exit.");
				System.exit(0);
			} finally {
				if (!name.isEmpty()) {
					nameValidated = true;
				}
			}
		}
		
		// Get age
		boolean ageValidated = false;
		while (!ageValidated) {
			System.out.println("What is your age? (e.g. 25)");
			try {
				age = Integer.parseInt(reader.readLine());
			} catch (Exception ex) {
				System.out.println("Please enter a positive integer and try again.");
			} finally {
				if (age >= 1) {
					ageValidated = true;
				}
			}
		}
		
		// Get Reddit username
		boolean redditUsernameValidated = false;
		while (!redditUsernameValidated) {
			System.out.println("What is your Reddit username? (e.g. Fauxecke)");
			try {
				redditUsername = reader.readLine();
			} catch (Exception ex) {
				System.out.printf("There was a problem getting your Reddit username from the console." + 
								  "\nStack Trace:%s\n", ex.getMessage());
				System.out.println("The program will now exit.");
				System.exit(0);
			} finally {
				if (!redditUsername.isEmpty()) {
					redditUsernameValidated = true;
				}
			}
		}
	}

}
