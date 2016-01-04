package com.samuelbristol.strings;

/**
 * @author samuelbristol
 *	Description: A utility class for Strings
 */
public final class Strings {
	
	private Strings() {};
	
	public static char[] getPrintableAsciiCharacters() {
		int firstChar = 32; // space character
		int lastChar = 126; // ~ character
		
		char characters[] = getAscii(firstChar, lastChar);
		
		return characters;
	}
	
	public static char[] getEnglishAlphabetUpper() {
		int firstChar = 65; // A
		int lastChar = 90; // Z
		
		char characters[] = getAscii(firstChar, lastChar);
		
		return characters;
	}
	
	public static char[] getEnglishAlphabetLower() {
		int firstChar = 97; // A
		int lastChar = 122; // Z
		
		char characters[] = getAscii(firstChar, lastChar);
		
		return characters;
	}
	
	private static char[] getAscii(int firstChar, int lastChar){
		char characters[] = new char[lastChar - firstChar + 1];
		
		for (int i = 0; i < characters.length; i++) {
			// Fill the char array with the appropriate characters
			// Cast the integer to char for simplicity
			characters[i] = (char) (i + firstChar);
		}
		
		return characters;
	}
}
