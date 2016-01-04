package com.samuelbristol.strings;

/**
 * @author samuelbristol
 *	Description: A class to extend the functionality of a BufferedReader. The primary function
 * 		of this class is to get valid primitives from a Reader source.
 */
public final class Strings {
	
	private Strings() {};
	
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
}
