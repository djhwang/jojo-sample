/**
 * CDATATest.java 1.0 2012. 9. 21.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.jaxb;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @date 2012. 9. 21.
 * @author Davd
 *
 */
public class CDATATest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		JAXBContext jc = JAXBContext.newInstance(Customer.class);
		
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		String xml = "<c><bio><![CDATA[<html>...</html>]]></bio></c>";
		Customer c = (Customer)unmarshaller.unmarshal(new StringReader(xml));
		System.out.println("Unmarshall: " + c.getBio());
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		System.out.println("Marshal: ");
		marshaller.marshal(c,  System.out);
	}
}
