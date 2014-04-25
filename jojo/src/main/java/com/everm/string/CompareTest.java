/**
 * App.java 1.0 2012. 11. 6.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.string;

/**
 * @date 2012. 11. 6.
 * @author Davd
 *
 */
public class CompareTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String data = "!";
		
		if (data.equals("!")) {
			data = "Success";
		}
		else {
			data = "Fail";
		}
		
		System.out.println(data);
	}

}
