/**
 * AzureBlobServiceTest.java 1.0 2013. 8. 14.
 *   
 * Copyright 2012 S-Core, Inc. All rights reserved.
 * S-Core PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.everm.azure;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.microsoft.windowsazure.services.core.storage.utils.Base64;

/**
 * @date 2013. 8. 14.
 * @author david
 *
 */
public class AzureBlobServiceTest{
	private String conectProtoCal = "DefaultEndpointsProtocol=http;";
	private String accountName = "cpsqueuetest01";
	private String accessKey = "RhGb8jssjiwbFKFt4VcIal8F3MmPW6l2UCX7IKstO+JCtduLxatSbJdOOwjngKAlSzu6k+sg9WYN3jHKv12D8Q==";
	private static Base64 base64;

	private String createAuthorizationHeader(String canonicalizedString)
			throws Exception{
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(Base64.decode(accessKey), "HmacSHA256"));
		String authKey = new String(Base64.encode(mac
				.doFinal(canonicalizedString.getBytes("UTF-8"))));
		String authStr = "SharedKey " + accountName + ":" + authKey;
		return authStr;
	}

	public void testRestAddFileByHeaders() throws Exception{
		// Create or overwrite the "myimage.jpg" blob with contents from a local file
		String testFilePath = "C:\\Users\\david\\Desktop\\aws\\ec2.PNG"
				.replace("\\", File.separator);
		File source = new File(testFilePath);

		String imgUrl = "http://cpsqueuetest01.blob.core.windows.net/mycontainer/myimage.jpg";
		String requestMethod = "PUT";
		String urlPath = "mycontainer" + "/" + source.getName();
		String storageServiceVersion = "2009-09-19";

		SimpleDateFormat fmt = new SimpleDateFormat(
				"EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
		fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
		String date = fmt.format(Calendar.getInstance().getTime()) + " GMT";

		System.out.println(date);

		String blobType = "BlockBlob"; //This is important as there are two types of blob, Page blob and Block blob  
		String canonicalizedHeaders = "x-ms-blob-type:" + blobType
				+ "\nx-ms-date:" + date + "\nx-ms-version:"
				+ storageServiceVersion;
		String canonicalizedResource = "/" + accountName + "/" + urlPath;

		//This will change based on the Authentication scheme you are using. This is for SharedKey, you need to change it if you are using SharedKeyLite
		String stringToSign = requestMethod + "\n\n\n" + source.length()
				+ "\n\n\n\n\n\n\n\n\n" + canonicalizedHeaders + "\n"
				+ canonicalizedResource;
		String authorizationHeader = createAuthorizationHeader(stringToSign);

		URI uri = new URI("https://cpsqueuetest01.blob.core.windows.net/"
				+ urlPath);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPut req = new HttpPut(uri);

		req.setHeader("Authorization", authorizationHeader);
		req.setHeader("x-ms-blob-type", blobType);
		req.setHeader("x-ms-date", date);
		req.setHeader("x-ms-version", storageServiceVersion);

		//There are different types of Entities here we are using File so we are taking FileEntity
		//Please refer JavaDocs for more info on types of Entities
		FileEntity fe = new FileEntity(source);
		req.setEntity(fe);
		HttpResponse response = httpClient.execute(req);
		if (response.getStatusLine().getStatusCode() != 201){
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}
		System.out.println("Check it on cloud...!");
		httpClient.getConnectionManager().shutdown();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		AzureBlobServiceTest blob = new AzureBlobServiceTest();
		blob.testRestAddFileByHeaders();
	}

}
