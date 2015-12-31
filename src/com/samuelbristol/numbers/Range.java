/**
 * 
 */
package com.samuelbristol.numbers;

/**
 * @author samuelbristol
 * 
 * Description: A class to encapsulate Range-related behavior
 */
public final class Range {
	
	private Range () {};
	
	public static boolean intInRangeExclusive(int target, int first, int second) {
		int lower = Math.min(first, second);
		int higher = Math.max(first, second);
		boolean value;
		
		if (target > lower && target < higher) {
			value = true;
		} else {
			value = false;
		}
		
		return value;
	}
}
