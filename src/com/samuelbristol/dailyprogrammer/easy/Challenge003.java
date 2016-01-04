package com.samuelbristol.dailyprogrammer.easy;

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
		// Get the common available characters to work with
		char chars[] = getPrintableAsciiCharacters();
		
		char message[] = "Some say the world will end in fire".toCharArray();
		System.out.println("Message: " + new String(message));
		
		// Encode the message with shift 3
		char encodedMessage[] = encode(message, chars, 3);
		System.out.println("Encoded message: " + new String(encode(message, chars, 3)));
		System.out.println("Decoded message: " + new String(decode(encodedMessage, chars, 3)));
	}
	
	public static char[] getPrintableAsciiCharacters() {
		int firstChar = 32; // space character
		int lastChar = 126; // ~ character
		
		// Properly size the char array
		char chars[] = new char[lastChar - firstChar + 1];
		for (int i = 0; i < chars.length; i++) {
			// Fill the char array with the appropriate characters
			// Cast the integer to char for simplicity
			chars[i] = (char) (i + firstChar);
		}
		
		return chars;
	}
	
	public static char[] encode(char[] message, char[] chars, int shift) {
		// encode the message with the shift amount
		String encodedMessage = "";
		for (int i = 0; i < message.length; i++) {
			int newValue = ((int) message[i]) + shift % (chars.length - 1);
			encodedMessage += (char) newValue;
		}
		
		return encodedMessage.toCharArray();
	}
	
	public static char[] decode(char[] message, char[] chars, int shift) {
		// encode the message with the shift amount
		String decodedMessage = "";
		for (int i = 0; i < message.length; i++) {
			int newValue = ((int) message[i]) - shift % (chars.length - 1);
			decodedMessage += (char) newValue;
		}
		
		return decodedMessage.toCharArray();
	}
}
