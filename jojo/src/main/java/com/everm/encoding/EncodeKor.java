package com.everm.encoding;

import java.io.UnsupportedEncodingException;

public class EncodeKor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String fileEncoding=System.getProperty("file.encoding");
        System.out.println("file.encoding = "+fileEncoding);
 
        String s = "Ȳ����";
        try {
        	String toBinaryRaw = new String(s.getBytes() );
			System.out.println("Binary Raw Data:" + toBinaryRaw );
	//		ShowAllByte( toBinaryRaw );
	        	String toISO_8859 = new String(s.getBytes(),"ISO-8859-1");
			System.out.println("ISO-8859-1 Encoding : " + toISO_8859 );
	//		ShowAllByte( toISO_8859 );
			String toUtf_8 = new String(s.getBytes(),"utf-8");
			System.out.println("UTF-8 Encoding : " + toUtf_8);
	//		ShowAllByte( toUtf_8 );
			String toEUCKR = new String(s.getBytes(),"euc-kr");
			System.out.println("toEUCKR Encoding : " + toEUCKR );
	//		ShowAllByte( toEUCKR );
			String toUTF8_EUCKR = new String( s.getBytes("utf-8"),"euc-kr");
			System.out.println("toUTF8_EUCKR Encoding : " + toUTF8_EUCKR );
	//		ShowAllByte( toUTF8_EUCKR  );
			String toksc5601 = new String(s.getBytes(),"KSC5601");
			System.out.println("KSC5601 Encoding : " + toksc5601);			
	//		ShowAllByte( toksc5601 );
			String toms949 = new String(s.getBytes(),"ms949");
			System.out.println("MS949 Encoding : " + toms949);			
	//		ShowAllByte( toms949 );
	 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
