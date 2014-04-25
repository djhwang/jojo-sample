/**
 * UUIDTest.java 1.0 2013. 12. 8.
 *
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.UUID;

import java.util.UUID;

/**
 * @date 2013. 12. 8.
 * @author david
 *
 */
public class UUIDTest{

	/**
	 * @param args
	 */
	public static void main(String[] args){

		for (int i = 0; i < 1000; i++){
			UUID uuid = UUID.randomUUID();

			System.out.println(uuid.toString());
		}
	}

}
