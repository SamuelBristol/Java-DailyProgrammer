package com.samuelbristol.dailyprogrammer.easy;

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
			// variables for args[]
			String username = args[0];
			String password = args[1];
			
			validateLogin(username, password);
			
			System.out.println(String.format("Username: %s\nPassword: %s", username, password));
		} else {
			System.out.println("Usage: Challenge004.java [username] [password]");
			System.exit(0);
		}
	}

	private static void validateLogin(String username, String password) {
		// TODO Auto-generated method stub
		
	}

}
