package com.everm.exceptionhandling;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamProcessor {
	void process(InputStream input) throws IOException;
}
