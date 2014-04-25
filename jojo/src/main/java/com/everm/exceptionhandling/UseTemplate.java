package com.everm.exceptionhandling;

import java.io.IOException;
import java.io.InputStream;

public class UseTemplate {
	public void use() {
		try {
			InputStreamProcessingTemplate.process("someFile.txt", new InputStreamProcessor() {
				
				@Override
				public void process(InputStream input) throws IOException {
					int inChar = input.read();
					while(inChar != -1) {
						//do something...
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
