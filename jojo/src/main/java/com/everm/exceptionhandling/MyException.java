package com.everm.exceptionhandling;

import java.io.IOException;

public class MyException extends IOException {
	public MyException(String s) {
		super(s);
	}

	public MyException(IOException e, String s) {
		super(s);
	}
	
	public MyException(IOException e, IOException e2, String s) {
		super(s);
	}
}
