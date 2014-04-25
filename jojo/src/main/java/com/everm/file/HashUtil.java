/**
 * HashUtil.java 1.0 2013. 1. 23.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Formatter;

/**
 * @date 2013. 1. 23.
 * @author david
 *
 */
public class HashUtil {
	/**
	 * 
	 * @param algorithm
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String calculateHash(MessageDigest algorithm, String fileName) throws Exception{
		File f = new File(fileName);
		System.out.println(f.getAbsolutePath());
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DigestInputStream dis = new DigestInputStream(bis, algorithm);
		
		while (dis.read() != -1) {
		}
		
		byte[] hash = algorithm.digest();
		
		return byteArray2Hex(hash);
	}
	
	/**
	 * 
	 * @param hash
	 * @return
	 */
	public static String byteArray2Hex(byte[] hash) {
		Formatter formatter = new Formatter();
		
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		
		return formatter.toString();
	}
}
