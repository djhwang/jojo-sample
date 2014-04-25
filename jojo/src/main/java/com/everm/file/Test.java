/**
 * Test.java 1.0 2013. 1. 23.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.file;

import java.security.MessageDigest;

/**
 * @date 2013. 1. 23.
 * @author david
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String fileName = "D:\\cloudprint\\workapces\\testWeb\\target\\classes\\com\\score\\file\\aaa.jpg";
		String fileName = "aaa.jpg";
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			System.out.println(HashUtil.calculateHash(md5, fileName));
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
