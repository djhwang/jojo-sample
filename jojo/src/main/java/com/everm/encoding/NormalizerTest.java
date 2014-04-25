package com.everm.encoding;

import java.text.Normalizer;

public class NormalizerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NormalizerTest test = new NormalizerTest();
		test.test();
		
		String string = "�ѱ�";
		for (int i = 0; i < string.length(); i++) {
		   System.out.print(String.format("U+%04X ", string.codePointAt (i)));
		}
		System.out.println();
		
		byte[] bytes = string.getBytes();
		for (byte b : bytes) {
		   System.out.print(String.format("0x%02X ", b));
		}
		System.out.println();
	}

	private void printIt(String string) {
		System.out.println(string);
		for (int i = 0; i < string.length(); i++) {
			System.out.print(String.format("U+%04X ", string.codePointAt(i)));
		}
		System.out.println();
	}

	public void test() {
		String han = "��";
		printIt(han);

		String nfd = Normalizer.normalize(han, Normalizer.Form.NFD);
		printIt(nfd);

		String nfc = Normalizer.normalize(nfd, Normalizer.Form.NFC);
		printIt(nfc);
		
		
	}

}
