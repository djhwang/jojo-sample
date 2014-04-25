/**
 * Test.java 1.0 2013. 1. 15.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.testweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date 2013. 1. 15.
 * @author david
 *
 */
public class Test {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t =  new Test();
		t.test();
	}

	public void test() {
		logger.debug("test");
	}
}
