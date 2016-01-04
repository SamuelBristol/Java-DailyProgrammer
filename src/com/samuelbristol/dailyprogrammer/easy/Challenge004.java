package com.samuelbristol.dailyprogrammer.easy;

import java.io.IOException;
import java.io.InputStreamReader;

import com.samuelbristol.console.ConsoleReader;

/**
 * @author samuelbristol
 * Challenge 4 - Easy - Reddit Daily Programmer
 * Found at: https://www.reddit.com/r/dailyprogrammer/comments/pm6oj/2122012_challenge_4_easy/
 * Submitted by Reddit user: nottoobadguy
 * Challenge: You're challenge for today is to create a random password generator!
 * Extra Credit: Allow the user to specify the amount of passwords to generate. 
 * 		Allow the user to specify the length of the strings he wants to generate!
 * 
 * */
public class Challenge004 {

	public static void main(String[] args) {
		System.out.println("Random Password Generator");
		
		try (ConsoleReader reader = new ConsoleReader(new InputStreamReader(System.in))) {
			int numberOfPasswords = 0;
			int passwordLength = 0;
			numberOfPasswords = reader.getValidInteger("Please specify the number of passwords to generate:");
			passwordLength = reader.getValidInteger("Please specify the number of characters in each password:");
			
			for(int i = 0; i < numberOfPasswords; i++) {
				System.out.println(createRandomPassword(passwordLength));
			}
			
			
		} catch (IOException ex) {
			System.out.println("A fatal error has ocurred. The console may not be available. Exiting...");
			ex.printStackTrace();
			System.exit(0);
		}
	
	}

	private static String createRandomPassword(int passwordLength) {
		return "password";
	}

}
