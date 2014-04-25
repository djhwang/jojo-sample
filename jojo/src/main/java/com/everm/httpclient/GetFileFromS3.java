package com.everm.httpclient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetFileFromS3 {
	private String uri;
	private String date;
	private String authorzation;
	
	public GetFileFromS3(String uri, String date, String authorization) {
		this.uri = uri;
		this.date = date;
		this.authorzation = authorization;
	}
	
	public void request() {
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(this.uri);
		HttpResponse response = null;
		FileOutputStream fos = null;
		
		long startTime = System.currentTimeMillis();
		try {
			httpGet.addHeader("Date", this.date);
			httpGet.addHeader("Authorization", this.authorzation);
			response = client.execute(httpGet);
			System.out.println(response.getStatusLine());
			
			if (response.getStatusLine().getStatusCode() != 200) {
				return ;
			}
			
//			EntityUtils.consume(response.getEntity());
			InputStream inStream = response.getEntity().getContent();			
			String downloadPath = "";
			String fileName = "test";
						
			File f = new File(downloadPath + fileName);
			fos = new FileOutputStream(f);
			//
			ReadableByteChannel inChannel = Channels.newChannel(inStream);
			WritableByteChannel outChannel = Channels.newChannel(fos);
				
			boolean result = true;
			ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
			
			try {
				
				while( inChannel.read(buffer) != -1){
					buffer.flip();
					while (buffer.hasRemaining()){
						outChannel.write(buffer);
					}
					buffer.clear();
				}
			} catch (IOException e) {
				result = false;			
			} finally{
				try{
					inChannel.close();
					outChannel.close();
				} catch (IOException e1){
					e1.printStackTrace();
				}
			}
			//
			
			System.out.println("download path : " + f.getCanonicalPath());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Elapsed :" + (endTime-startTime));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//check arguemnts
		String params[] = checkArgs(args);
		
		if (params == null) {
			printUsage();
		}
		
		//set httpclient
		GetFileFromS3 get = new GetFileFromS3(params[0], params[1], params[2]);
		get.request();
	}
	
	public static void printUsage() {
		System.out.println("");
	}
	
	public static String[] checkArgs(String[] args) {
		String[] params = null;
		
		params = new String[3];
		// command arguements
//		params[0] = args[0];	//uri
//		params[1] = args[1];	//date
//		params[2] = args[2];	//authorization

		params[0] = "";	//uri
		params[1] = "";	//date
		params[2] = "";	//authorization
		
		return params;
	}
		

}
