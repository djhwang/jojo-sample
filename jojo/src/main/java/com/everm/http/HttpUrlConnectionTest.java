/**
 * HttpUrlConnectionTest.java 1.0 2014. 4. 24.
 *
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @date 2014. 4. 24.
 * @author david
 *
 */
public class HttpUrlConnectionTest{

	private void request(String url, String method){
		BufferedReader br = null;
		OutputStreamWriter writer = null;
		HttpURLConnection con = null;

		try{
			if ("GET".equals(method)){
				con = (HttpURLConnection) new URL(url).openConnection();
			}

			con.setRequestMethod(method);
			con.setConnectTimeout(1000);
			con.setReadTimeout(1000);
			con.connect();

			if (con.getResponseCode() != HttpURLConnection.HTTP_OK){
				System.out.println(con.getResponseCode() + ","
						+ con.getResponseMessage());
				return;
			}

			br = new BufferedReader(new InputStreamReader(con.getInputStream(),
					"UTF-8"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null){
				sb.append(line).append("\n");
			}

			System.out.println(sb.toString());
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			if (writer != null){
				try{
					writer.close();
					writer = null;
				} catch (Exception e2){
					e2.printStackTrace();
				}
			}

			if (br != null){
				try{
					br.close();
					br = null;
				} catch (Exception e2){
					e2.printStackTrace();
				}
			}

			con.disconnect();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		HttpUrlConnectionTest test = new HttpUrlConnectionTest();
		test.request("http://www.naver.com", "GET");
	}

}
