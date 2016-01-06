package com.samuelbristol.dailyprogrammer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author samuelbristol
 * Found at: https://www.reddit.com/r/dailyprogrammer/comments/pnhyn/2122012_challenge_5_easy/
 * Submitted by Reddit user: nottoobadguy
 * Challenge: Your challenge for today is to create a program which is password protected, 
 * 		and wont open unless the correct user and password is given.
 * Extra credit: For extra credit, have the user and password in a separate .txt file.
 * 		for even more extra credit, break into your own program :)
 */
public class Challenge005 {

	public static void main(String[] args) {
		if(args.length == 2) {
			// Variables for args[]
			String username = String.valueOf(args[0]);
			String password = getSha1(String.valueOf(args[1]));
			
			// Validate and login
			if (validateLogin(username, password)) {
				System.out.println("Logged in!");
			} else {
				System.out.println("Access denied, please enter proper credentials and try again.");
				System.exit(0);
			}
			
		} else {
			System.out.println("Help: Challenge004.java [username] [password]");
			System.exit(0);
		}
	}

	private static boolean validateLogin(String username, String password) {
		// Reads challenge005_input.txt for usernames and hashed passwords
		// Compares username and password to the lines in the file
		// Returns true if username/password match a found user
		// Returns false if a user was not found or the password does not match
		Path filePath = Paths.get("challenge005_input.txt");
		try (BufferedReader reader = Files.newBufferedReader(filePath)){
			if(Files.exists(filePath)){
				String line = null;
				while ((line = reader.readLine()) != null){
					String values[] = line.split(",");
					String thisUser = values[0];
					String thisPass = values[1];
					
					if (username.equals(thisUser) && password.equals(thisPass)){
						return true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	private static String getSha1(String message) {
		// Returns hexString of the message
		// Returns null if SHA-1 is not available
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			sha1.update(message.getBytes(), 0, message.length());
			String hashedHexString = new BigInteger(1, sha1.digest()).toString(16);
			return hashedHexString;
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			System.out.println("SHA-1 is not available on this system.");
			return null;
		}
	}
}
