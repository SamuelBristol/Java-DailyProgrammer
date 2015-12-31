package com.samuelbristol.dailyprogrammer.easy;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.samuelbristol.console.ConsoleReader;

/**
 * @author samuelbristol
 * Challenge 1 - Easy - Reddit Daily Programmer
 * Found at: https://www.reddit.com/r/dailyprogrammer/comments/pih8x/easy_challenge_1/
 * Submitted by Reddit user: nottoobadguy
 * Challenge: create a program that will ask the users name, age, and reddit username. 
 * 		Have it tell them the information back, in the format:
 * 		your name is (blank), you are (blank) years old, and your username is (blank).
 * 		For extra credit, have the program log this information in a file to be 
 * 		accessed later. 
 * 
 * USAGE: Run the program from your console. Challenge001_output.txt will appear in the
 * 		  working directory.
 * */

public class Challenge001 {

	public static void main(String[] args) {
		// Variables for name, age, reddit username
		String name = "";
		int age = 0;
		String redditUsername = "";

		// Create a buffered reader for keyboard console input
		try (ConsoleReader reader = new ConsoleReader(new InputStreamReader(System.in))) {
		
			// Get name
			name = reader.getValidString("What is your name? (e.g. John Smith)");
			
			// Get age
			age = reader.getValidInteger("What is your age? (e.g. 25)");
			
			// Get Reddit username
			redditUsername = reader.getValidString("What is your Reddit Username? (e.g. nottoobadguy)");
			
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
			
		} catch (IOException ex) {
			System.out.println("Could not close some resources. Exiting...");
			System.exit(0);
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
