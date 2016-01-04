package com.samuelbristol.dailyprogrammer.easy;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import com.samuelbristol.console.ConsoleReader;
import com.samuelbristol.strings.Strings;

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
			int numberOfPasswords = reader.getValidInteger("Please specify the number of passwords to generate:");
			int passwordLength = reader.getValidInteger("Please specify the number of characters in each password:");
			
			long startTime = System.currentTimeMillis();
			StringBuilder allPasswords = new StringBuilder(numberOfPasswords);
			for(int i = 0; i < numberOfPasswords; i++) {
				allPasswords.append(createRandomPassword(passwordLength) + "\n");
			}
			long stopTime = System.currentTimeMillis();
			System.out.println("Created passwords in " + (stopTime - startTime) + "ms.");
			
			try {
				startTime = System.currentTimeMillis();
				
				Files.deleteIfExists(Paths.get("challenge004_output.txt"));
				Files.createFile(Paths.get("challenge004_output.txt"));
				Files.write(Paths.get("challenge004_output.txt"), allPasswords.toString().getBytes(), StandardOpenOption.WRITE);
				
				stopTime = System.currentTimeMillis();
				System.out.println("Wrote passwords in: " + (stopTime - startTime) + "ms.");
				
			} catch (IOException ex) {
				System.out.println("Could not write to file \"Challenge004_output.txt\"");
				ex.printStackTrace();				
			}
			
		} catch (IOException ex) {
			System.out.println("A fatal error has ocurred. The console may not be available. Exiting...");
			ex.printStackTrace();
			System.exit(0);
		}
	
	}

	private static String createRandomPassword(int passwordLength) {
		char characters[] = Strings.getPrintableAsciiCharacters();
		char password[] = new char[passwordLength];
		
		Random random = new Random();
		for (int i = 0; i < passwordLength; i++) {
			char randomCharacter = characters[random.nextInt(characters.length)];
			password[i] = randomCharacter;
		}
		
		return new String(password);
	}

}
