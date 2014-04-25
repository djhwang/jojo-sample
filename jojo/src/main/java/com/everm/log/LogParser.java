package com.everm.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class LogParser {
	private String LOG_FILE_NAME = "D:\\ProcessTime.log";
	
	public void parse() {
		File logFile = new File(LOG_FILE_NAME);
		String line = null;
		
		if (!logFile.exists()) {
			return;
		}
		
		Gson gson = new Gson();
		FileInputStream fis = null;
		BufferedReader reader = null;
		
		try {
			fis = new FileInputStream(logFile);
			reader = new BufferedReader(new InputStreamReader(fis));
			while ( (line = reader.readLine() ) != null ) {
				JobInfo jobInfo = gson.fromJson(line, JobInfo.class);
				System.out.println(jobInfo.getJobId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LogParser logParser = new LogParser();
		logParser.parse();
	}

}
