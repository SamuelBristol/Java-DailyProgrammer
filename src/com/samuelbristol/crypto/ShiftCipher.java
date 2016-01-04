package com.samuelbristol.crypto;

/**
 * @author samuelbristol
 *
 */
public class ShiftCipher implements Cipher{
	// Class variables
	private int shiftAmount;
	private char[] characters;
	
	// Constructors
	public ShiftCipher(char[] characters, int shiftAmount) {
		this.characters  = characters;
		this.shiftAmount = shiftAmount;
	}
	
	// Methods
	public char[] encode(char[] message) {
		// encode the message with the shift amount
		String encodedMessage = "";
		for (int i = 0; i < message.length; i++) {
			int newValue = ((int) message[i]) + shiftAmount % (characters.length - 1);
			encodedMessage += (char) newValue;
		}
		
		return encodedMessage.toCharArray();
	}
	
	public char[] decode(char[] message) {
		// encode the message with the shift amount
		String decodedMessage = "";
		for (int i = 0; i < message.length; i++) {
			int newValue = ((int) message[i]) - shiftAmount % (characters.length - 1);
			decodedMessage += (char) newValue;
		}
		
		return decodedMessage.toCharArray();
	}
}
