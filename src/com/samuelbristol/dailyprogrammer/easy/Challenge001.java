package com.samuelbristol.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.Arrays;

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
								  "There may be a problem with the console." + 
								  "\nStack Trace:\n%s\n", ex.getMessage());
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
		
		// Print information to console and output to file
		String message = String.format("Your name is %s, you are %d years old, and your username is %s.", name, age, redditUsername);
		try {
			writeToFile(message, "challenge001_output.txt", Charset.forName("UTF-8"));
		} catch (IOException ex) {
			System.out.println("A fatal error occurred. Exiting...");
			ex.printStackTrace();
			System.exit(0);
		} finally {
			System.out.println("Thank you for using this program. Exiting...");
		}	
	}

	public static void writeToFile(String message, String fileName, Charset charset) throws IOException{
		System.out.println("Writing data to file...");
		Path filePath = Paths.get(fileName);
		try {
			Files.createFile(filePath);
			Files.write(filePath, message.getBytes(charset), StandardOpenOption.WRITE);
		} catch (FileAlreadyExistsException ex) {
			System.out.printf("%s already exists. Deleting file...\n", fileName);
			Files.delete(filePath);
			writeToFile(message, fileName, charset);
		}
	}
}
