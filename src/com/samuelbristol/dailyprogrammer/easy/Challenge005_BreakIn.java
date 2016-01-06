/**
 * 
 */
package com.samuelbristol.dailyprogrammer.easy;

/**
 * @author samuelbristol
 * Found at: https://www.reddit.com/r/dailyprogrammer/comments/pnhyn/2122012_challenge_5_easy/
 * Submitted by Reddit user: nottoobadguy
 * 
 * Extra credit: For extra credit, have the user and password in a separate .txt file.
 * 		for even more extra credit, break into your own program :)
 */
public class Challenge005_BreakIn {


	public static void main(String[] args) {
		System.out.println("Breaking in...");
		breakIn("username", "password");
	}

	private static void breakIn(String username, String password) {
		String args[] = { username, password };
		Challenge005.main(args);
	}

}
