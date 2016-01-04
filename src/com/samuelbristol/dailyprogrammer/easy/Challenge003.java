package com.samuelbristol.dailyprogrammer.easy;

import com.samuelbristol.crypto.Cipher;
import com.samuelbristol.crypto.ShiftCipher;
import com.samuelbristol.strings.Strings;

/**
 * @author samuelbristol
 * Challenge 3 - Easy - Reddit Daily Programmer
 * Found at: https://www.reddit.com/r/dailyprogrammer/comments/pkw2m/2112012_challenge_3_easy/
 * Submitted by Reddit user: nottoobadguy
 * Challenge: Welcome to cipher day! 
 * 		Write a program that can encrypt texts with an alphabetical caesar cipher. This cipher 
 * 		can ignore numbers, symbols, and whitespace.
 * 
 * EXTRA CREDIT: add a "decrypt" function to your program!
 * 
 * */
public class Challenge003 {
	public static void main(String[] args) {
		
		char message[] = "Some say the world will end in fire".toCharArray();
		System.out.println("Message: " + new String(message));
		
		// Encode the message using a Shift/Rotation Cipher
		Cipher cipher = new ShiftCipher(Strings.getPrintableAsciiCharacters(), 3);
		char encodedMessage[] = cipher.encode(message);
		char decodedMessage[] = cipher.decode(encodedMessage);
		System.out.println("Encoded message: " + new String(encodedMessage));
		System.out.println("Decoded message: " + new String(decodedMessage));
	}
}
