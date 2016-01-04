/**
 * 
 */
package com.samuelbristol.crypto;

/**
 * @author samuelbristol
 *
 */
public interface Cipher {
	public char[] encode(char[] message);
	public char[] decode(char[] message);
}
