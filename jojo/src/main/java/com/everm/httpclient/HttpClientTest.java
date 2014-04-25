/**
 * HttpClientTest.java 1.0 2012. 9. 13.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @date 2012. 9. 13.
 * @author Davd
 *
 */
public class HttpClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String uri="http://samsung-cps-000.s3.amazonaws.com/PDF/-137219737027956571";
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(uri);
		HttpResponse response = null;
		
		long startTime = System.currentTimeMillis();
		try {
			httpGet.addHeader("Date", "Mon, 18 Feb 2013 08:14:01 GMT");
			httpGet.addHeader("Authorization", "AWS AKIAIULRL33KVNJCCNAQ:ac4P+U1n+ib/PkOCqyuH4lt9hK8=");
//			for (int i = 0; i < 100; i++) {
				response = client.execute(httpGet);
//				System.out.println(i + "___" + response.getStatusLine());
				System.out.println(response.getStatusLine());
				EntityUtils.consume(response.getEntity());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("elapsed time :" + (endTime-startTime));
	}

}
