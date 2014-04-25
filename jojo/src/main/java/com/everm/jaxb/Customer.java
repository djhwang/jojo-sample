/**
 * Customer.java 1.0 2012. 9. 21.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @date 2012. 9. 21.
 * @author Davd
 *
 */
@XmlRootElement(name="c")
public class Customer {
	private String bio;

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
