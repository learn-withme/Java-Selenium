package com.filehandling.demo;

import java.io.FileWriter;
import java.io.IOException;

public class fileDemo {

	public static void main(String[] args) throws IOException {
		
		String location ="fileWritingdemo.txt";
		String content = "My First File writing";
		
		FileWriter fileWriter = new FileWriter(location);
		fileWriter.write(content);
		fileWriter.close();
		

	}

}
