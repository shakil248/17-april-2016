package com.sogeti.petstore.model;

import java.security.SecureRandom;
import java.util.Random;



public class Test {
	
	private static final String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$&@?<>~!%#";	
	
	
	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
//		System.out.println(new BigInteger(130, random).toString(32));
		
		
		final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$&@?<>~!%#";
		final int N = alphabet.length();
		Random rd = new Random();
		int iLength = 8;
		StringBuilder sb = new StringBuilder(iLength);
		for (int i = 0; i < iLength; i++) {
		    sb.append(alphabet.charAt(rd.nextInt(N)));
		}
		
		System.out.println(genPassword(new Random()));
	}
	
	public static String genPassword(Random r) {
	    while(true) {
	        char[] password = new char[8];
	        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
	        for(int i=0; i<password.length; i++) {
	            char ch = symbols.charAt(r.nextInt(symbols.length()));
	            if(Character.isUpperCase(ch))
	                hasUpper = true;
	            else if(Character.isLowerCase(ch))
	                hasLower = true;
	            else if(Character.isDigit(ch))
	                hasDigit = true;
	            else
	                hasSpecial = true;
	            password[i] = ch;
	        }
	        if(hasUpper && hasLower && hasDigit && hasSpecial) {
	            return new String(password);
	        }
	    }

	}}
