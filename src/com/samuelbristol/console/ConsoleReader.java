package com.samuelbristol.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author samuelbristol
 * 
 * Description: A class to extend the functionality of a BufferedReader. The primary function
 * 		of this class is to get valid primitives from a Reader source.
 */

public class ConsoleReader extends BufferedReader {
	
	public ConsoleReader(Reader in) {
		super(in);
	}
	
	public String getValidString() {
		String value = "";
		
		boolean validValue = false;
		while (!validValue) {
			try {
				value = this.readLine();
				if (!value.isEmpty() && value != null) {
					validValue = true;
				} else {
					throw new IOException("Please enter a valid valud and try again.");
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return value;
	}
	
	public String getValidString(String message) {
		System.out.println(message);
		return getValidString();
	}
	
	public int getValidInteger() {
		int value = 0;
		
		boolean validValue = false;
		while (!validValue) {
			try {
				value = Integer.parseInt(this.readLine());
				validValue = true;
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid integer value and try again.");
			} catch (IOException ex) {
				System.out.println("Please enter a valid integer value and try again.");
			}
		}
		
		return value;
	}
	
	public int getValidInteger(String message) {
		System.out.println(message);
		return getValidInteger();
	}
	
	public double getValidDouble() {
		double value = 0.0;
		
		boolean validValue = false;
		while (!validValue) {
			try {
				value = Double.parseDouble(this.readLine());
				validValue = true;
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid decimal value and try again.");
			} catch (IOException ex) {
				System.out.println("Please enter a valid decimal value and try again.");
			}
		}
		
		return value;
	}
	
	public double getValidDouble(String message) {
		System.out.println(message);
		return getValidDouble();
	}
}
